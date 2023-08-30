import { Component, OnInit } from '@angular/core';
import { EventService } from '../../../services/event.service';

@Component({
  selector: 'app-upcoming-events',
  templateUrl: './upcoming-events.component.html',
  styleUrls: ['./upcoming-events.component.scss']
})
export class UpcomingEventsComponent implements OnInit {

  upcomingEvents: any[] = [];
  itemsPerPage: number = 3;
  currentPage: number = 1;
  totalPages: number[] = [];

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.loadEventsByPage(this.currentPage);
  }

  loadEventsByPage(page: number): void {
    this.eventService.getUpcomingEvents().subscribe((events: any[]) => {
      const currentDate = new Date();
      this.upcomingEvents = events.filter(event => new Date(event.publicationevent) > currentDate);
      this.upcomingEvents.sort((a, b) => new Date(a.publicationevent).getTime() - new Date(b.publicationevent).getTime());

      this.totalPages = Array.from({ length: Math.ceil(this.upcomingEvents.length / this.itemsPerPage) }, (_, i) => i + 1);


      this.upcomingEvents = this.upcomingEvents.slice((page - 1) * this.itemsPerPage, page * this.itemsPerPage);
    });
  }

  goToPage(page: number): void {
    if (page >= 1 && page <= this.totalPages.length) {
      this.currentPage = page;
      this.loadEventsByPage(page);
    }
  }

  goToPreviousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.loadEventsByPage(this.currentPage);
    }
  }

  goToNextPage(): void {
    if (this.currentPage < this.totalPages.length) {
      this.currentPage++;
      this.loadEventsByPage(this.currentPage);
    }
  }
}
