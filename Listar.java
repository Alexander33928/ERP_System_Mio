import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Listar {
      Connection con;

      public Listar(){
        Conexao con = new Conexao();
        try {
            this.con = con.conectaBD();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar no banco de dados, verifique!!!");
        }
      }

    public void listarArray() throws SQLException {

        ArrayList<Producto> listProducto = new ArrayList<>();

        String sql = "select * from products";
        PreparedStatement consulta = con.prepareStatement(sql);
        ResultSet resultSet = consulta.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();

        int numeroColunas = metaData.getColumnCount();
        while (resultSet.next()) {
            Producto objProducto = new Producto();
            objProducto.setId(resultSet.getInt("Id"));
            objProducto.setPricesAmountMax(resultSet.getDouble("prices.amountMax"));
            objProducto.setPricesAmountMin(resultSet.getDouble("prices.amountMin"));
            objProducto.setPricesAvailability(resultSet.getString("prices.availability"));
            objProducto.setPricesCondition(resultSet.getString("prices.condition"));
            objProducto.setPricesCurrency(resultSet.getString("prices.currency"));
            objProducto.setPriceDateSeen(resultSet.getString("prices.dateSeen"));
            objProducto.setPricesIsSale(resultSet.getString("prices.isSale"));
            objProducto.setPricesMerchant(resultSet.getString("prices.merchant"));
            objProducto.setPricesShipping(resultSet.getString("prices.shipping"));
            objProducto.setPricesSourceURLs(resultSet.getString("prices.sourceURLs"));
            objProducto.setAsins(resultSet.getString("asins"));
            objProducto.setBrand(resultSet.getString("brand"));
            objProducto.setCategories(resultSet.getString("categories"));
            objProducto.setDateAdded(resultSet.getString("dateAdded"));
            objProducto.setDateUpdated(resultSet.getString("dateUpdated"));
            objProducto.setEan(resultSet.getString("ean"));
            objProducto.setImageURLs(resultSet.getString("imageURLs"));
            objProducto.setKeys(resultSet.getString("keys"));
            objProducto.setManufacturer(resultSet.getString("manufacturer"));
            objProducto.setManufacturerNumber(resultSet.getString("manufacturerNumber"));
            objProducto.setName(resultSet.getString("name"));
            objProducto.setPrimaryCategories(resultSet.getString("primaryCategories"));
            objProducto.setSourceURLs(resultSet.getString("sourceURLs"));
            objProducto.setUpc(resultSet.getDouble("upc"));
            objProducto.setWeight(resultSet.getString("weight"));
            listProducto.add(objProducto);
        }

        con.close();
        consulta.close();

        for (Producto objList: listProducto) {
            System.out.println(objList.getId() + "," + objList.getPricesAmountMax() + "," +objList.getPricesAmountMax()+ "," +objList.getPricesAvailability()+ "," +objList.getPricesCondition()+ "," +objList.getPricesCurrency()+ "," +objList.getPriceDateSeen()+ "," +objList.getPricesIsSale()+ "," +objList.getPricesMerchant()+ "," +objList.getPricesShipping()+ "," +objList.getPricesSourceURLs()+ "," +objList.getAsins()+ "," +objList.getBrand()+ "," +objList.getCategories()+ "," +objList.getDateAdded()+ "," +objList.getDateUpdated()+ "," +objList.getEan()+ "," +objList.getImageURLs()+ "," +objList.getKeys()+ "," +objList.getManufacturer()+ "," +objList.getManufacturerNumber()+ "," +objList.getName()+ "," +objList.getPrimaryCategories()+ "," +objList.getSourceURLs()+ "," +objList.getUpc()+ "," +objList.getWeight());
        }
    }
}
