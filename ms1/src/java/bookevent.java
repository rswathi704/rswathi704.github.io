/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class bookevent extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            out.println("</head>");
            out.println("<body>");
           try
           {
                 Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
                 PreparedStatement ps1=con.prepareStatement(" select auto_increment from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA ='event' AND TABLE_NAME='bookanevent'");
            ResultSet rs=ps1.executeQuery();
            rs.next();
            int bid=rs.getInt(1);
            //bid--;
            
            HttpSession session1=request.getSession();
            session1.setAttribute("bid", bid);
              
               HttpSession session = request.getSession(false);
               int userid=(int)session.getAttribute("userid");
               //int bid=(int)session.getAttribute("bid");
               
               int guest=(int)session.getAttribute("guest");
               String type=(String)session.getAttribute("etype");
              
               String eplace=(String)session.getAttribute("eplace");
               String dates=(String)session.getAttribute("dates"); 
               
              SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // your template here
java.util.Date dateStr = formatter.parse(dates);
java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());



               String equip=(String)session.getAttribute("equip"); 
               String food=(String)session.getAttribute("food"); 
                
               String bf=(String)session.getAttribute("bf"); 
               String lunch=(String)session.getAttribute("lunch"); 
               String snacks=(String)session.getAttribute("snacks"); 
               String dinner=(String)session.getAttribute("dinner"); 
               String flowers=(String)session.getAttribute("flowers"); 
               String light=(String)session.getAttribute("light"); 
               String seat=(String)session.getAttribute("seat"); 
                
               int amount=(int)session.getAttribute("tot"); 
                
               String status=(String)session.getAttribute("status"); 
               int flag=0;
               
               //out.println(eplace);
               
                // PreparedStatement ps2=con.prepareStatement("select venuename from addvenue where venuename LIKE '%"+eplace+"%'");
                
                //ResultSet rs1=ps2.executeQuery();
                //rs1.next();
                //String place=rs1.getString(1);
             
               PreparedStatement ps=con.prepareStatement("insert into bookanevent(bookingid,userid,noofguest,eventtype,"
                       + "venuename,date,equipment,foodtype,breakfast,lunch,snacks,dinner,flower,seating,lighting,amount,"
                       + "status,flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               ps.setInt(1, bid);
               ps.setInt(2,userid);
               ps.setInt(3,guest);
               ps.setString(4, type);
               ps.setString(5,eplace);
               ps.setDate(6,dateDB);
               ps.setString(7, equip);
               ps.setString(8,food);
               ps.setString(9,bf);
               ps.setString(10, lunch);
               ps.setString(11, snacks);
               ps.setString(12, dinner);
               ps.setString(13, flowers);
               ps.setString(14, seat);
               ps.setString(15, light);
               ps.setInt(16, amount);
               ps.setString(17, status);
               ps.setInt(18, flag);
               ps.executeUpdate();
               
               out.println("<script>alert('Your event has been booked and it will begin processing soon. Kindly cooperate!!')</script>");
               request.getRequestDispatcher("bill").include(request,response);
               ps1.close();
               ps.close();
               con.close();
               
           }
           catch(Exception e)
           {
               out.println(e);
           }
            out.println("</body>");
            out.println("</html>");
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
