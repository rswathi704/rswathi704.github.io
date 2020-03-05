/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class otp1 extends HttpServlet {

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
                //bid from bookevent
                //card from cvv
                  HttpSession session = request.getSession(false);
                
                   String status=(String)session.getAttribute("status");
                   int bid=(int)session.getAttribute("bid");
                   String cardi=(String)session.getAttribute("card");
                int otp=Integer.parseInt(request.getParameter("otps"));
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
             PreparedStatement ps=con.prepareStatement("select otp from payment where card_no=?");
                ps.setString(1,cardi); 
           
                  ResultSet result=ps.executeQuery();              
                 Integer flag=0;
              
                  while(result.next())
            {
                if((result.getInt(1)==otp))
                {
                         flag=1;
                        //Cookie ck = new Cookie("card",cards);
                         //response.addCookie(ck);
                         PreparedStatement ps1=con.prepareStatement("insert into paid_customer(bookingid,payment_status,flag) values(?,?,?)");
                         ps1.setInt(1,bid);
                         ps1.setString(2,status);
                         ps1.setInt(3, flag);
                         ps1.executeUpdate();
                         ps1.close();
                         
                         
                         PreparedStatement ps2=con.prepareStatement("update bookanevent set flag=? where bookingid=?");
                         ps2.setInt(1, flag);
                         ps2.setInt(2, bid);
                         ps2.executeUpdate();
                         ps2.close();
                         
                       
                         request.getRequestDispatcher("confirmation.html").forward(request,response);
                        
                  
                }              
            }
            if(flag==0)
            {
               
                 out.println("<script>alert('Wrong OTP...!!!')</script>");
                request.getRequestDispatcher("otp").include(request,response);
            }
            ps.close();
            con.close();  
            }
           
            catch(Exception e)
            {
                out.println(e);
            }
            out.println("</body>");
 
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
