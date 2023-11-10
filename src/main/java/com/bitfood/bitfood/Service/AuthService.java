package com.bitfood.bitfood.Service;

import com.bitfood.bitfood.Model.Dtos.AuthResponse;
import com.bitfood.bitfood.Model.Dtos.LoginRequest;
import com.bitfood.bitfood.Model.Dtos.RegisterRequest;
import com.bitfood.bitfood.Model.Entities.Role;
import com.bitfood.bitfood.Model.Entities.User;
import com.bitfood.bitfood.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContrasena()));

        UserDetails user=userRepository.findByUsername(request.getUsuario()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsuario())
                .password(passwordEncoder.encode( request.getContrasena()))
                .nombres(request.getNombres())
                .apellidos(request.getApellidos())
                .correo(request.getCorreo())
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

    public AuthResponse register2(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsuario())
                .password(passwordEncoder.encode( request.getContrasena()))
                .nombres(request.getNombres())
                .apellidos(request.getApellidos())
                .correo(request.getCorreo())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}

