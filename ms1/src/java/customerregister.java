/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
public class customerregister extends HttpServlet {

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
            out.println("<title>Servlet customerregister</title>");            
            out.println("</head>");
            out.println("<body>");
           try{       
            int userid;
            String name=request.getParameter("name");
            String address=request.getParameter("add");
            String mob=request.getParameter("mob");
            String email=request.getParameter("email");
            String pass=request.getParameter("pass");
            String cpass=request.getParameter("pwd");
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
      
            PreparedStatement ps=con.prepareStatement("insert into customerreg (name,address,"
                    + "mobile,email,password)values(?,?,?,?,?)");
            //ps.setInt(1, userid);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, mob);
            ps.setString(4, email);
            ps.setString(5, pass);
            ps.executeUpdate();
            
           Integer flag=0;
                
                
                if(pass.equals(cpass))
                {
                    flag=1;
                    out.println("<script> Successfully Registered </script>");
                    PreparedStatement ps1=con.prepareStatement("select userid from customerreg where name=?");
                    ps1.setString(1,name);
                    ResultSet rs=ps1.executeQuery();
                     rs.next();
                    
                        userid=rs.getInt(1);
                        HttpSession session=request.getSession();  
                          session.setAttribute("userid",userid);  
                    ps1.close();
                    request.getRequestDispatcher("home").forward(request,response);
                }
                
                
            
            if(flag==0)
            {
                out.println("<script>alert('Recheck your Password...!!!')</script>");
                request.getRequestDispatcher("customerregister.html").include(request,response);
            }
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
