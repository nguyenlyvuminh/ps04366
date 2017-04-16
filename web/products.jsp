<%-- 
    Document   : products
    Created on : Sep 26, 2016, 7:06:03 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="customer.jsp">Quay lai</a>
    <center>
        <h1>SmartPhone</h1>
        
    <form action="ControllerProducts">
        Nhap ten SP: <input type="text" name="txtTenSP" value=""/>
        <input type="submit" name="action" value="Search"/>
       
    </form>
        
    <table width="50%" height="20%" border="1" style=”margin-top:20px;” align=”center” >
       <td colspan="6">Hàng chìm tàu vớt vào bán rẻ</td>
        <tr>
            <td>Code</td>
            <td>Name</td>
            <td>Price</td>
            <td>Edit</td>
            <td>Delete</td>
          
        </tr>
        <c:forEach var="rows" items="${listSP}">
            <form action="ControllerProducts">
            <tr>
                <td>${rows.code}</td>
                <td>${rows.name}</td> 
                <td>${rows.price}</td>
                <c:url var="del" value="ControllerProducts">
                    <c:param name="action" value="Edit"/>
                    <c:param name="txtCode" value="${rows.code}"/>
                    <c:param name="txtName" value="${rows.name}"/>
                    <c:param name="txtPrice" value="${rows.price}"/>
            
                 </c:url>
                    <td><a href="${del}">Edit</a></td>
                    <td>
                        <input type="hidden" name="txtCode" value="${rows.code}"/>
                        <input type="submit" name="action" value="Delete"/>
                               
                    </td>
            </tr>
                </form>
                </c:forEach>
    </table>
        
        <a href ="newProduct.jsp">New</a>
        </br>
        <a href="showcart.jsp">Gio Hang</a>
    
        <br/>
         </center>
    </body>
   
</html>
