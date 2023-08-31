import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Eventgame } from '../models/Eventgames.model';

@Injectable({
  providedIn: 'root'
})
export class EventgamesService {
  private baseUrl = 'http://localhost:8000'

  constructor(private http: HttpClient) { }

  createEventGame(eventGame: Eventgame): Observable<Eventgame> {
    return this.http.post<Eventgame>(`${this.baseUrl}/eventgames`, eventGame); 
  }
  getEventGame(id: number): Observable<Eventgame> {
    return this.http.get<any>(`${this.baseUrl}/eventgames/`+ id);
  }
  updateEventGame(id: number,eventgame: Eventgame): Observable<Eventgame> { 
    return this.http.put<Eventgame>(`${this.baseUrl}/eventgames/`+ id, eventgame);
  }
}
