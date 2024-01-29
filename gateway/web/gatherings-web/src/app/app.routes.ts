import {Routes} from '@angular/router';
import {GatheringListComponent} from "./gathering-list/gathering-list.component";
import {WebsocketMessagesComponent} from "./websocket-messages/websocket-messages.component";

export const routes: Routes = [
  {path: 'messages', component: WebsocketMessagesComponent},
  {path: 'main', component: GatheringListComponent}
];
