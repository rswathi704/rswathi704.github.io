/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class bookanevent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try{  
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            out.println("</head>");
            out.println("<body>");
                    
           HttpSession session = request.getSession(false);
            int userids=(int)session.getAttribute("userid");
            
            String type=request.getParameter("event_type");
            String place=request.getParameter("place");
            int nog=Integer.parseInt(request.getParameter("nog"));
            String dates=request.getParameter("datepicker");
               

             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
            PreparedStatement ps=con.prepareStatement("select venuename,capacity from addvenue where venuename LIKE '%"+place+"%'");
            //ps.setString(1,place);
            
            ResultSet rs=ps.executeQuery();
            rs.next();
            String a = rs.getString(1);
            
            //out.println(a);
            HttpSession session2=request.getSession();  
            session2.setAttribute("etype",type); 
            session2.setAttribute("eplace",a); 
            session2.setAttribute("guest",nog); 
            session2.setAttribute("dates",dates); 
            
            if(nog<=rs.getInt(2))
            {
            /*PreparedStatement ps1=con.prepareStatement(" select auto_increment from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA ='event' AND TABLE_NAME='bookanevent'");
            ResultSet rs=ps1.executeQuery();
            rs.next();
            int bid=rs.getInt(1);
            bid--;
            
           HttpSession session1=request.getSession();  
            session1.setAttribute("bid",bid); */
            out.println(dates);
            request.getRequestDispatcher("equipment.html").forward(request,response);
          
            }
            else
            {
                out.println("<script>alert('No of guest is higher than the capacity')</script>");
                request.getRequestDispatcher("eventbooking").include(request,response);
            }
            }
            catch(Exception e)
            {
                out.println(e);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
    