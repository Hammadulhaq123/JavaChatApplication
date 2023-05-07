package you.chat;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends ClientWindow{
    //Constructor of the cLient class:

    public Client(){
        super();
    }

    //Main Function:
    public static void main(String [] args){
        new Client();

        try{
            Socket connect = new Socket("127.0.0.1", 3000);
            DataInputStream input = new DataInputStream(connect.getInputStream());
            output = new DataOutputStream(connect.getOutputStream());
            while(true){
                messagePanel.setLayout(new BorderLayout());
                //Reading the message of the client and storing it as a string:
                String msg = input.readUTF();
                //Creating a panel and giving it the functionalities of formatMessagePanel function that we created in ServerPanel:\
                JPanel clientMessage = formatMessagePanel(msg);
                //Creating a panel to set the alignment of incoming message to the left:
                JPanel clientMessageLayout = new JPanel(new BorderLayout());
                clientMessageLayout.setBackground(new Color(105,105,105));
                clientMessage.setBackground(new Color(105,105,105));
                sendMessageLabel.setBackground(Color.darkGray);
                clientMessageLayout.add(clientMessage, BorderLayout.LINE_START); //This will add the incoming mesage at the start
                verticalBox.add(clientMessageLayout);

                verticalBox.add(Box.createVerticalStrut(15));
                messagePanel.add(verticalBox, BorderLayout.PAGE_START);

                frame.validate();

            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
