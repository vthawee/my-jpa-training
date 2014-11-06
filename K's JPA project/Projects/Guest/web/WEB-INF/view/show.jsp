<%-- 
    Document   : show
    Created on : Oct 20, 2014, 1:17:52 PM
    Author     : com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guest</title>
    </head>
    <body>
        <h1>test</h1>

        <c:forEach items="${list}" var="g">
            ${g.id}. 
            ${g.name} by 
            ${g.text} at 
            ${g.created}<br>
        </c:forEach>

        <c:forEach begin="0" end="${numPage-1}" var="i">
            <a href="?no=${i}" >${i+1}</a>            
        </c:forEach>
        <hr/>

        <form:form action="add.htm" method="post" modelAttribute="guest">
            <table>
                <tr>
                    <td>
                        <form:label path="name">
                            Name:
                        </form:label>
                    </td>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="text">
                            Text:
                        </form:label>
                    </td>
                    <td>
                        <form:input path="text"/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="add"/>
        </form:form>
    </body>
</html>
