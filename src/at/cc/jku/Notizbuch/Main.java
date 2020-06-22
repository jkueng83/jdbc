package at.cc.jku.Notizbuch;

import at.cc.jku.functions.DateTimeString;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        /*
        Digitales Notizbuch 2.0

        Task 1:
        Es ist sinnvoll neben den gelieferten Unterlagen auch ein persönliches Notizbuch zu führen. Für die Verwaltung
        dieser Notizen erstellen wir uns ein kleines Programm. Erstelle dafür eine neue Mysql Datenbank mit einer
        Tabelle welche sinnvolle Felder für eine Notiz besitzt. Versuche über phpmyadmin Einträge hinzuzufügen und dann
        mit einer Java Anwendung wieder auszugeben.

        Task 2:
        Erweitere das Programm, damit auch neue Notizen eingegeben werden können.

        */

        Connection connection = null;

        final String url = "jdbc:mysql://localhost:3306/notizbuch?user=root"; /* &password=123 */

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Verbindung zu \"" + url + "\" aufgebaut.");

            for (int i = 0; i < 5; i++) {
                addNote(connection, "Klaus", "Notiz " + i + ":" + " Hallo mein Name ist Klaus???!");
            }

            printDataFromMySQLNote(connection);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu: " + url);
        }

    }

    private static void printDataFromMySQLNote(Connection connection) throws SQLException {
        final String sql = "select * from note order by datetime";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        int i = 0;
        while (rs.next()) {
            int id = rs.getInt("id");
            String note = rs.getString("note");
            String author = rs.getString("author");
            String dateTime = rs.getDate("datetime").toString();
            dateTime = dateTime + " " + rs.getTime("datetime").toString();
            System.out.println(id + " - " + dateTime + " - " + author + ": " + note);
            i++;
        }
        System.out.println("Size:"+i);
    }

    private static void addNote(Connection connection, String author, String note) throws SQLException {
        String sql;

        DateTimeString dateTimeString = new DateTimeString();
        String dateTime = dateTimeString.getDateTime();

        //sql = "INSERT INTO `note` (`id`, `note`, `author`, `datetime`) VALUES (NULL, '" + note + "', '" + author +
        // "', '2020-06-30 11:42:03')";
        sql = "INSERT INTO `note` ( `note`, `author`, `datetime`) VALUES ( '" + note + "', '" + author + "', '" +
                dateTime + "')";

        final String sql1 = "INSERT INTO `note` ( `note`, `author`, `datetime`) VALUES ( ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql1);
        ps.setString(3,dateTime);
        ps.setString(1,note);
        ps.setString(2,author);


        ps.executeUpdate();
    }
}
