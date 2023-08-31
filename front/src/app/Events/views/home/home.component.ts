import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  ngOnInit(): void {
    this.readtournament();
}

listtournament1: any[] = []; 

constructor( private http: HttpClient, private router: Router){}

readtournament(){

  this.http.get<any[]>('http://localhost:8000/eventgames')
  .subscribe(listtournament => 
    {
      this.listtournament1 =  listtournament;
       
    });


}

}
