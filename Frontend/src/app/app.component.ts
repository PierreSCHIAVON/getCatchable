import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  template: `
  
  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">Catchable</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="#">Créatures</a></li>
        <li><a href="#">Types</a></li>
        <li><a href="#">Sprites</a></li>
      </ul>
    </div>
  </nav>


<router-outlet />
`,

styles: [],
})
export class AppComponent {
  title = 'Catchable';
}
