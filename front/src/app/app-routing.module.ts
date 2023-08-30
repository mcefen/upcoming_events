import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginregisterComponent } from './Events/components/loginregister/loginregister.component';
import { FooterComponent } from './shared/footer/footer.component';
import { AppComponent } from './app.component';

import { EditEventComponent } from './Events/components/edit-event/edit-event.component';
import { CreateEventComponent } from './Events/components/create-event/create-event.component';
import { PageregisterComponent } from './Events/components/pageregister/pageregister.component';
import { HomeComponent } from './Events/views/home/home.component';
const routes: Routes = [
  
    { path: '', redirectTo: '/home', pathMatch: 'full'},
    { path: 'Login', component: LoginregisterComponent, },
    { path: 'Footer', component: FooterComponent },
    { path: 'edit-event/:eventId', component: EditEventComponent },
    { path: 'add-event', component: CreateEventComponent },
    { path: 'home', component: HomeComponent },
    { path: 'register', component: PageregisterComponent },
  ];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }



  
  
  
  






