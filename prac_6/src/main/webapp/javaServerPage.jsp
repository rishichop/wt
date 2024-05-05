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
<style>
	body {
		font-family: Arial, sans-serif;
	}
	h1 {
		text-align: center;
	}
	table {
		width: 50%;
		margin: 20px auto;
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid #ddd;
		padding: 8px;
		text-align: left;
	}
	th {
		background-color: #f2f2f2;
	}
	input[type="submit"] {
		background-color: #4CAF50;
		color: white;
		border: none;
		padding: 8px 16px;
		text-decoration: none;
		margin: 4px 2px;
		cursor: pointer;
	}
	input[type="submit"]:hover {
		background-color: #45a049;
	}
</style>
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
		if(SUBMIT != null) {
			if(SUBMIT.equals("submit")) {
				int i = st.executeUpdate("insert into Credentials(username,firstname,lastname,password) values ('"+username+"','"+first_name+"', '"+last_name+"', '"+password+"')");
				if(i > 0) {
					out.println("<p>Data Added.</p>");
				} else {
					out.println("<p>Data Not Added.</p>");
				}
			} else if(SUBMIT.equals("delete")) {
				// Check if the provided password matches the password in the database
				ResultSet rs = st.executeQuery("select password from Credentials where username='" + username + "'");
				if (rs.next() && rs.getString("password").equals(password)) {
					int i = st.executeUpdate("delete from Credentials where username = '"+username+"'");
					if(i > 0) {
						out.println("<p>Data deleted.</p>");
					} else {
						out.println("<p>Data Not deleted.</p>");
					}
				} else {
					out.println("<p>Password incorrect. Data Not deleted.</p>");
				}
			} else if(SUBMIT.equals("update")) {
				// Check if the provided password matches the password in the database
				ResultSet rs = st.executeQuery("select password from Credentials where username='" + username + "'");
				if (rs.next() && rs.getString("password").equals(password)) {
					int i = st.executeUpdate("update Credentials SET firstname = '"+first_name+"', lastname = '"+last_name+"' where username = '"+username+"'");
					if(i > 0) {
						out.println("<p>Data updated.</p>");
					} else {
						out.println("<p>Data Not updated.</p>");
					}
				} else {
					out.println("<p>Password incorrect. Data Not updated.</p>");
				}
			} else if(SUBMIT.equals("select")) {
				ResultSet rs = st.executeQuery("select * from Credentials");
				out.println("<table>");
				out.println("<tr><th>Username</th><th>First Name</th><th>Last Name</th><th>Password</th></tr>");
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getString(2) + "</td>");
					out.println("<td>" + rs.getString(3) + "</td>");
					out.println("<td>" + rs.getString(4) + "</td>");
					out.println("<td>" + rs.getString(5) + "</td>");
					out.println("</tr>");
				}
				out.println("</table>");
			}
		}
	} catch (Exception e) {
		out.println(e);
	}
		
	 %>
</body>
</html>