package com.example.ILSIweb;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HelloServlet", value = "/ilyas")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Ilyas : try to send a POST method to me";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name").toString();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Ilyas : Hello " + name + "</h1>");
        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}