package you.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame implements ActionListener {

    //Function to create the top panel of the interface:
    public void createPanel(){
        JPanel topPanel = new JPanel();
        //We need to set the position of the image at the panel:
        //For that we are going to set the layout of the panel to null so that it takes our self-made layout:
        topPanel.setLayout(null);
        //changing the background of the top panel:
        topPanel.setBackground(new Color(10,102,194));
        //Setting the layout and putting the top Panel at the top:
        topPanel.setBounds(0,0, 400, 50);
        //Adding the panel into the Gui:
        add(topPanel);
        /*----------------------------------------*/
        //Using ImageIcon class to convert the image into icons in our directory:
        ImageIcon backImage = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        //Using Image class to scale our image to our précised sizing:
        Image scaledBackImage = backImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        //Since we cannot set the scaled image directly to the JLabel therefore we have to convert into icon for that:
        ImageIcon scaledBackImageIcon = new ImageIcon(scaledBackImage);
        //Adding the image to the topPanel:
        //for that we have to use JLabel and pass our image as an argument:
        JLabel backBtn = new JLabel(scaledBackImageIcon);
        //Now we are using our own layout for the image:
        backBtn.setBounds(5, 14, 20,20);
        topPanel.add(backBtn);
        /*----------------------------------------*/
        //Using ImageIcon class to convert the image into icons in our directory:
        ImageIcon userImage = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        //Using Image class to scale our image to our précised sizing:
        Image scaledUserImage = userImage.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        //Since we cannot set the scaled image directly to the JLabel therefore we have to convert into icon for that:
        ImageIcon scaledUserImageIcon = new ImageIcon(scaledUserImage);
        //Adding the image to the topPanel:
        //for that we have to use JLabel and pass our image as an argument:
        JLabel userBtn = new JLabel(scaledUserImageIcon);
        //Now we are using our own layout for the image:
        userBtn.setBounds(350, 4, 40,40);
        topPanel.add(userBtn);

        /*----------------------------------------*/
        //Using ImageIcon class to convert the image into icons in our directory:
        ImageIcon phoneImage = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        //Using Image class to scale our image to our précised sizing:
        Image scaledPhoneImage = phoneImage.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        //Since we cannot set the scaled image directly to the JLabel therefore we have to convert into icon for that:
        ImageIcon scaledPhoneImageIcon = new ImageIcon(scaledPhoneImage);
        //Adding the image to the topPanel:
        //for that we have to use JLabel and pass our image as an argument:
        JLabel phoneBtn = new JLabel(scaledPhoneImageIcon);
        //Now we are using our own layout for the image:
        phoneBtn.setBounds(320, 13, 25,25);
        topPanel.add(phoneBtn);

        /*----------------------------------------*/
        //Using ImageIcon class to convert the image into icons in our directory:
        ImageIcon videoImage = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        //Using Image class to scale our image to our précised sizing:
        Image scaledVideoImage = videoImage.getImage().getScaledInstance(20,25,Image.SCALE_DEFAULT);
        //Since we cannot set the scaled image directly to the JLabel therefore we have to convert into icon for that:
        ImageIcon scaledVideoImageIcon = new ImageIcon(scaledVideoImage);
        //Adding the image to the topPanel:
        //for that we have to use JLabel and pass our image as an argument:
        JLabel videoBtn = new JLabel(scaledVideoImageIcon);
        //Now we are using our own layout for the image:
        videoBtn.setBounds(292, 13, 20,25);
        topPanel.add(videoBtn);


        /*-----------------------------*/
        //Label for user name
        JLabel userLabel = new JLabel("UserName");
        userLabel.setBounds(40, 12, 120, 12);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("SAN-SERIF", Font.BOLD, 16));
        topPanel.add(userLabel);

        /*-----------------------------*/
        //Label for user name
        JLabel activeLabel = new JLabel("Active Now");
        activeLabel.setBounds(40, 26, 80, 12);
        activeLabel.setForeground(Color.GREEN);
        activeLabel.setFont(new Font("SAN-SERIF", Font.BOLD, 10));
        topPanel.add(activeLabel);



        //Event listener to close the application when back button is clicked:
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });



    }

    //This function is a container to all the basics related to GUI:
    public void guiBasics(){
        //Setting the size:
        setSize(400, 650);
        //Setting the location:
        setLocation(250, 50);
        //Changing the background color of the interface:
        getContentPane().setBackground(Color.DARK_GRAY);
        //Setting the layout to null initially will change it later:
        setLayout(null);

        //Using the topPanel function so that it instantiate:
        this.createPanel();

        //This function ends the whole program when user click on the cancel mark on the header of the interface!
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    //This is just to override the abstract method of the class actionPerformed:
    public void actionPerformed(ActionEvent ae){
    }


    //Window class constructor:
    public Window(){
        //using the guiBasics function that we created:
        this.guiBasics();
        //setting the visibility to true:
        super.setVisible(true);
    }
}
