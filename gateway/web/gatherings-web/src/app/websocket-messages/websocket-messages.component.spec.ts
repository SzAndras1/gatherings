import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebsocketMessagesComponent } from './websocket-messages.component';

describe('WebsocketMessagesComponent', () => {
  let component: WebsocketMessagesComponent;
  let fixture: ComponentFixture<WebsocketMessagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WebsocketMessagesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WebsocketMessagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
