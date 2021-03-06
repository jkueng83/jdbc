package at.cc.jku.chat;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Chat {


    private Scanner scanner;
    // private List<NoteVO> notes;

    private UserVO myUser;
    private UserDAO userDAO;

    // private MessageVO messageVO;
    private MessageDAO messageDAO;

    //private int sizeBeforeUpdate = this.notes.size();

    private int lastPrintedMessageID;

    public Chat() {




        this.userDAO = new UserDAO();

        this.messageDAO = new MessageDAO();

        String userName = getChatUser();

        this.myUser = this.userDAO.getUser(userName);

        this.lastPrintedMessageID = 0;



    }

    private String getChatUser() {
        scanner = new Scanner(System.in);
        System.out.println("Please enter your user name: ");
        return scanner.nextLine();
    }


    public void chatTask() {

        updateMessages();

        Timer timer = new Timer();
        TimerTask update = new TimerTask() {
            @Override
            public void run() {
                updateMessages();
            }
        };


        timer.scheduleAtFixedRate(update,0,1000);


        while (true) {



            String inputNote = this.scanner.nextLine();

            MessageVO messageVO = new MessageVO(inputNote, this.myUser.getId(), 0);

            this.messageDAO.addMessage(messageVO);

            //updateMessages();

        }
    }

    private void updateMessages() {

        List<MessageVO> messages = this.messageDAO.getMessages(this.lastPrintedMessageID + 1);

        for (MessageVO message : messages) {


            System.out.println(this.userDAO.getUser(message.getSenderId()).getName() +
                    " is writing:\t" + message.getMessage());
            this.lastPrintedMessageID = message.getId();

        }

    }
}
