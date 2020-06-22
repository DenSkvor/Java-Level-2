import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private final JTextField messageField;
    private final JTextArea chatArea;
    private final JFrame parent;

    public ButtonListener(JTextArea textArea, JTextField textField, JFrame parent) {
        this.messageField = textField;
        this.chatArea = textArea;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(messageField.getText().isEmpty()) {
            parent.requestFocus();
            return;
        }
        JButton current = (JButton) e.getSource();
        chatArea.append("NickName: " + messageField.getText() + "\n");
        chatArea.getText();
        messageField.setText("");
        parent.requestFocus();
    }
}
