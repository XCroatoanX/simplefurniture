import { Component } from '@angular/core';
import { ProductsModule } from '../products/products.module';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ProductsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
