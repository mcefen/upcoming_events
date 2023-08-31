import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-pageregister',
  templateUrl: './pageregister.component.html',
  styleUrls: ['./pageregister.component.scss']
})
export class PageregisterComponent {
  name: string = '';
  surname: string = '';
  username: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  errorMessage: string = '';

  register() {
   
  }
}
