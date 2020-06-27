package at.cc.jku.chat;

import java.sql.*;

public class UserDAO {
    //private UserVO user;
    private String url;

    public UserDAO() {

        this.url = this.url = "jdbc:mysql://localhost:3306/chat?user=root";

    }

    public UserVO getUser(String userName) {
        UserVO user = null ;//new UserVO(1, userName);
        user = searchUser(userName);
        return user;
    }

    public UserVO getUser(int id){
        UserVO user = null ;//new UserVO(1, userName);
        user = searchUserById(id);
        return user;

    }

    private UserVO searchUserById(int id) {

        UserVO user = null;

        try {
            Connection connection = DriverManager.getConnection(this.url);
            final String sql = "SELECT `id`, `name` FROM `user` WHERE id = '" + id + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                // user gibt es in der Datenbank UserVO anlegen;
                int userid = rs.getInt("id");
                String name = rs.getString("name");

                //System.out.println(id + " - " + name);

                user = new UserVO(userid, name);

                //System.out.println("Fond user in MySQL: " + user.getName());

            }



        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

        return user;

    }

    private UserVO searchUser(String userName) {

        UserVO user = null;

        try {
            Connection connection = DriverManager.getConnection(this.url);
            final String sql = "SELECT `id`, `name` FROM `user` WHERE name = '" + userName + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                // user gibt es in der Datenbank UserVO anlegen;
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println(id + " - " + name);

                user = new UserVO(id, name);

                System.out.println("Fond user in MySQL: " + user.getName());

            } else {
                // Diesen User gibte es in der Datenbank noch nicht
                // neuen user anlegen
                user = new UserVO(0 ,userName);
                addUser(user);

                user = searchUser(userName);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

        return user;

    }

    public void addUser(UserVO user) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url);
            String sql;

            final String sql1 = "INSERT INTO `user` ( `id`, `name`) VALUES ( ?, ? )";
            PreparedStatement ps = connection.prepareStatement(sql1);

            ps.setString(1, null);
            ps.setString(2, user.getName());

            ps.executeUpdate();

            System.out.println("Added user to MySQL:"  + user.getName() );

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }
    }
}
