import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  events: any[] = [
 
  
  ];

  constructor() { }

  ngOnInit(): void {
    this.filterUpcomingEvents();
  }

  filterUpcomingEvents(): void {
    const currentDate = new Date().getTime();

    this.events = this.events.filter(event => event.publicationevent > currentDate);
  }

}