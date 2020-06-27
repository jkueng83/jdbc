package at.cc.jku.chat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    private String url;

    public MessageDAO() {

        this.url = this.url = "jdbc:mysql://localhost:3306/chat?user=root";

    }

    public void addMessage(MessageVO message) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url);

            final String sql1 = "INSERT INTO `message` ( `id`, `message` , `senderid` , `receiverID`) " +
                    "VALUES ( ?, ?, ?, ? )";
            PreparedStatement ps = connection.prepareStatement(sql1);

            ps.setString(1, null);
            ps.setString(2, message.getMessage());
            ps.setString(3, Integer.toString(message.getSenderId()));
            if (message.getReceiverID() == 0) {
                ps.setString(4, "-1"); // Message for all Users
            } else {
                ps.setString(4, String.valueOf(message.getReceiverID()));
            }

            ps.executeUpdate();

            // System.out.println("Added message to MySQL:" + message.getMessage());

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Keine Verbindung zu MySQL!!!");

        }

    }

    public List<MessageVO> getMessages(int startMessageId) {

        Connection connection = null;
        List<MessageVO> messages = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(this.url);
            //System.out.println("Verbindung zu MySQL aufgebaut");

            String sql = "SELECT * FROM `message` WHERE id >= " + startMessageId + " ORDER BY id";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String message = rs.getString("message");
                int senderId = rs.getInt("senderId");
                int receiverId = rs.getInt("receiverID");

                MessageVO messageVO = new MessageVO(id, message, senderId, receiverId);
                messages.add(messageVO);

            }

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

        return messages;

    }
}
