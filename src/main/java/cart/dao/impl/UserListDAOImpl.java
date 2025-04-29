package cart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cart.dao.BaseDao;
import cart.dao.UserListDAO;
import cart.model.entity.User;

public class UserListDAOImpl extends BaseDao implements UserListDAO{

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		String sql = "select id, username, hash_password, hash_salt, email, completed from user";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setHashPassword(rs.getString("hash_password"));
				user.setHashSalt(rs.getString("hash_salt"));
				user.setEmail(rs.getString("email"));
				user.setCompleted(rs.getBoolean("completed"));
				users.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
