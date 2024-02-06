package fr.dawan.AuthWithSpringSecurity.services;

import fr.dawan.AuthWithSpringSecurity.dtos.UserDto;
import fr.dawan.AuthWithSpringSecurity.dtos.UserSecurity;
import fr.dawan.AuthWithSpringSecurity.mappers.UserMapper;
import fr.dawan.AuthWithSpringSecurity.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {


    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public Optional<UserDto> findById(long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public UserDto saveOrUpdate(UserDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public UserSecurity loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("\u001B[36mTransaction start\u001B[0m");
        return repository.findByEmail(email)
                .map(UserSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
