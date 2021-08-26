import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public Connection conectaBD() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1/product","root","12345678");
    }
}
