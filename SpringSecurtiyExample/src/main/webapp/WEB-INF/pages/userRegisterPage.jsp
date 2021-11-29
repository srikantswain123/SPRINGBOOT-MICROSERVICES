<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <form:form action="Save" modelAttribute="users" method="POST">
       <table border="1" align="center" bgcolor="cyan">
       <tr><td>Enter UserName</td><td><form:input path="ename"/> </td></tr>
       <tr><td>Enter Email</td><td><form:input path="email"/> </td></tr>
       <tr><td>Enter Password</td><td><form:input path="epassword"/> </td></tr>
       <tr><td>Roles</td><td><form:checkboxes items="${roles}" path="roles"/></td></tr>
       
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>       
      <tr><td><input type="submit" value="submit">&nbsp;&nbsp;&nbsp;<input type="reset" value="reset"> </td></tr>
       </table>
     </form:form>
     ${save}