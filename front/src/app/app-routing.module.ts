import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginregisterComponent } from './Events/components/loginregister/loginregister.component';
import { FooterComponent } from './shared/footer/footer.component';

const routes: Routes = [
 
    { path: '', component: LoginregisterComponent, },
    { path: 'Footer', component: FooterComponent },
    
  ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
