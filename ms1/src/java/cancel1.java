/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class cancel1 extends HttpServlet {

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
                //bid from customerstatus1
                 HttpSession session = request.getSession(false);
                 int bid=(int)session.getAttribute("bkid");
                   
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
               
                PreparedStatement ps=con.prepareStatement("select * from bookanevent where bookingid=?");
                ps.setInt(1, bid);
               
                ResultSet rs= ps.executeQuery();
               
                rs.next();
                 
                int bookid=rs.getInt(1);   
                int userid=rs.getInt(2);
                String type=rs.getString(4);
               
            String eplace=rs.getString(5);
            int guest=rs.getInt(3);
                
            String dates=rs.getString(6);
            String equip=rs.getString(7);
            String bf=rs.getString(9);
            String lunch=rs.getString(10);
            String snacks=rs.getString(11);
            String dinner=rs.getString(12);
            String food=rs.getString(8);
          
         
            String light=rs.getString(15);
            String flowers=rs.getString(13);
            String seat=rs.getString(14);
            int amount=rs.getInt(16);
            int flag=rs.getInt(18);
            String status=rs.getString(17);
                
            String stat;
            if(flag==0)
            {
                stat="Not Paid";
            }
            else
            {
                stat="Card";
            }
               
            
            
                PreparedStatement ps2=con.prepareStatement("insert into event_cancel(bookingid,userid,noofguest,eventtype,"
                       + "venuename,date,equipment,foodtype,breakfast,lunch,snacks,dinner,flower,seating,lighting,amount,payment_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               ps2.setInt(1, bid);
              
               ps2.setInt(2,userid);
               ps2.setInt(3,guest);
               ps2.setString(4, type);
               ps2.setString(5,eplace);
               ps2.setString(6,dates);
               ps2.setString(7, equip);
               ps2.setString(8,food);
               ps2.setString(9,bf);
               ps2.setString(10, lunch);
               ps2.setString(11, snacks);
               ps2.setString(12, dinner);
               ps2.setString(13, flowers);
               ps2.setString(14, seat);
               ps2.setString(15, light);
               ps2.setInt(16, amount);
               ps2.setString(17, stat);
               ps2.executeUpdate();
               
            
            /*PreparedStatement ps3=con.prepareStatement("select payment_status from paid_customer where bookingid=?");
            ps3.setInt(1,bid);
            ResultSet rs1=ps3.executeQuery();
             
            rs1.next();*/

               
            /*if((rs1.getString(1).equals("Card") || rs1.getString(1).equals("Advance Payment")) && rs.getString(17).equals("Approved"))
            {
               out.println("<script>alert('Your event has been canceled repayment will be done within a short time')</script>");
               request.getRequestDispatcher("customerstatus").include(request,response);
            }*/
            if(stat.equals("Pending"))
            {
               
                out.println("<script>alert('Your event was pending and is canceled by you.')</script>");
                 request.getRequestDispatcher("customerstatus").include(request,response);
            }
            if(stat.equals("Card"))
            {

               out.println("<script>alert('Your event is canceled by you. "
                       + "Your paid amount will be repayed within few hours. Kindly cooperate.')</script>");
               request.getRequestDispatcher("customerstatus").include(request,response);
            
            }
            
            
            if(stat.equals("Not Paid"))
            {
                out.println("<script>alert('Your event is canceled by you.')</script>");
                 request.getRequestDispatcher("customerstatus").include(request,response);
            }
            
            if(rs.getString(17).equals("Canceled"))
            {
                 out.println("<script>alert('Your event is already canceled by Organizers.')</script>");
                 request.getRequestDispatcher("customerstatus").include(request,response);
            }
            
            PreparedStatement ps1=con.prepareStatement("delete from bookanevent where bookingid=?");
                ps1.setInt(1,bid);
                ps1.executeUpdate();
                
               
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
