<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.io.IOException, 
    java.io.PrintWriter, 
    java.sql.Connection, 
    java.sql.DriverManager, 
    java.sql.ResultSet, 
    java.sql.Statement, 
    javax.servlet.ServletException,
	javax.servlet.annotation.WebServlet,
	javax.servlet.http.HttpServlet,
	javax.servlet.http.HttpServletRequest,
	javax.servlet.http.HttpServletResponse"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String URL="jdbc:mysql://localhost:3306/assignment_6";
	String USERNAME = "rishi";
	String PASSWORD = "Password@MYSQL123";
	response.getWriter().append("Served at: ").append(request.getContextPath());
	response.setContentType("text/html");
	
	out.println("<h1>" + "Hello World!" + "</h1>");
	try {
		//To connect mysql jdbc 
		Class.forName("com.mysql.jdbc.Driver");
		
		//connection string 
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		//connection is successful
		out.println("Connection Successful");
		
		
		String username = request.getParameter("username");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String password = request.getParameter("password");
		String SUBMIT = request.getParameter("SUBMIT");
		
		
		Statement st = con.createStatement();
		if(SUBMIT==null) {
			out.println("Record not inserted");
		}
		else if(SUBMIT.equals("submit")) {
			int i = st.executeUpdate("insert into Credentials(username,firstname,lastname,password) values ('"+username+"','"+first_name+"', '"+last_name+"', '"+password+"')");
		
			if(i>0) {
				out.println("Data Added.");
			}
			else {
				out.println("Data Not Added.");
			}
		}
		else if(SUBMIT.equals("delete")) {
			int i = st.executeUpdate("delete from Credentials where firstname = '"+first_name+"'");
			if(i>0) {
				out.println("Data deleted.");
			}
			else {
				out.println("Data Not deleted.");
			}
		}
		else if(SUBMIT.equals("update")) {
			int i = st.executeUpdate("update Credentials SET firstname = '"+first_name+"' where lastname = '"+last_name+"'");
			if(i>0) {
				out.println("Data updated.");
			}
			else {
				out.println("Data Not updated.");
			}			 
		}
		else if(SUBMIT.equals("select")) {
		    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);  
//			int i = st.executeUpdate("update user SET fname = '"+fname+"' where lname = '"+lname+"'");
			
			ResultSet rs=stmt.executeQuery("select * from Credentials");  
			while(rs.next()) {
//				rs.absolute(i);
				out.println("<table>");
				out.println("<tr>" + "<td>" + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" + "<td>" + rs.getString(3) + "</td>" + "<td>" + rs.getString(4) + "</td>" + "</tr>");
				out.println("</table>");
			
			}
		}
					
		
		
	} catch (Exception e) {
		out.println(e);
	}
		
	 %>
</body>
</html>