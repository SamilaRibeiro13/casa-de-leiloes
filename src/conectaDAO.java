import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    public static Connection conectaBD() {

        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/leiloes";
            String user = "root";
            String password = "081520";

            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException erro) {
            System.out.println("Erro ao conectar ao banco: " + erro.getMessage());
        }

        return conn;
    }
}
