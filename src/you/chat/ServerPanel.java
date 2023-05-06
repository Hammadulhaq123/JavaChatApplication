package you.chat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServerPanel implements ActionListener {
    static JFrame frame = new JFrame();
    //Creating userMessage text field globally so that we can take its value out in the action listener:
    JTextField userMessage;
    //Creating the message panel globally to access it in the action listener function:
    JPanel messagePanel;
    //Creating a vertical box to align messages vertically:
    static Box verticalBox = Box.createVerticalBox();

    //Datastream to send the message in the text field to client:
    static DataOutputStream output;

    //Function to create the top panel of the interface:
    public void topPanel(){
        JPanel topPanel = new JPanel();
        //We need to set the position of the image at the panel:
        //For that we are going to set the layout of the panel to null so that it takes our self-made layout:
        topPanel.setLayout(null);
        //changing the background of the top panel:
        topPanel.setBackground(new Color(10,102,194));
        //Setting the layout and putting the top Panel at the top:
        topPanel.setBounds(0,0, 400, 50);
        //Adding the panel into the Gui:
        frame.add(topPanel);
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
        JLabel userLabel = new JLabel("Server");
        userLabel.setBounds(40, 12, 150, 15);
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



    //Function to create the messagePanel:
    public void messagePanel(){
        messagePanel = new JPanel();
        //changing the background of the top panel:
        messagePanel.setBackground(new Color(105,105,105));
        //Setting the layout and putting the top Panel at the top:
        messagePanel.setBounds(5,55, 390, 540);
        messagePanel.setBorder(new EmptyBorder(10,10,10,10));
        //Adding the panel into the Gui:
        frame.add(messagePanel);
    }

    //Function to create the sendPanel:
    public void sendPanel(){
        JPanel sendPanel = new JPanel();
        //We need to set the position of the image at the panel:
        //For that we are going to set the layout of the panel to null so that it takes our self-made layout:
        sendPanel.setLayout(null);
        //changing the background of the top panel:
        sendPanel.setBackground(Color.darkGray);
        //Setting the layout and putting the top Panel at the top:
        sendPanel.setBounds(0,595, 400, 55);
        //Adding the panel into the Gui:
        frame.add(sendPanel);

        //Creating a TextField and Send Button inside the send Panel:
        userMessage = new JTextField();
        userMessage.setBounds(5, 5, 280, 45);
        userMessage.setBackground(new Color(105,105,105));
        userMessage.setForeground(Color.WHITE);
        userMessage.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        userMessage.setBorder(new EmptyBorder(10,10,10,10));
        sendPanel.add(userMessage);

        JButton sendBtn = new JButton("Send");
        sendBtn.setBounds(290,5, 105, 45);
        sendBtn.setBackground(new Color(10,102,194));
        sendBtn.setForeground(Color.WHITE);
        sendBtn.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        sendBtn.addActionListener(this);
        sendPanel.add(sendBtn);

    }
    //This is just to override the abstract method of the class actionPerformed:
    public void actionPerformed(ActionEvent ae){
        try {
            String sendMessage = userMessage.getText();
            messagePanel.setLayout(new BorderLayout());
            JPanel sendMessagePanel = formatMessagePanel(sendMessage);

            JPanel rightSide = new JPanel(new BorderLayout());
            rightSide.add(sendMessagePanel, BorderLayout.LINE_END);

            verticalBox.add(rightSide);
            verticalBox.add(Box.createVerticalStrut(15));
            rightSide.setBackground(new Color(105, 105, 105));
            sendMessagePanel.setBackground(new Color(105, 105, 105));

            output.writeUTF(sendMessage);
            messagePanel.add(verticalBox, BorderLayout.PAGE_START);

            frame.repaint();
            frame.invalidate();
            frame.validate();

            userMessage.setText("");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static JPanel formatMessagePanel(String message){
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));


        JLabel sendMessageLabel = new JLabel("<html><p style= \" width: 150px; \">"+message+"</p></html>");
        sendMessageLabel.setBackground(new Color(10,102,194));
        sendMessageLabel.setForeground(Color.WHITE);
        //Without setting setOpaque to true we cannot change the background in this case!
        sendMessageLabel.setOpaque(true);
        //setBorder is used for spacing:
        sendMessageLabel.setBorder(new EmptyBorder(10,10,10,10));
        sendMessageLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        messagePanel.add(sendMessageLabel);

        //For Time of the message:
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        time.setFont(new Font("SAN_SERIF", Font.BOLD, 10));
        time.setForeground(Color.WHITE);
        messagePanel.add(time);


        return messagePanel;
    }


}
