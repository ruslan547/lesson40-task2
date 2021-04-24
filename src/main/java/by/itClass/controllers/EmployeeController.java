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
import java.sql.*;

@WebServlet(name = "employee", urlPatterns = {"/employee"})
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection cn = ConnectionManager.getConnection();
        Employee employee = new Employee();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        Boolean isFound = true;

        employee.setId(Integer.parseInt(request.getParameter("id")));
        employee.setName(request.getParameter("name"));
        employee.setPosition(request.getParameter("position"));
        employee.setSalary(Integer.parseInt(request.getParameter("salary")));

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, position, salary FROM employees WHERE id = " + employee.getId());

            if (!rs.next()) {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO employees(id, name, position , salary) VALUE (?, ?, ?, ?)");
                pst.setInt(1, employee.getId());
                pst.setString(2, employee.getName());
                pst.setString(3, employee.getPosition());
                pst.setInt(4, employee.getSalary());
                pst.execute();
                isFound = false;
            } else {
                employee.setName(rs.getString("name"));
                employee.setPosition(rs.getString("position"));
                employee.setSalary(rs.getInt("salary"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("employee", employee);
        request.setAttribute("isFound", isFound);
        dispatcher.forward(request, response);
    }
}
