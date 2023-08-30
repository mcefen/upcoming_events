import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

}

document.addEventListener('DOMContentLoaded', function () {
  const hamburgerMenu = document.querySelector('.hamburger-menu');
  const nav = document.querySelector('.nav');

  hamburgerMenu?.addEventListener('click', function () {
    nav?.classList.toggle('active');
  });
});