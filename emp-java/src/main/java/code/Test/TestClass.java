package code.Test;

import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;

public class TestClass {
    public static void main(String[] args){

        String url = "jdbc:postgresql://localhost:5432/hb_student_tracker?currentSchema=security";
        Properties props = new Properties();
        props.setProperty("user","vicky");
        props.setProperty("password","w8s0F4");
        props.setProperty("ssl","false");

        try{
            System.out.println("Connecting to the database: "+ url);
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Connection successful !!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}