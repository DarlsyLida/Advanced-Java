package com.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/first")
public class FirstServlet implements Servlet
{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet start");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet running");
    }

    @Override
    public String getServletInfo() {
        return "servlet info";
    }

    @Override
    public void destroy() {
        System.out.println("servlet stop");
    }
}