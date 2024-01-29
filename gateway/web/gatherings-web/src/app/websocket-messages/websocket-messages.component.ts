import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {Message} from "../types";
import {ChatService} from "../services/chat.service";

@Component({
  selector: 'app-websocket-messages',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './websocket-messages.component.html',
  styleUrl: './websocket-messages.component.scss',
  providers: [ChatService]
})
export class WebsocketMessagesComponent implements OnInit {
  text!: string;
  sentMessages: string[] = [];
  receivedMessages: string[] = [];
  senderName: string = "user1";
  group: string = 'room1';
  sentMessages2: string[] = [];
  receivedMessages2: string[] = [];

  constructor(public socketService: ChatService) {
  }

  ngOnInit(): void {
    this.socketService.getMessage()
      .subscribe((data: Message) => {
        console.log(data);
        this.separateMessages(data);
      });
  }

  separateMessages(message: Message): void {
    console.log(`${message.senderName} ${message.groupId} ${message.text}`);
    if (message.groupId == 'room1') {
      if (message.senderName == 'user1') {
        this.receivedMessages.push(`User ${message.senderName} said: ${message.text} to ${message.groupId} group`);
      } else {
        this.sentMessages.push(`User ${message.senderName} said: ${message.text} to ${message.groupId} group`);
      }
    } else {
      if (message.senderName == 'user1') {
        this.receivedMessages2.push(`User ${message.senderName} said: ${message.text} to ${message.groupId} group`);
      } else {
        this.sentMessages2.push(`User ${message.senderName} said: ${message.text} to ${message.groupId} group`);
      }
    }
  }

  sendMessage(): void {
    const message: Message = {senderName: this.senderName, groupId: this.group, text: this.text};
    this.socketService.emit(message);
  }

  getReceivedMessages(): void {
    console.log(this.receivedMessages);
  }
}
