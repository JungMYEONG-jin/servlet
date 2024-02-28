<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>

<jsp:useBean class="main.webapps.HelloBean" id="helloBean"/>

<h1> getName ${helloBean.getName()}
<h1> getNumber ${helloBean.getNumber()}

<h1> 이름 세팅해줄게

<jsp:setProperty property="name" name="helloBean" value="MJ"/>
<jsp:getProperty property="name" name="helloBean"/>

<h1> 번호 세팅해줄게

<jsp:setProperty property="number" name="helloBean" value="010123"/>
<jsp:getProperty property="number" name="helloBean"/>
