/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khsci5mca17062
 */
public class repayment1 extends HttpServlet {

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
             
              out.println(" <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
            
            out.println("</head>");
            out.println("<body background='image/bill.jpeg'>");
            try
            {
                 Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
               PreparedStatement ps=con.prepareStatement("select * from admin_card");
               ResultSet rs=ps.executeQuery();
               rs.next();
               
                //int acardno=Integer.parseInt(request.getParameter("acardno"));
                String name=request.getParameter("name");
                String credit=request.getParameter("credit");
                int amount=Integer.parseInt(request.getParameter("amnt"));
                
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
               LocalDate localDate = LocalDate.now();
        
               out.println("<center><font face='cooper' size='7' color='lightgrey'> Payment Details </font> <center><br> <br> <br> <br>"
                       + "<font color='lightgrey'>"
                       + "<div class=\"container\">"+
                      "  <table class=\"table\">\n" +
"    <thead>\n" +
"    </thead>\n" +
"    <tbody>\n" +
"      <tr>\n" +
                    "<th> Account to be debited*: </th> <td> "+rs.getString(1)+" </td>  </tr>"+
                    "<tr><th> Beneficiary Name*: </th> <td> "+name+" </td> </tr>"+
                    "<tr><th> Account to be credited: </th> <td> "+credit+" </td> </tr>"+
                    "<tr><th> Amount: </th> <td> "+amount+" </td> </tr>"+
                    "<tr><th> Pay Now: </th> <td> "+localDate+" </td> </tr>"+
                        "</tbody>"
                       + "</table>"
                            + "</div>");
               
                out.println("<form class='form-horizontal'>\n" +
                        "<div class='form-group'>        \n" +
"      <div class='col-md-offset-1 col-md-10'>\n" +
                        "        <button type='submit'  class=\"btn btn-default\" onclick=\"history.back()\"'>Back </button>" +
"        <button type='submit' class='btn btn-default' formaction='repayment2'>Confirm </button>" +
                        
"      </div>\n" +
"    </div>"
                    + "</form>"
                        + "</font>"); 
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
