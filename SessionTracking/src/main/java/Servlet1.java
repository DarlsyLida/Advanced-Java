import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Session_servlet1")
public class Servlet1 extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter p = res.getWriter();

        p.println("<html>");
        p.println("<body>");
        String name = req.getParameter("name");
        p.println("<h1>hello " + name);
        p.println("<a href='Servlet2'>go to next servlet</a>");
        p.println("</body>");
        p.println("</html>");
    }
}