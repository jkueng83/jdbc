package at.cc.jku;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/bibliothek?user=root"; /* &password=123 */

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Verbindung zu MySQL aufgebaut");

            String sql = "select * from buch";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String isbn = rs.getString("isbn");
                String Buchtitel = rs.getString("buchtitel");
                int fk_autor = rs.getInt("fk_autor");

                System.out.println("Buch Id: " + id + " - ISBN Nr.: " + isbn + " - Buchtitel: " + Buchtitel + " - FK Autor: " + fk_autor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }
    }
}
