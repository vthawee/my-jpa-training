<%-- 
    Document   : show
    Created on : Oct 20, 2014, 1:18:03 PM
    Author     : com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guest</title>
    </head>
    <body>
        <h1>Guest</h1>
        
        
        <c:forEach items="${list}" var="g" >
            ${g.id}, text: ${g.text}, name: ${g.name} at ${g.created} <br/>
            
        </c:forEach>
        
        <c:forEach begin="0" end="${numPage-1}" var="i" >
            <a href="?no=${i}}">${i+1}</a>, 
        </c:forEach>
        <hr/>
            
        <form:form method="post" action="add.htm" modelAttribute="guest" >
            <div>
                <form:label path="text">Text</form:label>:
                <form:textarea path="text" />
            </div>
            <div>
                <form:label path="name">Name</form:label>:
                <form:input path="name" />
            </div>
            <div>
                <input type="submit" value="Add" />
            </div>
        </form:form>
    </body>
</html>
