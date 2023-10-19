package com.bitfood.bitfood.Controller;

import com.bitfood.bitfood.Model.Dtos.AuthResponse;
import com.bitfood.bitfood.Model.Dtos.LoginRequest;
import com.bitfood.bitfood.Model.Dtos.RegisterRequest;
import com.bitfood.bitfood.Service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/auth/register")
    public ResponseEntity<AuthResponse> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
    @GetMapping("/api/show")
    public ResponseEntity<String> showDemo () {
        return new ResponseEntity<>("Bienvenido de nuevo", HttpStatus.OK);
    }


}
