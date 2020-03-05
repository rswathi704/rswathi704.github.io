 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
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
public class bill extends HttpServlet {

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
            out.println("<body>");
            out.println("<a href='home'> <b>Home </b></a>");
            
            
           try 
             {
                 //userid from customer
                 //bookid from adminstatus1
                HttpSession session = request.getSession(false);
                int bids=(int)session.getAttribute("bid");
                 int userid=(int)session.getAttribute("userid");
        
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
               LocalDate localDate = LocalDate.now();
        
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/event", "root",""); 
                
                PreparedStatement ps = con.prepareStatement("select * from bookanevent where bookingid=?");
                ps.setInt(1,bids);
                ResultSet rs=ps.executeQuery();
                
                 PreparedStatement ps1 = con.prepareStatement("select name,address,mobile from customerreg where userid=?");
                ps1.setInt(1,userid);
              ResultSet rs1=ps1.executeQuery();
              rs1.next();   
              
              
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
                          + "<tr><th> To: <br>"+rs1.getString(1)+" <br> "+rs1.getString(2)+" <br> "+rs1.getString(3)+" </th></tr> </tbody></table>");
                           
            out.println("<br><br> <br><div class=\"container\">\n" +
"  <table class=\"table\">\n <col width='50'>"
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
                    
                   out.println("</tr>"+
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
"      </tr>\n" +
"    </tbody>\n" +
"  </table>\n"+
                     "</div>");     
                           }
                ps.close();
                con.close();
                out.println("<form class='form-horizontal' action='cancel'>\n" +
                        "<div class='form-group'>        \n" +
"      <div class='col-md-offset-5 col-md-10'>\n" +
"        <button type='submit' class='btn btn-default' value='formaction='cancel'>Event Cancel </button>" +
"      </div>\n" +
"    </div>"
                    + "</form>"); 
                     
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
