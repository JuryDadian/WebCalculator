package by.tms.servlet;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findHistory")
public class HistoryServlet extends HttpServlet {
    private final CalculatorService calculatorHistoryService = new CalculatorService();
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Operation> operationsInJDBC = calculatorHistoryService.showHistoryInJDBC();

        if (operationsInJDBC.isEmpty()){
            resp.getWriter().println("Operation not found!");
        } else {
            operationsInJDBC.forEach(resp.getWriter()::println);
        }
    }
}
