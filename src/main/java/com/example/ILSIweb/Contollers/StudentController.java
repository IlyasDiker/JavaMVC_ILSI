package com.example.ILSIweb.Contollers;

import com.example.ILSIweb.Models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String FirstName = request.getParameter("FirstName").toString();
        String LastName = request.getParameter("LastName").toString();
        String Sexe = request.getParameter("sexe").toString();

        Student NewStudent = new Student(FirstName, LastName, Sexe) ;

        NewStudent.save();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>User "+NewStudent.getFirstName()+" "+NewStudent.getLastName()+" Added Succesfully</h1>");
        out.println("</body></html>");
        
    }
}
