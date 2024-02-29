package main.webapps.dao;

import java.sql.*;

public class UserDAO {

    public UserDAO() {
    }

    public boolean check(String id, String password) {
        Connection con = null;
        PreparedStatement psm = null;
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            con = DriverManager.getConnection(url, "scott", "tiger");
            String select = "SELECT PASSWORD FROM USERS where USER_ID = ?";
            psm = con.prepareStatement(select);
            psm.setString(1, id);
            resultSet = psm.executeQuery();
            String db_pwd = "";
            if (resultSet.next()) {
                db_pwd = resultSet.getString("PASSWORD");
                System.out.println("db_pwd = " + db_pwd);
                System.out.println("password = " + password);
            }
            if (password.equals(db_pwd)) {
                System.out.println("correct password");
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
            if (psm != null) try { psm.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }

        return false;
    }
}
