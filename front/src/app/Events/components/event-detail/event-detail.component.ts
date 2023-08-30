import { Component, OnInit } from '@angular/core';
import { EventService } from '../../../services/event.service';
@Component({
  selector: 'app-event-detail',
  templateUrl: './event-detail.component.html',
  styleUrls: ['./event-detail.component.scss']
})
export class EventDetailComponent implements OnInit {

  events: any[] = [];

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.getUpcomingEvents().subscribe(data => {
      this.events = data;
    });
  }
}
