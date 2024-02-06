package fr.dawan.AuthWithSpringSecurity.mappers;

import fr.dawan.AuthWithSpringSecurity.dtos.RegisterDto;
import fr.dawan.AuthWithSpringSecurity.dtos.UserDto;
import fr.dawan.AuthWithSpringSecurity.generic.GenericMapper;
import fr.dawan.AuthWithSpringSecurity.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends GenericMapper<UserDto,User> {
    User toEntity(RegisterDto dto);
}
