import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginregisterComponent } from './Events/components/loginregister/loginregister.component';
import { FooterComponent } from './shared/footer/footer.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  
    { path: '', component: AppComponent},
    { path: 'Login', component: LoginregisterComponent, },
    { path: 'Footer', component: FooterComponent },
    
  ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
