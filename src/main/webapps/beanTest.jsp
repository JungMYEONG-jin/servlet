<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>

<jsp:useBean class="main.webapps.HelloBean" id="helloBean"/>


helloBean.getName();
<jsp:getProperty property="name" name="helloBean"/>

helloBean.setName("MJ");
<jsp:setProperty property="name" name="helloBean" value="MJ"/>

<h1> My name is ${helloBean}