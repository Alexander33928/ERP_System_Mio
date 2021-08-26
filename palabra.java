import javax.swing.*;
import java.sql.*;

public class palabra {
    Connection con;
    public palabra(){
        Conexao con = new Conexao();
        try {
            this.con = con.conectaBD();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar no banco de dados, verifique!!!");
        }
    }

    public void buscarCode(int codigo) throws SQLException {
        String sql = "select * from products where Id = " + codigo;
        PreparedStatement consulta = con.prepareStatement(sql);
        ResultSet resultSet = consulta.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();

        int numeroColunas = metaData.getColumnCount();
        if (resultSet.next()) {
            do {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            } while (resultSet.next());
        } else {
            System.out.println("No existen registros");
        }
    }


    public void buscarName(String name) throws SQLException {
            String sql2 = "select * from products where name LIKE '%"+name+"%'";
            PreparedStatement consulta2 = con.prepareStatement(sql2);
            ResultSet resultSet2 = consulta2.executeQuery();
            ResultSetMetaData metaData2 = resultSet2.getMetaData();
            int numeroColunas = metaData2.getColumnCount();
            System.out.println(numeroColunas);
        if(resultSet2.next()) {
            do {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet2.getObject(i));
                }
                System.out.println();
            } while (resultSet2.next());
        } else {
            System.out.println("No existen registros");
        }
            }
    }


