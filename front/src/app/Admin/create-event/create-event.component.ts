import { Component } from '@angular/core';

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.scss']
})
export class CreateEventComponent {

  image: File | null = null;
   formatDate(date: Date): string {
    const formattedDate = new Date(date).toISOString().split('T')[0];
    return formattedDate;
  }
  onFileSelected(event: any) {
    const file: File | null = event.target.files[0];
    if (file) {
        this.image = file;
    }
  }

  getObjectURL(file: File | null): string {
      if (file) {
          return URL.createObjectURL(file);
      }
      return '';
  }
  convertImageUrlToFile(imageUrl: string): Promise<File> {
    return fetch(imageUrl)
      .then(response => response.blob())
      .then(blob => {
        const file = new File([blob], 'animalImage', { type: blob.type });
        return Promise.resolve(file);
      })
      .catch(error => {
        console.error('Error fetching image:', error);
        return Promise.reject(error);
      });
  }
  return(){

  }
  submitForm(){

  }

}
