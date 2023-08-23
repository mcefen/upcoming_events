import { Component, OnInit } from '@angular/core';
import { EventService } from '../../../services/event.service';
@Component({
  selector: 'app-past-events',
  templateUrl: './past-events.component.html',
  styleUrls: ['./past-events.component.scss']
})
export class PastEventsComponent implements OnInit {

  pastEvents: any[] = [];

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.getUpcomingEvents().subscribe((events: any[]) => {
      const currentDate = new Date();
      this.pastEvents = events.filter(event => new Date(event.publicationevent) < currentDate);
      this.pastEvents.sort((a, b) => new Date(b.publicationevent).getTime() - new Date(a.publicationevent).getTime());
    });
  }
}