<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="java.sql.*" %>

<%
    Connection con = null;
    ResultSet resultSet = null;
    Statement stmt = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        con = DriverManager.getConnection(url, "scott", "tiger");
        String select = "SELECT PLAYER_NAME, POSITION FROM PLAYER_T";
        stmt = con.createStatement();
        resultSet = stmt.executeQuery(select);
        while (resultSet.next()) {
            String playerName = resultSet.getString("PLAYER_NAME");
            String position = resultSet.getString("POSITION"); %>
            <%= ("playerName = " + playerName + " position = " + position) +"<br>" %>
        <% }
        } catch (ClassNotFoundException | SQLException e) {
             throw new RuntimeException(e);
        }finally{
            if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
%>

<%= con %>