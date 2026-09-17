package cookie_example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookies2")
public class Cookie_Servlet2 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();

        //getting all cookies
        Cookie[] c1= req.getCookies();
        boolean f=false;
        String name="";

        if(c1==null)
        {
            p.println("you are a new user and goto home page and submit your form");
        }
        else {
            for(Cookie c:c1)
            {
                String temp_cookie=c.getName();
                if(temp_cookie.equals("user_name"))
                {
                    f=true;
                    name=c.getValue();
                }
            }
        }

        if(f) {

            p.println("<h1> welcome,</h1>" + name + " <a href='login.html>go back to login page</a>'");
        }

    }
}