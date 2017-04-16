<%-- 
    Document   : indexkhachhang
    Created on : 21-Oct-2016, 10:15:24
    Author     : NLVM
--%>

<%@page import="Entity.Khachhang"%>
<%@page import="java.util.List"%>
<%@page import="DAO.KhachhangDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>KhachHang</h1>
        <a href="customer.jsp">Quay Lai</a>
        <table border="1">
            <form action="Controllerkhachhang">
            <tr>
                <td>Makh</td>
               
                <td>Password</td>
                 <td>Name</td>
                <td>Email</td>
                <td>Phone Number</td>
              
               </tr>
<%
                List<Khachhang> list= KhachhangDAO.layDanhSachKH("");
                for(Khachhang kh:list){
                out.println("<tr>"
                        + "<td>" + kh.getMaKhachHang()+ "</td>"
                        + "<td>"+ kh.getHoTen()+ "</td>"
                        + "<td>"+ kh.getMatKhau()+"</td>"
                        + "<td>"+ kh.getEmail()+ "</td>"
                        + "<td>"+ kh.getSdt()+"</td>"
                        + "</tr>");
                }
                
            %>
            
</table>          
            <a href="Khachhang.jsp"> Them </a>  
</form>

            </center>

    </body>
</html>
