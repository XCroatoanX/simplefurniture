import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Router, RouterModule } from '@angular/router';
import { MatBadgeModule } from '@angular/material/badge';
import { CartService } from '../../services/cart.service';
import { Product } from '../../models/product.model';
import { AuthService } from '../../auth/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
  standalone: true,
  imports: [MatToolbarModule, MatIconModule, MatInputModule, RouterModule, MatButtonModule, MatBadgeModule, CommonModule],
})
export class HeaderComponent implements OnInit {
  public userIsLoggedIn: boolean = false;
  public amountOfCartItems: number = 0;


  constructor(private cartService: CartService, private authService: AuthService, private router: Router) { }


  ngOnInit() {
    this.checkLoginState();
    // Cart icon number
    this.cartService.$productInCart.subscribe((products: Product[]) => {
      this.amountOfCartItems = products.length;

    })
  }


  public onLogout(): void {
    this.authService.logOut();
    this.router.navigate(['/']);

  }


  public checkLoginState(): boolean {

    this.authService
      .$userIsLoggedIn
      .subscribe((loginState: boolean) => {
        this.userIsLoggedIn = loginState;
      });
    return false;
  }
}
