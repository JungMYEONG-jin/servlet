package main.webapps.dao;

import java.sql.*;
import java.util.UUID;

public class BookDAO {

    public BookDAO() {
    }

    public void insert(String title, String author, String pub) {
        Connection con = null;
        PreparedStatement psm = null;
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            con = DriverManager.getConnection(url, "scott", "tiger");
            String insert = "INSERT INTO BOOKS VALUES(?, ?, ?, ?)";
            psm = con.prepareStatement(insert);
            psm.setString(1, UUID.randomUUID().toString());
            psm.setString(2, title);
            psm.setString(3, author);
            psm.setString(4, pub);

            int affected = psm.executeUpdate();
            if (affected == 1) {
                System.out.println("insert success");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
            if (psm != null) try { psm.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }
}
