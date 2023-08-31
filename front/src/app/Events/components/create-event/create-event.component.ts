import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { GamesService } from 'src/app/Events/services/Games.service';
import { EventgamesService } from 'src/app/Events/services/Eventgames.service';
import { Game } from 'src/app/Events/models/Games.model';
import { Eventgame } from 'src/app/Events/models/Eventgames.model';

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.scss']
})
export class CreateEventComponent implements OnInit {
  games: Game[] = [];
  selectedGame: number | undefined;
  eventName: string = ''; 
  eventDescription: string = ''; 
  limitparticipants: number = 0;
  image: File | null = null;
  @ViewChild('imageInput') imageInputRef!: ElementRef;
  @ViewChild('selectedImage') selectedImage!: ElementRef;
  eventDate: string = '';
  constructor(
    private gamesService: GamesService,
    private eventGamesService: EventgamesService
  ) {}


  ngOnInit(): void {
    this.loadGames();
  }

  loadGames(): void {
    this.gamesService.getAll().subscribe((games: Game[]) => {
      this.games = games;
    });
  }
  onFileImageClick(): void {
    const fileInput: HTMLInputElement | null = this.imageInputRef.nativeElement;
    if (fileInput) {
      fileInput.click();
    }
  }
  
  formatDate(date: Date): string {
    const formattedDate = new Date(date).toISOString().split('T')[0];
    return formattedDate;
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

  convertImageUrlToFile(imageUrl: string): Promise<File> {
    return fetch(imageUrl)
      .then(response => response.blob())
      .then(blob => {
        const file = new File([blob], 'animalImage', { type: blob.type });
        return Promise.resolve(file);
      })
      .catch(error => {
        console.error('Error fetching image:', error);
        return Promise.reject(error);
      });
  }
  returnBack() {
  }
  submitForm() {
    
    const newEventGame: Eventgame = {
      id_eventgame: 0,
      title: this.eventName,
      publicationevent: this.eventDate,
      participants: 0,
      limitparticipants: this.limitparticipants,
      description: this.eventDescription,
      image: this.image ? this.image.name : '',
      id_game: this.selectedGame || 0,
      id_user: ''
    };
    
    console.log("New event game data:", newEventGame);
  
    this.eventGamesService.createEventGame(newEventGame).subscribe(
      (createdEventGame: Eventgame) => {
     
      },
      (error) => {
        console.error('Error creating event game:', error);
      }
    );
  }
}