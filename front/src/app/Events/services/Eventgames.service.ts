import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Eventgame } from '../models/Eventgames.model';

@Injectable({
  providedIn: 'root'
})
export class EventgamesService {
  private baseUrl = 'http://localhost:8080'
  constructor(private http:HttpClient) {  }
  
  create(Eventgame:object):Observable<object>{
    return this.http.post( this.baseUrl+'Eventgames/' ,Eventgame);
  }

}
