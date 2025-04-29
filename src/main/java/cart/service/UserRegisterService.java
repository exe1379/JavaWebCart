package cart.service;

public interface UserRegisterService {
	
	void addUser(String username, String password, String email);
	
	void emailConfirmOK(String username);
	
}
