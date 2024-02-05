package fr.dawan.AuthWithSpringSecurity.controllers;

import fr.dawan.AuthWithSpringSecurity.dtos.UserDto;
import fr.dawan.AuthWithSpringSecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    ResponseEntity<Page<UserDto>> findAll(Pageable pageable){
        Page<UserDto> all = service.findAll(pageable);
        return all.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(all);
    }
    ResponseEntity<UserDto> findById(long id){
        return ResponseEntity.of(service.findById(id));
    }
    ResponseEntity<UserDto> saveOrUpdate(UserDto dto){
        return ResponseEntity.ok(service.saveOrUpdate(dto));
    }
    void deleteById(long id){
        service.deleteById(id);
    }
}
