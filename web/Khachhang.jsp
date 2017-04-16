
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <a href="indexkhachhang.jsp">Back</a>
            
       <center>
        <h1>New Khach Hang</h1>
        <form action="Controllerkhachhang">
            Ma Khach Hang : <input type="text" name="txtMaKH" value=""/></br>
             Mat Khau : <input type="text" name="txtMatKhau" value=""/></br>
             Ho Va Ten : <input type="text" name="txtTenKH" value=""/></br>
            
              Email:<input type="text" name="txtEmail" value=""/></br>
             Dien Thoai:<input type="text" name="txtSDT" value/></br>
               <input type="submit" name="action" value="Insert"/>
        </form>
    </center>
     
       
 
     
    </body>
</html>
