package fr.dawan.AuthWithSpringSecurity.controllers;

import fr.dawan.AuthWithSpringSecurity.dtos.UserDto;
import fr.dawan.AuthWithSpringSecurity.generic.AbstractGenericRestController;
import fr.dawan.AuthWithSpringSecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController extends AbstractGenericRestController<UserDto, UserService> {
    public UserController(UserService service) {
        super(service);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    protected void deleteById(@PathVariable long id) {
        super.deleteById(id);
    }
}
