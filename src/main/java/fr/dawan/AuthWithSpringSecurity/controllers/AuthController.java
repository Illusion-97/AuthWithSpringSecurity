package fr.dawan.AuthWithSpringSecurity.controllers;

import fr.dawan.AuthWithSpringSecurity.dtos.LoginDto;
import fr.dawan.AuthWithSpringSecurity.dtos.LoginResponseDto;
import fr.dawan.AuthWithSpringSecurity.dtos.RegisterDto;
import fr.dawan.AuthWithSpringSecurity.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final AuthService service;

    //@RequestMapping(value = "login", method = {RequestMethod.POST})
    @PostMapping("login")
    public LoginResponseDto authenticate(@RequestBody LoginDto credential) {
        return service.authenticate(credential);
    }

    @PostMapping("register")
    public void register(@RequestBody RegisterDto dto) {
        service.register(dto);
    }
}
