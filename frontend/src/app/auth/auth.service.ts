import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthResponse } from './auth-response.model';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { AuthRequest } from './auth-request.model';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _loginEndpoint: string = 'http://localhost:8080/api/auth/login';
  private _registerEndpoint: string = 'http://localhost:8080/api/auth/login';

  public $userIsLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  constructor(private http: HttpClient, private tokenService: TokenService) { 
    if(this.tokenService.isValid()){
      this.$userIsLoggedIn.next(true);
    }
  }

  public login(authRequest: AuthRequest): Observable<AuthResponse>{
    return this.http
    .post<AuthResponse>(this._loginEndpoint, authRequest)
    .pipe(tap((authResponce: AuthResponse) => {
      this.tokenService.storeToken(authResponce.token);
      this.$userIsLoggedIn.next(true);
    }))
  }

  public register(authRequest: AuthRequest): Observable<AuthResponse>{
    return this.http
    .post<AuthResponse>(this._registerEndpoint, authRequest)
    .pipe(tap((authResponce: AuthResponse) => {
      this.tokenService.storeToken(authResponce.token);
      this.$userIsLoggedIn.next(true);
    }))
  }

  public logOut(): void{
    this.tokenService.removeToken();
    this.$userIsLoggedIn.next(false);
  }
}
