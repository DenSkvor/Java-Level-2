import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ButtonKeyListener implements KeyListener {

    private final JTextField messageField;
    private final JTextArea chatArea;

    public ButtonKeyListener(JTextArea textArea, JTextField textField) {
        this.messageField = textField;
        this.chatArea = textArea;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(messageField.getText().isEmpty()) return;

        if(e.getKeyChar() == KeyEvent.VK_ENTER){
            chatArea.append("NickName: " + messageField.getText() + "\n");
            chatArea.getText();
            messageField.setText("");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
