import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/company", "root", "password");

      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM employees");

      out.println("<h2>Employee Records</h2>");
      out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Department</th></tr>");

      while (rs.next()) {
        out.println("<tr><td>" + rs.getInt("id") + "</td><td>"
          + rs.getString("name") + "</td><td>"
          + rs.getString("department") + "</td></tr>");
      }
      out.println("</table>");

      con.close();
    } catch (Exception e) {
      out.println("<h3>Error: " + e.getMessage() + "</h3>");
    }
  }
}
