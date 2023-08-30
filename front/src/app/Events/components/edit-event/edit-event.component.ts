import { Component, ViewChild, ElementRef, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { GamesService } from 'src/app/Events/services/Games.service';
import { EventgamesService } from 'src/app/Events/services/Eventgames.service';
import { Game } from 'src/app/Events/models/Games.model';
import { Eventgame } from 'src/app/Events/models/Eventgames.model';
import { User } from '../../models/users.model';

@Component({
  selector: 'app-edit-event',
  templateUrl: './edit-event.component.html',
  styleUrls: ['./edit-event.component.scss']
})
export class EditEventComponent implements OnInit {
  games: Game[] = [];
  selectedGame: Number | undefined;
  eventName: string = '';
  eventDescription: string = '';
  limitparticipants: Number = 0;
  participants: Number=0;
  id_user: User| null |undefined|"" ;
  image: File | null = null;
  @ViewChild('imageInput') imageInputRef!: ElementRef;
  @ViewChild('selectedImage') selectedImage!: ElementRef;
  eventDate: string = '';
  eventId: number;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private gamesService: GamesService,
    private eventGamesService: EventgamesService,
    private changeDetectorRef: ChangeDetectorRef,
  ) {
    this.eventId = Number(this.route.snapshot.paramMap.get('eventId'));
  }
  ngOnInit(): void {
    this.loadGames();
    this.loadEventDetails();
    this.changeDetectorRef.markForCheck();
  }
  
  loadGames(): void {
    this.gamesService.getAll().subscribe((games: Game[]) => {
      this.games = games;
    });
  }

  loadEventDetails(): void {
    this.eventGamesService.getEventGame(this.eventId).subscribe(
      (eventGame: Eventgame) => {
        this.eventName = eventGame.title;
        this.selectedGame = eventGame.id_game;
        const publicationEventDate = new Date(Number(eventGame.publicationevent)); 
      
        this.eventDate = this.formatDate(publicationEventDate);
        this.limitparticipants = eventGame.limitparticipants;
        this.eventDescription = eventGame.description;
        this.participants = eventGame.participants;
        this.id_user= eventGame.id_user;
        if (eventGame.image) {
          const selectedImageElement: HTMLImageElement = this.selectedImage.nativeElement;
          selectedImageElement.src ="../../../../assets/img/" +eventGame.image;
        }
      },
      (error) => {
        console.error('Error loading event details:', error);
      }
    );

  }
  
  formatDate(date: Date): string {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }
  
  onFileImageClick(): void {
    const fileInput: HTMLInputElement | null = this.imageInputRef.nativeElement;
    if (fileInput) {
      fileInput.click();
    }
  }

  onFileSelected(event: any) {
    const file: File | null = event.target.files[0];
    if (file) {
      this.image = file;
      const selectedImageElement: HTMLImageElement = this.selectedImage.nativeElement;
      selectedImageElement.src = this.getObjectURL(this.image);
    }
  }

  getObjectURL(file: File | null): string {
    if (file) {
      return URL.createObjectURL(file);
    }
    return '';
  }

  returnBack() {
    this.location.back();
  }

  submitForm() {
   
    const updatedEventGame: Eventgame = {
      id_eventgame: this.eventId,
      title: this.eventName,
      publicationevent: this.eventDate,
      participants: this.participants,
      limitparticipants: this.limitparticipants,
      description: this.eventDescription,
      image: this.image ? this.image.name : '',
      id_game: this.selectedGame as number,
      id_user: this.id_user
    };
    
    console.log("Updated event game data:", updatedEventGame);

    this.eventGamesService.updateEventGame(this.eventId,updatedEventGame).subscribe(
      (updatedEventGame: Eventgame) => {
        console.log('Event game updated:', updatedEventGame);
      },
      (error) => {
        console.error('Error updating event game:', error);
      }
    );
  }
}
