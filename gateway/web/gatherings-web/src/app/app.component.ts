import {Component} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Router, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'gatherings-web';

  constructor(private router: Router) {
  }

  navigateTo(name: string): void  {
    this.router.navigate([name]);
  }
}
