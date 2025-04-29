package cart.service.impl;
import cart.dao.UserLoginDAO;
import cart.dao.impl.UserLoginDAOImpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserLoginService;
import cart.util.HashUtil;

public class UserLoginServiceImpl implements UserLoginService {
	
	private UserLoginDAO userLoginDAO = new UserLoginDAOImpl();
	@Override
	public UserDTO login(String username, String password, String authcode, String sessionAuthCode) {
		// 比對驗證碼
		if(!authcode.equals(sessionAuthCode)) {
			throw new RuntimeException("驗證碼錯誤");
		}
		// 比對username是否存在
		User user = userLoginDAO.findUserByName(username);
		if(user == null) {
			throw new RuntimeException("使用者不存在");
		}
		// 比對 email 是否驗證通過
		boolean completed = user.getCompleted();
		if(!completed) {
			throw new RuntimeException("信箱未通過驗證");
		}
		// 比對password是否正確
		try {
			String hassPassword = HashUtil.hashPassword(password, user.getHashSalt());
			boolean checkPassword = user.getHashPassword().equals(hassPassword);
			if(!checkPassword) {
				throw new RuntimeException("密碼錯誤");
			}
		// 驗證成功
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUserName());
			userDTO.setEmail(user.getEmail());
			userDTO.setCompleted(user.getCompleted());
			return userDTO;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
