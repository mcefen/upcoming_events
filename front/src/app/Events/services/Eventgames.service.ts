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

}
