package cart.service;

import cart.model.dto.UserDTO;

public interface UserLoginService {
	//登入三劍客 (username, password, authcode) 使用者輸入
	// authcode (sessionAuthCode server 端產生) 
	UserDTO login(String username, String password , String authcode, String sessionAuthCode);
	
}
