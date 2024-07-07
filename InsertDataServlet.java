import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class InsertDataServlet extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;

    public void init() throws ServletException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//SachinKapoor:1521/orcl", "advjavabatch5", "mystudents");
            System.out.println("Connection opened");
            ps = conn.prepareStatement("INSERT INTO employees (emp_no, emp_name, emp_sal, emp_dept_no, emp_hire_date) VALUES (?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            System.out.println("Error in init:" + ex);
            throw new ServletException("Problem in init", ex);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Insert Data Response</title>");
        pw.println("</head>");
        pw.println("<body>");
        
        String empNo = req.getParameter("emp_no");
        String empName = req.getParameter("emp_name");
        String empSal = req.getParameter("emp_sal");
        String empDeptNo = req.getParameter("emp_dept_no");
        String empHireDate = req.getParameter("emp_hire_date");

        try {
            ps.setString(1, empNo);
            ps.setString(2, empName);
            ps.setString(3, empSal);
            ps.setString(4, empDeptNo);
            ps.setString(5, empHireDate);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                pw.println("<p>Data inserted successfully for employee: " + empName + "</p>");
            } else {
                pw.println("<p>Failed to insert data for employee: " + empName + "</p>");
            }
        } catch (SQLException ex) {
            pw.println("<p>Error occurred while inserting data</p>");
            ex.printStackTrace(pw);
        }
        
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }

    public void destroy() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException ex) {
            System.out.println("Cannot close the DB Connection");
            ex.printStackTrace();
        }
    }
}
