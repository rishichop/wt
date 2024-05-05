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
            
            // System.out.println(execute(ActionMapping mapping, ActionForm form, 
            // HttpServletRequest request, HttpServletResponse response));
            // Perform validations (you can implement your validation logic here)

            // For simplicity, let's assume validation passed
            // Your business logic goes here
         
            // Redirect to success page (you can customize this based on your application)
            ProcessRequest(request,response);
        } catch (Exception e) {
            // Handle exceptions (e.g., database errors, validation failures)
            // You can redirect to an error page or display an error message
           e.printStackTrace();
        }
        
    }
    public void ProcessRequest(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("text/html");
     try(PrintWriter out=response.getWriter()){
          out.println("<!DOCTYPE html>");
          out.println("<html><head><title>Attribute</title></head><body>");
         
          String name=request.getParameter("name");  
          String mobileNumber = request.getParameter("mobile");
          String email = request.getParameter("email");
          
          // hear we created name as a hidden form field that is going to be input of another servlet
          
          out.println("<h1>working</h1>");
        
          out.println("<h1>hello "+name+"</h1>");
           
          out.println("<h1>mobile Number: "+mobileNumber+"</h1>");
          out.println("<h1>email: "+email+"</h1>");

          // out.println("<h1><a href='servlet2?user="+name+"' method='post'>Go to s2</a></h1>");
          //hidden form field
          out.println(""+" <form action=\"servlet2\">\r\n" + //
                              "        <input type=\"text\" name=\"name\" value='"+name+"'>"+"<button> go to s2</button>"
                              +"</form>");
         
          out.println("</body></html>");
     }
  }
    

}
