import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GatheringListComponent } from './gathering-list.component';

describe('GatheringListComponent', () => {
  let component: GatheringListComponent;
  let fixture: ComponentFixture<GatheringListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GatheringListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GatheringListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
