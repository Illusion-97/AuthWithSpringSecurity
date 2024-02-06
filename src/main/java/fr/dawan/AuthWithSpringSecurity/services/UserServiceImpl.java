package fr.dawan.AuthWithSpringSecurity.services;

import fr.dawan.AuthWithSpringSecurity.dtos.UserDto;
import fr.dawan.AuthWithSpringSecurity.dtos.UserSecurity;
import fr.dawan.AuthWithSpringSecurity.generic.AbstractGenericService;
import fr.dawan.AuthWithSpringSecurity.mappers.UserMapper;
import fr.dawan.AuthWithSpringSecurity.models.User;
import fr.dawan.AuthWithSpringSecurity.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl extends AbstractGenericService<User,UserDto, UserRepository, UserMapper> implements UserService, UserDetailsService {
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public UserSecurity loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("\u001B[36mTransaction start\u001B[0m");
        return repository.findByEmail(email)
                .map(UserSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
