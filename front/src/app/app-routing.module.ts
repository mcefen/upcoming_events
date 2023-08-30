import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginregisterComponent } from './Events/components/loginregister/loginregister.component';
import { FooterComponent } from './shared/footer/footer.component';
import { AppComponent } from './app.component';
import { EditEventComponent } from './Events/components/edit-event/edit-event.component';
import { CreateEventComponent } from './Events/components/create-event/create-event.component';
const routes: Routes = [
  
    { path: '', component: AppComponent},
    { path: 'Login', component: LoginregisterComponent, },
    { path: 'Footer', component: FooterComponent },
    { path: 'edit-event/:eventId', component: EditEventComponent },
    { path: 'add-event', component: CreateEventComponent },
  ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
