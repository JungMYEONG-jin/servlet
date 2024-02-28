<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.webapps.order.*, java.util.*" %>
<html>
<body>
<%
            Object obj = session.getAttribute("cart");
            long total = 0;
            if (obj != null) {
                List<Fruit> cart = (ArrayList<Fruit>) obj;

                for (Fruit fruit : cart) {
                    total += fruit.getPrice() * fruit.getQty(); %>
                    <%= fruit + "<br>" %>
               <% } %>
                <%="<h2>Your Total Price is " + total + "<br>" %>
            <% } else { %>
                <%= "<h1>Your Shopping cart is Empty!!<br>" %>
            <% } %>
</body>

<hr> ${total}
</html>