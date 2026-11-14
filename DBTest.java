import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.println("MySQL Connected Successfully!");
            System.out.println("Database: " + con.getCatalog());

        } catch (Exception e) {

            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}
