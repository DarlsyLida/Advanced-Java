package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/executeform")
public class MyForm extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String city = req.getParameter("city");
        String chk1 = req.getParameter("chk1");
        if (chk1 != null) {

            if (chk1.equals("checked")) {
                p.println(fname);
                p.println(lname);
                p.println(city);

            } else {
                p.println("you have not accepted terms and conditions");
            }

            RequestDispatcher rd = req.getRequestDispatcher("success");
            rd.forward(req, res);
        } else {
            p.println("you have not accepted terms and conditions");
            RequestDispatcher rd = req.getRequestDispatcher("Registration.html");
            rd.include(req, res);
        }
    }
}