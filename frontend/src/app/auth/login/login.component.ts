import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, FormsModule, ReactiveFormsModule, MatButtonModule, MatIconModule],
})
export class LoginComponent {
  email = new FormControl('', [Validators.required, Validators.email, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)]);
  password = new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(55), Validators.pattern(/^(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%^&*])[A-Za-z0-9@!#$%^&*]{8,}$/)]);

  getEmailErrorMessage() {
    if (this.email.hasError('required')) {
      return 'Please enter an email address';
    }
    if (this.email.hasError('pattern')) {
      return 'Please enter a valid email'
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  getPasswordErrorMessage() {
    if (this.password.hasError('required')) {
      return 'Please enter a valid password';
    }
    if (this.password.hasError('minlength')) {
      return 'Password must be at least 8 characters';
    }
    if (this.password.hasError('pattern')) {
      return 'Password must be at least 8 characters and contain at least 1 uppercase letter, 1 number, and 1 special character (@, !, #, $, %, ^, &, *)';
    }
    return this.password.hasError('password') ? 'Not a valid password' : '';
  }
}
