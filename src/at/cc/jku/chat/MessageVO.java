package at.cc.jku.chat;

public class MessageVO {
    private int id;
    private String message;
    private int senderId;
    private int receiverID;

    public MessageVO(String message, int senderId, int receiverID) {
        this.message = message;
        this.senderId = senderId;
        this.receiverID = receiverID;
    }

    public MessageVO(int id, String message, int senderId, int receiverID) {
        this.id = id;
        this.message = message;
        this.senderId = senderId;
        this.receiverID = receiverID;
    }


    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverID() {
        return receiverID;
    }
}
