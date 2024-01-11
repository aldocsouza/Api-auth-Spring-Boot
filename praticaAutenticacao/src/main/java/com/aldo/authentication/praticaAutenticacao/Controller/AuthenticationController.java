package com.aldo.authentication.praticaAutenticacao.Controller;

import com.aldo.authentication.praticaAutenticacao.Infra.security.TokenService;
import com.aldo.authentication.praticaAutenticacao.Repository.UserRepository;
import com.aldo.authentication.praticaAutenticacao.domain.user.AuthenticationDTO;
import com.aldo.authentication.praticaAutenticacao.domain.user.LoginResponseDTO;
import com.aldo.authentication.praticaAutenticacao.domain.user.RegisterUserDTO;
import com.aldo.authentication.praticaAutenticacao.domain.user.User;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/buscar")
    public ResponseEntity getAllUsers() {
        var user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterUserDTO data){
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
