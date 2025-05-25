import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployeeData {

    public static void main(String[] args) {

        // 1. MySQL database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/employee_salarys";
        String dbUser = "root";
        String dbPassword = "velu";

        // 2. SQL query to insert employee data
        String sql = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        try {
            // 3. Establish connection to MySQL
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("✅ Connected to database.");

            // 4. Prepare SQL insert statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 101);
            statement.setString(2, "Jenny");
            statement.setInt(3, 25);
            statement.setDouble(4, 10000);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Employee record inserted successfully.");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("❌ Error occurred while inserting data:");
            e.printStackTrace();
        }
    }
}

