package cookie_example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookies1")
public class Cookie_servlet1 extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();
        p.println("<html>");
        p.println("<body>");

        String name = req.getParameter("uname");
        p.println("welcome, " + name);

        p.println("<a href='cookies2'>go to next servlet</a>");

        //create a cookie
        Cookie c=new Cookie("user_name",name);
        res.addCookie(c);

        p.println("</body>");
        p.println("</html>");
    }
}