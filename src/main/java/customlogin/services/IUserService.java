package customlogin.services;

import customlogin.dto.UserDto;
import customlogin.model.User;

public interface IUserService {
	User findByUsername(String username);
	User save(UserDto userDto);
}
