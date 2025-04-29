package cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import cart.dao.UserListDAO;
import cart.dao.impl.UserListDAOImpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserListService;

public class UserListServiceImpl implements UserListService {

	private UserListDAO userListDAO = new UserListDAOImpl();
	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users = userListDAO.findAllUsers();
		List<UserDTO> userDTOs = new ArrayList<>();
		for(User user : users) {
			userDTOs.add(transferToUserDTO(user));
		}
		return userDTOs;
	}
	private UserDTO transferToUserDTO(User user) {
		return new UserDTO(user.getId(),user.getUserName(),user.getEmail(),user.getCompleted());
	}
	
}
