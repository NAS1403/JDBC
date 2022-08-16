
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
        }
        catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in ths classpath!",e);
        }


        try{
            con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
         ResultSet result =  statement.executeQuery("select * from employee_payroll");
         while(result.next()){
             System.out.println(result.getInt("id")+" " +
                     result.getString(2) +" "+
                     result.getString(3)+ " "+
                     result.getDouble(4)+" "+
                     result.getDate(5));
         }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
