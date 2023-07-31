import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CombinedPageComponent } from './Events/components/combined-page/combined-page.component';

const routes: Routes = [

  { path: 'combined-page', component: CombinedPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
