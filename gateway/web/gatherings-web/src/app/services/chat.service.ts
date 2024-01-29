import {Injectable, OnDestroy} from '@angular/core';
import {Observable} from "rxjs";
import {io} from "socket.io-client";
import {Message} from "../types";

@Injectable({
  providedIn: 'root'
})
export class ChatService implements OnDestroy {
  private socket: any;

  constructor() {
    this.initializeConnection();
  }

  ngOnDestroy(): void {
    this.socket.disconnect();
  }

  initializeConnection(): void {
    console.log('Init connection');
    this.socket = io('http://localhost:8878', {transports: ['websocket']});

    this.socket.on('connect', (sock: any) => console.log('connected'));
    this.socket.on('connect_error', (error: any) => console.error(error));
  }

  getMessage(): Observable<Message> {
    return new Observable<Message>(observer => {
      this.socket.on('read_message', (data: Message) => {
        observer.next(data);
      });
    });
  }

  public emit(data: Message): void {
    this.socket.emit('send_message', data);
  }
}
