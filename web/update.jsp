<%-- 
    Document   : update
    Created on : 21-Oct-2016, 10:17:18
    Author     : NLVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Customers!</h1>

        <form action="ControllerKhachhang">
            ID: ${kh.maKhachHang}<br/><br/>
            Name: <input type="text" name="txtTenKH" value="${kh.Hoten}"/> <br/><br/>
            Pass: <input type="text" name="txtMatKhau" value="${kh.matKhau}"/> <br/><br/>
            Email: <input type="text" name="txtEmail" value="${kh.email}"/> <br/><br/>
            Phone: <input type="text" name="txtDienThoai" value="${kh.Sdt}"/> <br/><br/>

            <input type="submit" name="action" value="Update"/>

        </form>

    </body>
</html>