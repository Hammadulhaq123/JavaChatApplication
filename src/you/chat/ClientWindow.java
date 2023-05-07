package you.chat;

import javax.swing.*;
import java.awt.*;


public class ClientWindow extends ClientPanel {


    //Instantiating all the Panels :
    public void createPanel(){
        super.topPanel();
        super.messagePanel();
        super.sendPanel();

    }

    //This function is a container to all the basics related to GUI:
    public void guiBasics(){
        //Setting the size:
        frame.setSize(400, 650);
        //Setting the location:
        frame.setLocation(750, 50);
        //Changing the background color of the interface:
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        //Setting the layout to null initially will change it later:
        frame.setLayout(null);
        //Using the createPanel function so that it instantiate:
        this.createPanel();


        //This disables our top minimize and close opt
        frame.setUndecorated(true);
    }


    //Window class constructor:
    public ClientWindow(){
        //using the guiBasics function that we created:
        this.guiBasics();
        //setting the visibility to true:
        frame.setVisible(true);
    }
}
