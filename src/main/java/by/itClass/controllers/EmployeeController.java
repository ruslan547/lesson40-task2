package by.itClass.controllers;

import by.itClass.db.ConnectionManager;
import by.itClass.model.beans.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "employee", urlPatterns = {"/employee"})
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection cn = ConnectionManager.getConnection();
        Employee employee = new Employee();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");

        employee.setId(Integer.parseInt(request.getParameter("id")));
        employee.setName(request.getParameter("name"));
        employee.setName(request.getParameter("position"));
        employee.setSalary(Integer.parseInt(request.getParameter("salary")));

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, position, salary FROM employee WHERE id = " + employee.getId());

            System.out.println(rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }
}
