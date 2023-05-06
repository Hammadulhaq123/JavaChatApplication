package you.chat;


import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerWindow{
    //Constructor of the Server Class:
    public Server(){
        super();
    }

    //Main function:
    public static void main(String [] args){
        new Server();

        try{
            ServerSocket server = new ServerSocket(3000);
            while(true){
                Socket socket = server.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());

                while(true){
                    //Reading the message of the client and storing it as a string:
                    String msg = input.readUTF();
                    //Creating a panel and giving it the functionalities of formatMessagePanel function that we created in ServerPanel:\
                    JPanel clientMessage = formatMessagePanel(msg);
                    //Creating a panel to set the alignment of incoming message to the left:
                    JPanel clientMessageLayout = new JPanel(new BorderLayout());
                    clientMessageLayout.add(clientMessage, BorderLayout.LINE_START); //This will add the incoming mesage at the start
                    verticalBox.add(clientMessageLayout);

                    frame.validate();

                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
