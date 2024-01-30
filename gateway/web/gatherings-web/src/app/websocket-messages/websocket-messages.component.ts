import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {Message} from "../types";
import {ChatService} from "../services/chat.service";
import {MatChipsModule} from "@angular/material/chips";
import {MatTooltipModule, TooltipPosition} from "@angular/material/tooltip";
import {MatBadgeModule} from "@angular/material/badge";

@Component({
  selector: 'app-websocket-messages',
  standalone: true,
  imports: [CommonModule, FormsModule, MatChipsModule, MatBadgeModule, MatTooltipModule],
  templateUrl: './websocket-messages.component.html',
  styleUrl: './websocket-messages.component.scss',
  providers: [ChatService]
})
export class WebsocketMessagesComponent implements OnInit {
  text!: string;
  receivedMessages: Message[][] = [];
  senderName: string = 'user1';
  group: string = 'group1';
  groupIndex: number = 0;
  chipColor: string = 'accent';
  chatPosition: TooltipPosition = 'before';

  unreadMessageCount: number[] = [0, 0, 0];
  hidden: boolean[] = [true, true, true];
  availableGroups: string[] = ['group1', 'group2', 'group3'];

  constructor(public socketService: ChatService) {
  }

  ngOnInit(): void {
    this.socketService.getMessage()
      .subscribe((data: Message) => {
        this.separateMessages(data);
        this.handleUnreadMessages(data.groupId);
      });
  }

  separateMessages(message: Message): void {
    const length: number = message.groupId.length - 1;
    const index: number = Number(message.groupId.charAt(length)) - 1;

    if (this.receivedMessages[index] === undefined) {
      this.receivedMessages[index] = [];
    }

    this.receivedMessages[index].push(message);
  }

  handleUnreadMessages(groupName: string): void {
    const length: number = groupName.length - 1;
    const index: number = Number(groupName.charAt(length)) - 1;

    if (index !== this.groupIndex) {
      this.hidden[index] = false;
      this.unreadMessageCount[index]++;
    }
  }

  sendMessage(): void {
    const message: Message = {senderName: this.senderName, groupId: this.group, text: this.text};
    this.socketService.emit(message);
  }

  changeGroup(groupName: string): void {
    const length: number = groupName.length - 1;
    const index: number = Number(groupName.charAt(length)) - 1;
    this.group = groupName;
    this.groupIndex = index;

    this.unreadMessageCount[index] = 0;
    this.hidden[index] = true;
  }
}
