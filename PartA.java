import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    if ("admin".equals(user) && "1234".equals(pass)) {
      out.println("<h3>Login Successful!</h3>");
    } else {
      out.println("<h3>Invalid username or password.</h3>");
    }
    out.close();
  }
}
