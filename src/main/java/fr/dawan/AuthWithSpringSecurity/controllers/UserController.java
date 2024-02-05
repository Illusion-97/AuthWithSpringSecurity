package fr.dawan.AuthWithSpringSecurity.controllers;

import fr.dawan.AuthWithSpringSecurity.dtos.UserDto;
import fr.dawan.AuthWithSpringSecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService service;

    @GetMapping
    ResponseEntity<Page<UserDto>> findAll(Pageable pageable){
        Page<UserDto> all = service.findAll(pageable);
        return all.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(all);
    }
    @GetMapping("{id}")
    ResponseEntity<UserDto> findById(@PathVariable long id){
        return ResponseEntity.of(service.findById(id));
    }
    @PostMapping
    //@PutMapping
    ResponseEntity<UserDto> saveOrUpdate(@RequestBody UserDto dto){
        return ResponseEntity.ok(service.saveOrUpdate(dto));
    }
    @DeleteMapping("{id}")
    void deleteById(@PathVariable long id){
        service.deleteById(id);
    }
}
