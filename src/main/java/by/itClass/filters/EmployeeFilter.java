package by.itClass.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebFilter(filterName = "EmployeeFilter", urlPatterns = {"/employee"})
public class EmployeeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        int id = Integer.parseInt(params.get("id")[0]);

        if (id < 1 || id > Integer.MAX_VALUE) {
            resp.getWriter().append("invalid id");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
