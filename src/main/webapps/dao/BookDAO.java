package main.webapps.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BookDAO {

    public BookDAO() {
    }

    public void insert(String title, String author, String pub) {
        Connection con = null;
        PreparedStatement psm = null;
        ResultSet resultSet = null;
        try {
            InitialContext initialContext = new InitialContext();
            DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/myoracle");
            con = ds.getConnection();

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

        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
            if (psm != null) try { psm.close(); } catch(Exception e) {}
//            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }
}
