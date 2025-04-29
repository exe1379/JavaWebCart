package cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cart.dao.BaseDao;
import cart.dao.UserRegisterDAO;
import cart.model.entity.User;

public class UserRegisterDAOImpl extends BaseDao implements UserRegisterDAO {

	@Override
	public int addUser(User user) {
		String sql = "insert into user(username, hash_password, hash_salt, email) values(?, ?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareCall(sql)){
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getHashPassword());
			pstmt.setString(3, user.getHashSalt());
			pstmt.setString(4, user.getEmail());
			int rowcount = pstmt.executeUpdate();
			return rowcount;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int emailConfirmOK(String username) {
		String sql = "update user set completed = true where username = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, username);
				int rowcount = pstmt.executeUpdate();
				return rowcount;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
