package cart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
		private Integer id;
		private String userName;
		private String hashPassword;
		private String hashSalt;
		private String email;
		private Boolean completed;
}
