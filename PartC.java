import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String name = request.getParameter("name");
    String status = request.getParameter("status");

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/school", "root", "password");

      PreparedStatement ps = con.prepareStatement(
        "INSERT INTO attendance (name, status) VALUES (?, ?)");
      ps.setString(1, name);
      ps.setString(2, status);
      ps.executeUpdate();

      out.println("<h3>Attendance marked successfully for " + name + "!</h3>");
      con.close();
    } catch (Exception e) {
      out.println("<h3>Error: " + e.getMessage() + "</h3>");
    }
  }
}
