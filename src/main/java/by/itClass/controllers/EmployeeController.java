package by.itClass.controllers;

import by.itClass.model.beans.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employee", urlPatterns = {"/employee"})
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");

        employee.setId(Integer.parseInt(request.getParameter("id")));
        employee.setName(request.getParameter("name"));
        employee.setName(request.getParameter("position"));
        employee.setSalary(Integer.parseInt(request.getParameter("salary")));

        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }
}
