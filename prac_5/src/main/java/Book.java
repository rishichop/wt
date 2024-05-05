import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// Servlet implementation class Details

public class Book extends HttpServlet {
    
    //Default constructor.
    public Book(){
    
    }
    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        PrintWriter out=response.getWriter();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_5","rishi","Password@MYSQL123");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from book");
 
            out.println("<h1 style=\"text-align:center; color:black;\">Book Details</h1>");
 
            out.println("<div style=\"margin-left:25%; font-size:40px;\"><table border=\"1\" style=\"width:70%;\"><tr style=\"background-color:#78c2be; color:#fff;\"><td><strong>Book ID</strong></td><td><strong>Book Title</strong></td><td><strong>Author</strong></td><td><strong>Price</strong></td><td><strong>Quantity</strong></td></tr>");
 
            while(rs.next()){
                out.println("<tr style=\"color:black;\"><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
            }
            out.println("</table></body>");
            con.close();
        }
        catch(Exception e){
            out.println(e);
        }
    }
    // @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
    }
}