package cart.dao;


import java.sql.Connection;
import java.sql.DriverManager;
// 用來讓不同的 xxxDao 透過 extends BaseDao 可以連接 MySQL
public class BaseDao {
  protected static Connection conn;
	
  static {
    // 連線參數(mySQL8.0後要加時區)
    String username = "admin";
    String password = "admin";
    String dbUrl = "jdbc:mysql://localhost:3306/cart?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true&useSSL=false";

    // 建立連線
    try {
    // forName 動態建立物件 vs new 靜態建立物件
    // 通常寫JavaConsole時,JDBC版本4.0以上時不用手動建立. 但寫web程式時要手動寫
      Class.forName("com.mysql.cj.jdbc.Driver"); // 註冊 MySQL Driver，從libraries的mysql-METAINF-services-java.sql.Driver
      conn = DriverManager.getConnection(dbUrl, username, password); // 連線建立
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
