package government.mapper;

import government.dto.UserDto;
import government.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "user")
public interface UserMapper {

    UserDto userToUserDto(User user);
    List<UserDto> usersToUsersDtos(List<User> users);
}
