import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginservlet extends HttpServlet {
   protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
    ProcessRequest(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        ProcessRequest(request,response);
        }
    public void ProcessRequest(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
          response.setContentType("text/html");
       try(PrintWriter out=response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Attribute</title></head><body>");
           
            String name=request.getParameter("name");
            
            out.println("<h1>working</h1>");
          
            out.println("<h1 style='color=blue'>hello at s2 "+name+"</h1>");

           
            out.println("</body></html>");
       }
    }
}
