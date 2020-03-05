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
public class total extends HttpServlet {

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
                
                //userid from customer
                  HttpSession session = request.getSession(false);
               int userid=(int)session.getAttribute("userid");
               
               //int bid=(int)session.getAttribute("bid");
               int guest=(int)session.getAttribute("guest");
               //String type=(String)session.getAttribute("etype");
               String eplace=(String)session.getAttribute("eplace");
               //String dates=(String)session.getAttribute("dates"); 
               String equip=(String)session.getAttribute("equip"); 
               String food=(String)session.getAttribute("food"); 
               String bf=(String)session.getAttribute("bf"); 
               String lunch=(String)session.getAttribute("lunch"); 
               String snacks=(String)session.getAttribute("snacks"); 
               String dinner=(String)session.getAttribute("dinner"); 
               String flowers=(String)session.getAttribute("flowers"); 
               String light=(String)session.getAttribute("light"); 
               String seat=(String)session.getAttribute("seat"); 
               String amount=(String)session.getAttribute("amount"); 
               String status=(String)session.getAttribute("status"); 
               
            int tot=0,place=0,equipment=0;
            int ligh=0,flow=0,seato=0;
            int brea=0,lun=0,snac=0,dinn=0,foo=0;;
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
            PreparedStatement ps=con.prepareStatement("select venuename,cost from addvenue");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
           
                if(eplace.equals(rs.getString(1)))
                {
                    place+=rs.getInt(2);
                }
            }  
                if(equip.equals("dj"))
                {
                    equipment=4500;
                }
                if(equip.equals("stage"))
                {
                    equipment=6000;
                }
                if(equip.equals("mike and speaker"))
                {
                    equipment=5000;
                }
                
                if(food.equals("Veg and Non-Veg"))
                {
                    if(bf.equals("Royal"))
                    {
                        brea=300;
                    }
                    else if(bf.equals("Delux"))
                    {
                        brea=200;
                    }
                    else if(bf.equals("Normal"))
                    {
                        brea=150;
                    }
                    else if(bf.equals("-----"))
                    {
                        brea=0;
                    }
                    
                    
                    else if(lunch.equals("Royal"))
                    {
                        lun=450;
                    }
                    else if(lunch.equals("Delux"))
                    {
                        lun=350;
                    }
                    else if(lunch.equals("Normal"))
                    {
                        lun=250;
                    }
                    else if(lunch.equals("-----"))
                    {
                        lun=0;
                    }
                    
                    
                    else if(snacks.equals("Royal"))
                    {
                        snac=200;
                    }
                    else if(snacks.equals("Delux"))
                    {
                        snac=150;
                    }
                    else if(snacks.equals("Normal"))
                    {
                        snac=100;
                    }
                    else if(snacks.equals("-----"))
                    {
                        snac=0;
                    }
                    
                    
                    else if(dinner.equals("Royal"))
                    {
                        dinn=1500;
                    }
                    else if(dinner.equals("Delux"))
                    {
                        dinn=1000;
                    }
                    else if(dinner.equals("Normal"))
                    {
                        dinn=850;
                    }
                    else if(dinner.equals("-----"))
                    {
                        dinn=0;
                    }
                }
                else if(food.equals("Veg"))
                {
                    if(bf.equals("Royal"))
                    {
                        brea=250;
                    }
                    else if(bf.equals("Delux"))
                    {
                        brea=200;
                    }
                    else if(bf.equals("Normal"))
                    {
                        brea=150;
                    }
                    else if(bf.equals("-----"))
                    {
                        brea=0;
                    }
                    
                    
                    else if(lunch.equals("Royal"))
                    {
                        lun=450;
                    }
                    else if(lunch.equals("Delux"))
                    {
                        lun=350;
                    }
                    else if(lunch.equals("Normal"))
                    {
                        lun=250;
                    }
                    else if(lunch.equals("-----"))
                    {
                        lun=0;
                    }
                    
                    
                    else if(snacks.equals("Royal"))
                    {
                        snac=200;
                    }
                    else if(snacks.equals("Delux"))
                    {
                        snac=150;
                    }
                    else if(snacks.equals("Normal"))
                    {
                        snac=100;
                    }
                    else if(snacks.equals("-----"))
                    {
                        snac=0;
                    }
                    
                    
                    else if(dinner.equals("Royal"))
                    {
                        dinn=1500;
                    }
                    else if(dinner.equals("Delux"))
                    {
                        dinn=1000;
                    }
                    else if(dinner.equals("Normal"))
                    {
                        dinn=850;
                    }
                    else if(dinner.equals("-----"))
                    {
                        dinn=0;
                    }
                }
                
                
                
                    if(light.equals("Royal"))
                    {
                        ligh=5000;
                    }
                    else if(light.equals("Delux"))
                    {
                        ligh=3800;
                    }
                    else if(light.equals("Normal"))
                    {
                        ligh=3400;
                    }
                    else if(light.equals("-----"))
                    {
                        ligh=0;
                    }
                    
                    
                    if(flowers.equals("Royal"))
                    {
                        flow=7000;
                    }
                    else if(flowers.equals("Delux"))
                    {
                        flow=5000;
                    }
                    else if(flowers.equals("Normal"))
                    {
                        flow=4000;
                    }
                    else if(flowers.equals("-----"))
                    {
                        flow=0;
                    }
                    
                    
                    if(seat.equals("Chair"))
                    {
                        seato=50;
                    }
                    else if(seat.equals("Sofa"))
                    {
                        seato=150;
                    }
                    else if(seat.equals("Chair and Sofa"))
                    {
                        seato=250;
                    }
                    else if(seat.equals("-----"))
                    {
                        seato=0;
                    }
                    
                    foo=brea+lun+snac+dinn;
                    int amt=guest*foo;
                    int seats=guest*seato;
                    tot=amt+place+ligh+flow+seats;
                     HttpSession session1 = request.getSession();
                    session1.setAttribute("tot", tot);
            
                    
                    request.getRequestDispatcher("bookevent").forward(request,response);
                
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
