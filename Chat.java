import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {


    public Chat() {
        setTitle("Chatroom");
        setBounds(0, 0, 500, 500);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        setLayout(null);

        //top

        JTextArea chatArea = new JTextArea();
        chatArea.setBackground(new Color(255, 251, 181, 255));
        chatArea.setEditable(false);

        JScrollPane jspForChat = new JScrollPane(chatArea);
        jspForChat.setBounds(10, 10, getWidth() - 25, getHeight() - 125);

        JPanel top = new JPanel();
        top.setLayout(null);
        top.setBackground(new Color(255, 205, 118, 255));
        top.setBounds(0,0,getWidth(),getHeight() - 105);
        top.add(jspForChat);

        //bottom

        JTextField messageField = new JTextField();
        messageField.setBackground(new Color(255, 251, 181, 255));

        JScrollPane jspForMessageField = new JScrollPane(messageField);
        jspForMessageField.setBounds(10, 10, 360, 45);

        messageField.addKeyListener(new ButtonKeyListener(chatArea, messageField));

        JButton enterButton = new JButton("Отправить");
        enterButton.setBounds(380, 11, 104, 43);
        enterButton.setBackground(new Color(238, 136, 136, 255));

        ButtonListener buttonListener = new ButtonListener(chatArea, messageField, this);
        enterButton.addActionListener(buttonListener);

        JPanel bottom = new JPanel();
        bottom.setLayout(null);
        bottom.setBackground(new Color(255, 205, 118, 255));
        bottom.setBounds(0,getHeight() - 105,getWidth(),105);

        bottom.add(jspForMessageField);
        bottom.add(enterButton);


        add(top);
        add(bottom);


        setVisible(true);

    }
}