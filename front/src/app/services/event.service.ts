import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  listournotment1: any[] = [];

  constructor(private http: HttpClient) { }

  getUpcomingEvents() {
    this.http.get<any[]>('http://localhost:8000/eventgames')
    .subscribe(listtournoment =>
      {this.listournotment1 = listtournoment}
      
      )
  }
}
