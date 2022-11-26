package at.htl.control;

import at.htl.entity.User;
import at.htl.entity.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO UserToDTO(User user);

    User UserDtoToUser(UserDTO userDTO);
}
