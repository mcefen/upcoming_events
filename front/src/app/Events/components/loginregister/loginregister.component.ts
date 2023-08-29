import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserService } from '../../../services/user.service';

interface User {
  id: number;
  name: string;
  role: string;
  password: string;
}

@Component({
  selector: 'app-loginregister',
  templateUrl: './loginregister.component.html',
  styleUrls: ['./loginregister.component.scss']
})
export class LoginregisterComponent {
  name: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private router: Router, private http: HttpClient, private userService: UserService) {}

  login() {
    this.http.get<User[]>('http://localhost:8000/user').subscribe((users: User[]) => {
      const foundUser = users.find(u => u.name === this.name && u.password === this.password);
      if (foundUser) {
        this.userService.setUsername(foundUser.name);
        this.router.navigate(['/home']);
      } else {
        this.errorMessage = 'The data entered are not correct, please check them.';
      }
    });
  }
}
