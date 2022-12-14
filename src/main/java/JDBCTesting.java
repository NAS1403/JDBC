import java.sql.*;
import java.util.Scanner;

public class JDBCTesting {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/payroll_service?characterEncoding=latin1";
        String USER = "root";
        String PASS = "Abhi@140397";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in ths classpath!", e);
        }

        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = con.prepareStatement("update employee_payroll set salary=? where name=?");
            preparedStatement.setDouble(1,100000);
            preparedStatement.setString(2,"Mark");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery("select * from employee_payroll");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " +
                        resultSet.getString(2) + " " +
                        resultSet.getString(3) + " " +
                        resultSet.getDouble(4) + " " +
                        resultSet.getDate(5));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
