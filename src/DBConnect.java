
import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/dvdrental";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "burcak";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {

            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM employee");

            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("id"));
                System.out.println("Adı : " + resultSet.getString("name"));
                System.out.println("Pozisyonu : " + resultSet.getString("position"));
                System.out.println("Maaşı : " + resultSet.getInt("salary"));
                System.out.println("#################");
            }

        }
        catch (SQLException ex) {

            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}