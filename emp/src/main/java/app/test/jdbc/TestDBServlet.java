package app.test.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlet")
public class TestDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String urls = "jdbc:postgresql://localhost:5432/hb_student_tracker?currentSchema=crm";
        Properties props = new Properties();
        props.setProperty("user","vicky");
        props.setProperty("password","w8s0F4");
        props.setProperty("ssl","false");
        String driver = "org.postgresql.Driver";
        try{
            PrintWriter out = response.getWriter();
            out.println("connecting to the database....." + urls);
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(urls, props);
            out.println("connection successfully");
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
