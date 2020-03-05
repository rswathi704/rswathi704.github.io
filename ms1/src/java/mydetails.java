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
public class mydetails extends HttpServlet {

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
            out.println("<link rel=\'stylesheet\' href=\'https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\'" );
            out.println("<script src=\'https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\'></script>");
            out.println("<script src=\'https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\'></script>");            
            out.println("</head>");
            out.println("<body  background='image/bv.jpeg'>");
             try
             {
                 //userid from customer
                  HttpSession session = request.getSession(false);
            int userid=(int)session.getAttribute("userid");
        
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
               PreparedStatement ps=con.prepareStatement("select * from customerreg where userid=?");
               ps.setInt(1, userid);
               
               ResultSet rs=ps.executeQuery();
               rs.next();
         
 
            
            //out.println("<b><a href='changepassword.html'>Change Password</a> </b>");
            
            out.println("<center> <font size='7' color='grey' face='cooper' >DETAILS </font></center><br><br>");
            out.println("<div class='container'>"); 
            out.println("<font color='grey'> <form class='form-horizontal' action='mydetails1'>\n" +
"    <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='userid'>User ID:</label>\n" +
"      <div class='col-md-5'>\n" +
"          <input type='text' class='form-control' id='userid' placeholder='Enter User ID' name='userid' value='"+rs.getInt(1)+"' readonly='readonly'>\n" +
"      </div>\n" +
"    </div>\n" +
"    <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='name'> Name:</label>\n" +
"      <div class='col-md-5'> \n" +
"        <input type='text' class='form-control' id='name' placeholder='Enter Name' name='name' value='"+rs.getString(2)+"'>\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='add'>Address:</label>\n" +
"      <div class='col-md-5'>\n" +
"        <input type='text' class='form-control' id='add' placeholder='Enter Address' name='add' value='"+rs.getString(3)+"'>\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='mob'>Mobile:</label>\n" +
"      <div class='col-md-5'>\n" +
"        <input type='text' class='form-control' id='mob' placeholder='Enter Mobile' name='mob' value='"+rs.getString(4)+"'>\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='email'>Email:</label>\n" +
"      <div class='col-md-5'>\n" +
"        <input type='email' class='form-control' id='email' placeholder='Enter email' name='email' value='"+rs.getString(5)+"'>\n" +
"      </div>\n" +
"    </div>\n" +   
"    <div class='form-group'>        \n" +
"      <div class='col-md-offset-5 col-md-10'>\n"
        + "<input type=\"button\" value=\"Previous\"  class=\"btn btn-default\" onclick=\"history.back()\">" +
"        <input type='submit' class='btn btn-default' value='Update'>\n" +
"      </div>\n" +
"    </div>"
        + "</font>"
                    + "</form>"); 
            out.println("</div>");
           
            //request.getRequestDispatcher("mydetails1").forward(request, response);
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
