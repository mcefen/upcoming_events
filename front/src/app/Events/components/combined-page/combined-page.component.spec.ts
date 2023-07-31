import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CombinedPageComponent } from './combined-page.component';

describe('CombinedPageComponent', () => {
  let component: CombinedPageComponent;
  let fixture: ComponentFixture<CombinedPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CombinedPageComponent]
    });
    fixture = TestBed.createComponent(CombinedPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
