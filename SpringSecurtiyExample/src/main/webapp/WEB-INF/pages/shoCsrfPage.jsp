<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <form:form action="csrfTest"  modelAttribute="csrf" method="post">
     Enter Name<form:input  path="uname"/>
     Enter pwd <form:input  path="upwd"/>
      <input type="submit" value="submit"/>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
   </form:form>