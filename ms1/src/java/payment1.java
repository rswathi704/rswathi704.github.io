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
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class payment1 extends HttpServlet {

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
             
              out.println(" <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
              
             String status=request.getParameter("status");
             if(status.equals("Approved"))
             {
           try 
             {
                     //bid from bookevent
                     HttpSession session = request.getSession(false);
                     int bid=(int)session.getAttribute("bid");

                     Class.forName("com.mysql.jdbc.Driver");
             
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/event", "root",""); 
                
                
                 PreparedStatement ps2 = con.prepareStatement("select flag from bookanevent where bookingid=?");
                ps2.setInt(1,bid);
                ResultSet rs1=ps2.executeQuery();
                rs1.next();
                int flag=rs1.getInt(1);
                if(flag==0)
                {
                  out.println("<a href='customerstatus'> <b>BACK </b></a>");
                  int userid=(int)session.getAttribute("userid");
                  
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
               LocalDate localDate = LocalDate.now();
                PreparedStatement ps = con.prepareStatement("select * from bookanevent where bookingid=?");
                ps.setInt(1,bid);
                ResultSet rs=ps.executeQuery();
             
                
              PreparedStatement ps1 = con.prepareStatement("select name,address,mobile from customerreg where userid=?");
                ps1.setInt(1,userid);
              ResultSet rs2=ps1.executeQuery();
              rs2.next();   
              
            
                out.println("<center><font size='7' color='grey' face='cooper'> Bill </font></center>");
                 out.println("<br> <br><br><br> <div class=\"container\">\n" +
"  <table class=\"table\">\n" +
"    <tbody>\n" +
"      <tr>\n" +
                    "<th>Ivy and Fairy Lights and Events <br> <br>  <br> <br></b>"
                        + "26/1 Ivy and Fairy Lights Events,<br>"
                        + "Malleshwaram,Banglore<br>"
                        + "Karnataka- 560055 </th> "+
                    "<th>Date: "+dtf.format(localDate)+"  </th> </tr>"
                          + "<tr><th> To: <br>"+rs2.getString(1)+" <br> "+rs2.getString(2)+" <br> "+rs2.getString(3)+" </th></tr> </tbody></table>");
                           
            out.println("<br><br> <br><div class=\"container\">\n" +
"  <table class=\"table\">\n" +
                     "<col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='100'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"
                    + " <col width='50'>"+    
"    <thead>\n" +
"    </thead>\n" +
"    <tbody>\n" +
"      <tr>\n" +
                    "<th> BID </th> "+
                    "<th> CID </th>"+
                    "<th>Guest </th>"+
                    "<th> Event </th>"+
                    "<th> Event Place </th>"+
                    "<th> Date </th>"+
                    "<th> Equipment </th>"+
                    "<th> Food Type </th>"+
                    "<th> Breakfast </th>"+
                    "<th> Lunch </th>"+
                    "<th> Snacks </th>"+
                    "<th> Dinner </th>"+
                    "<th> Flower </th>"+
                    "<th> Seating </th>"+
                    "<th> Lighting </th>"+
                    "<th> Amount </th>"+
                    "<th> Status </th> </tr>");
            
                while(rs.next())
                {
                    
                   out.println(
                    "<tr>"+
                    "<td>"+rs.getInt(1)+"</td>\n" +
                    "<td>"+rs.getInt(2)+"</td>\n" +
                    "<td>"+rs.getInt(3)+"</td>\n" +
                    "<td>"+rs.getString(4)+"</td>\n" +
                    "<td>"+rs.getString(5)+"</td>\n" +
                    "<td>"+rs.getString(6)+"</td>\n" +
                    "<td>"+rs.getString(7)+"</td>\n" +
                    "<td>"+rs.getString(8)+"</td>\n" +
                    "<td>"+rs.getString(9)+"</td>\n" +
                    "<td>"+rs.getString(10)+"</td>\n" +
                    "<td>"+rs.getString(11)+"</td>\n" +
                    "<td>"+rs.getString(12)+"</td>\n" +
                    "<td>"+rs.getString(13)+"</td>\n" +
                    "<td>"+rs.getString(14)+"</td>\n" +
                    "<td>"+rs.getString(15)+"</td>\n" +
                    "<td>"+rs.getInt(16)+"</td>\n" +
                    "<td>"+rs.getString(17)+"</td>\n" +        
"      </tr>\n" );   
                           }
                out.println("    </tbody>\n" +
"  </table>\n"+
                     "</div>");  
             }
                else
                {
                    out.println("<script>alert('You have already paid!!!')</script>");
                     request.getRequestDispatcher("customerstatus").include(request,response);
                }
            
             }
                catch(Exception e)
                        {
                        out.println(e);
                        }
             
            out.println("<center><div class='container'>"); 
            out.println("<form class='form-horizontal' action='paymentcheck'>\n" +

"<div class='radio'>"+
  "<label><input type='radio' name='payment' value='Card'>Card</label>"+
"</div>"+
                     "<div class='radio'>\n" +
"  <label><input type='radio' name='payment' value='Advance Payment'>Advance Payment</label>\n" +
"</div>"+
                    " <div class='form-group'>"
                    + "<br> <br>"+
"      <div class='col-md-offset-1 col-md-10'>"+
"        <input type='submit' class='btn btn-default' value='Submit'>" +
"      </div>\n" +
"  </div>\n"+
                   "</form>"+
            "</div>"
                    + "</center>");
             }
             if(status.equals("Pending"))
             {
                 out.println("<script>alert('Oopss!!! The Event you have booked is not yet confirmed.Hence your payment has been freezed... ')</script>");
                 request.getRequestDispatcher("customerstatus").include(request,response);
             }
               if(status.equals("Canceled"))
             {
                 request.getRequestDispatcher("denial.html").forward(request,response);
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
