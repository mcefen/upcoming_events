import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Game } from '../models/Games.model';

@Injectable({
  providedIn: 'root'
})
export class GamesService {
  private baseUrl = 'http://localhost:8000'
  constructor(private http:HttpClient) {  }
  
  
  getAll():Observable<Game[]>{
    return this.http.get<Game[]>(this.baseUrl + "/games");
  }

}
