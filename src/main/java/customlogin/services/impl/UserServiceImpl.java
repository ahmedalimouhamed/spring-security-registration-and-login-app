package customlogin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import customlogin.dto.UserDto;
import customlogin.model.User;
import customlogin.repositories.UserRepository;
import customlogin.services.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getFullName());
		return userRepository.save(user);
	}
	

}
