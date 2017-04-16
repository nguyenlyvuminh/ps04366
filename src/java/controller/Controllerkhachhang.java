/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.KhachhangDAO;
import Entity.Khachhang;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NLVM
 */
public class Controllerkhachhang extends HttpServlet {

    String makh_;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            if (action.equals("Search")) {
                String tenkh = request.getParameter("txtTenKH");
                List<Khachhang> list = KhachhangDAO.layDanhSachKH(tenkh);
                request.setAttribute("listKH", list);
                String url = "Khachhang.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("Delete")) {
                String makh = request.getParameter("txtMaKH");
                boolean daxoa = KhachhangDAO.xoaKhachHang(makh);
                if (daxoa) {
                    String url = "Controllerkhachhang?txtTenKH=&action=Search";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
                } else if (action.equals("Insert")) {
                String ma = request.getParameter("txtMaKH");
                String name = request.getParameter("txtTenKH");
                String matkhau = request.getParameter("txtMatKhau");
                String email = request.getParameter("txtEmail");
                String sodienthoai = request.getParameter("txtSDT");

                if (ma.isEmpty() || name.isEmpty() || matkhau.isEmpty() || email.isEmpty() || sodienthoai.isEmpty()) {
                    return;
                } else {
                    Khachhang kh = new Khachhang(ma, matkhau, name, email, sodienthoai);
                    boolean dathem = KhachhangDAO.themKhachHang(kh);
                    if (dathem) {
                        String url = "Controllerkhachhang";
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                    }
                    List<Khachhang> list = KhachhangDAO.layDanhSachKH("");
                    request.setAttribute("listKH", list);
                    String url = "Khachhang.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
            
            } else if (action.equals("Update")) {
                String name = request.getParameter("txtTenKH");
                String matkhau = request.getParameter("txtMatKhau");
                String email = request.getParameter("txtEmail");
                String sodienthoai = request.getParameter("txtDienThoai");

                
                Khachhang kh = new Khachhang(makh_, matkhau, name, email, sodienthoai);

                KhachhangDAO.CapNhatKhachHang(kh);
                /*if (dacapnhat) {  
                    String url = "ControllerKhachhang";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }*/
                List<Khachhang> list = KhachhangDAO.layDanhSachKH("");
                request.setAttribute("listKH", list);
                String url = "Khachhang.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } catch (Exception e) {
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
