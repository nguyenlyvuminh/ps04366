/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Khachhang;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author NLVM
 */
public class KhachhangDAO {
     public static List<Khachhang> layDanhSachKH(String tenkh) {
        List<Khachhang> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from khachhang ";
        if(tenkh.length()>0){
            sql +="kh where kh.username like '%"+tenkh+"%'";
        }
       
        
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }
    
    public KhachhangDAO() {
    }
    public static Khachhang layThongTinKH(String makh) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         Khachhang kh = (Khachhang) session.get(Khachhang.class, makh);
         return kh;
    }
 
    
    public static boolean xoaKhachHang(String maKhachHang) {
      Khachhang kh =  KhachhangDAO.layThongTinKH(maKhachHang);
        
        if (kh == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(kh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
    public static boolean CapNhatKhachHang(Khachhang kh) {
        
        if (KhachhangDAO.layThongTinKH(kh.getMaKhachHang()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(kh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
    
    public static boolean themKhachHang(Khachhang kh) {
        
        if (KhachhangDAO.layThongTinKH(kh.getMaKhachHang()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(kh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        } finally{
            session.close();
        }
    }
}


