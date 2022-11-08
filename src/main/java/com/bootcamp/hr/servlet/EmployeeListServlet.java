package com.bootcamp.hr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.hr.dao.EmployeeDAO;
import com.bootcamp.hr.entity.Employee;
import com.bootcamp.hr.jdbc.DatabaseConnectionManager;

public class EmployeeListServlet extends HttpServlet {
    private DatabaseConnectionManager connectionManager;
    private EmployeeDAO employeeDAO;

    @Override
    public void init() throws ServletException {
        connectionManager = new DatabaseConnectionManager();
        employeeDAO = new EmployeeDAO(connectionManager);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        List<Employee> employees = employeeDAO.findAll();

        out.print("<html>");
        out.print("<head>");
        out.print("<title>Employee List</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Employee List</h1>");
        out.print("<hr/>");
        out.print("<table>");
        out.print("<thead>");
        out.print("<tr>");
        out.print("<td>Employee ID</td>");
        out.print("<td>First Name</td>");
        out.print("<td>Last Name</td>");
        out.print("<td>Email</td>");
        out.print("<td>Salary</td>");
        out.print("<td>Department ID</td>");
        out.print("<td>Department Name</td>");
        out.print("<td>Job ID</td>");
        out.print("<td>Job Title</td>");
        out.print("</tr>");
        out.print("</thead>");
        out.print("<tbody>");
        for (Employee employee : employees) {
            out.print("<tr>");
            out.print("<td>" + employee.getId() + "</td>");
            out.print("<td>" + employee.getFirstName() + "</td>");
            out.print("<td>" + employee.getLastName() + "</td>");
            out.print("<td>" + employee.getEmail() + "</td>");
            out.print("<td>" + employee.getSalary() + "</td>");
            out.print("<td>" + employee.getDept_id() + "</td>");
            out.print("<td>" + employee.getDept_name() + "</td>");
            out.print("<td>" + employee.getJob_id() + "</td>");
            out.print("<td>" + employee.getJob_title() + "</td>");
            out.print("</tr>");
        }
        out.print("</tbody>");
        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
        out.flush();
        out.close();
    }
}
