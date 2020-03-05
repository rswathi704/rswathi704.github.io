/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class paymentcheck extends HttpServlet {

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
            out.println("<body background='image/payment.jpeg'>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
                
                //bid from bookevent
                 HttpSession session = request.getSession(false);
                     int bid=(int)session.getAttribute("bid");
             String status=request.getParameter("payment");
             HttpSession session1=request.getSession();  
                          session1.setAttribute("status",status);  
                
                
                     /*int a=1,b=0;
                      PreparedStatement ps=con.prepareStatement("insert into paid_customer(bookingid,payment_status,flag) values(?,?,?)");
                         ps.setInt(1,bid);
                         ps.setString(2,status);
                         ps.setInt(3,b);
                         ps.executeUpdate();
                         ps.close();
                      
                             
                        out.println("<script>alert('Thank You!!!')</script>");
                        request.getRequestDispatcher("cash.html").forward(request,response);
                        
                        
                         PreparedStatement ps2=con.prepareStatement("update bookanevent set flag=? where bookingid=?");
                         ps2.setInt(1, a);
                         ps2.setInt(2, bid);
                         ps2.executeUpdate();
                         ps2.close();*/
                         
                      
             
                 if(status.equals("Card"))
                 {
                     request.getRequestDispatcher("customerpayment").include(request,response);
                 }
                 else if(status.equals("Advance Payment"))
                 {
                      request.getRequestDispatcher("customerpayment").include(request,response);
                 }
                 
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
