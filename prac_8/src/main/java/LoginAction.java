import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;


public class LoginAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve form parameters
            String name = request.getParameter("name");
            String mobileNumber = request.getParameter("mobile");
            String email = request.getParameter("email");

            ProcessRequest(request,response);
        } catch (Exception e) {

           e.printStackTrace();
        }
        
    }
    public void ProcessRequest(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("text/html");
        try(PrintWriter out=response.getWriter()){
          
            String name=request.getParameter("name");  
            String mobileNumber = request.getParameter("mobile");
            String email = request.getParameter("email");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Information</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f2f2f2;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("}");
            out.println("h1 {");
            out.println("    text-align: center;");
            out.println("    color: #333;");
            out.println("}");
            out.println("p {");
            out.println("    text-align: center;");
            out.println("    color: #555;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome!!</h1>");
            out.println("<h1>Hello " + name + "</h1>");
            out.println("<p>Mobile Number: " + mobileNumber + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("</body>");
            out.println("</html>");

        }
    }
    

}
