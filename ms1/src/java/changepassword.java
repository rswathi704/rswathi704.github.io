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
public class changepassword extends HttpServlet {

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
                String pass=request.getParameter("pass");
                String newpass=request.getParameter("newpass");
                String confo=request.getParameter("confo");
                
                HttpSession session = request.getSession(false);
                int userid=(int)session.getAttribute("userid");
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
                PreparedStatement ps=con.prepareStatement("select password from customerreg where userid=?");
                ps.setInt(1, userid);
                ResultSet rs=ps.executeQuery();
                rs.next();
                
                if(pass.equals(rs.getString(1)))
                {
                    if(newpass.equals(confo))
                    {
                        out.println("<script>alert('Password Changed Successfully')</script>");
                        request.getRequestDispatcher("changepassword.html").include(request,response);
                    }
                    else
                    {
                        out.println("<script>alert('Wrong Password')</script>");
                        request.getRequestDispatcher("changepassword.hmtl").include(request,response);
                    }
                }
                else
                {
                    out.println("<script>alert('Wrong Current Password')</script>");
                    request.getRequestDispatcher("changepassword.html").include(request,response);
                }
                
               
                PreparedStatement ps1=con.prepareStatement("update customerreg set password=? where userid=?");
                ps1.setString(1,confo);
                ps1.setInt(2, userid);
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
