import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginregisterComponent } from './Events/components/loginregister/loginregister.component';
import { FooterComponent } from './shared/footer/footer.component';
import { AppComponent } from './app.component';
import { PageregisterComponent } from './Events/components/pageregister/pageregister.component';
import { HomeComponent } from './Events/views/home/home.component';

const routes: Routes = [
  
  { path: '', component: AppComponent},
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginregisterComponent, },
  { path: 'footer', component: FooterComponent },
  { path: 'register', component: PageregisterComponent },
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
