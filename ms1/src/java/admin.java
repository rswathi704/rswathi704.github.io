/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khsci5mca17062
 */
public class admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet admin</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{       
            String user=request.getParameter("user");
            String pass=request.getParameter("pass");
            Integer flag=0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
      
            PreparedStatement ps=con.prepareStatement("select * from admin where username=? ");
            ps.setString(1, user);
            ResultSet result=ps.executeQuery();
            while(result.next())
            {
                
                
                if((result.getString(1).equals(user)) && (result.getString(2).equals(pass)))
                {
                    flag=1;
                        Cookie ck=new Cookie("name",user);
                         response.addCookie(ck);
                        request.getRequestDispatcher("addvenue.html").forward(request,response);
                }
                
                
            }
            if(flag==0)
            {
                out.println("<script>alert('Invalid username or password...!!!')</script>");
                request.getRequestDispatcher("admin.html").include(request,response);
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
}
    
  