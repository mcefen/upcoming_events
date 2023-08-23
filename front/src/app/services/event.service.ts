import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class EventService {
  listournotment1: any[] = [];

  constructor(private http: HttpClient) { }

  getUpcomingEvents(): Observable<any[]> {
  
    return this.http.get<any[]>('http://localhost:8000/eventgames');
  }
}