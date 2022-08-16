
import java.sql.*;
import java.util.Enumeration;

public class JDBCTesting {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/payroll_service?characterEncoding=latin1";
        String USER = "root";
        String PASS = "Abhi@140397";
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        }
        catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in ths classpath!",e);
        }

        listDrivers();

        try{
            System.out.println("Connecting to database: "+URL);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection is successful!!!! "+con);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass = driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
