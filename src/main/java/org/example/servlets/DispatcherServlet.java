package org.example.servlets;

import org.example.model.ProcessorResult;
import org.example.processors.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {
    private final List<Processor> processorList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        processorList.add(new ProcessorMainPage());
        processorList.add(new ProcessorShowAllStudents());
        processorList.add(new ProcessorAddStudent());
        processorList.add(new ProcessorDeleteStudent());
        processorList.add(new ProcessorSaveStudent());
        processorList.add(new ProcessorLogOut());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        for (Processor processor : processorList) {
            if (processor.canProcess(action)) {
                ProcessorResult result = processor.process(req);
                if (result.getPage() != null) {
                    req.getSession().setAttribute("includedJspPage", result.getPage());
                }
                if (result.isForward()) {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher(result.getView());
                    requestDispatcher.forward(req, resp);
                } else {
                    resp.sendRedirect(result.getView());
                }
            }
        }
    }

}
