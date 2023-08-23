import { Component, OnInit } from '@angular/core';
import { EventService } from '../../../services/event.service';

@Component({
  selector: 'app-upcoming-events',
  templateUrl: './upcoming-events.component.html',
  styleUrls: ['./upcoming-events.component.scss']
})
export class UpcomingEventsComponent implements OnInit {

  upcomingEvents: any[] = [];

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.getUpcomingEvents().subscribe((events: any[]) => {
      const currentDate = new Date();
      this.upcomingEvents = events.filter(event => new Date(event.publicationevent) > currentDate);
      this.upcomingEvents.sort((a, b) => new Date(a.publicationevent).getTime() - new Date(b.publicationevent).getTime());
    });
  }
}
