package homeWorkChatBot;

/**
 * Java. Chatter: chatbot interface;
 *
 * @author Alexey Androsov;
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class ChatBot extends JFrame implements ActionListener {


    final String TITLE_OF_PROGRAM = "Chatter: simple chatbot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String CHB_AI = "AI";
    final String BTN_ENTER = "Enter";

    JTextArea dialogue; // area for dialog
    JCheckBox ai;       // enable/disable AI
    JTextField message; // field for entering messages

    public static void main(String[] args) throws IOException {
        new ChatBot();
    }

    /**
     * Constructor:
     * Creating a window and all the necessary elements on it
     */
    ChatBot() throws IOException {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        // area for dialog
        dialogue = new JTextArea();
        dialogue.setLineWrap(true);
        JScrollPane scrollBar = new JScrollPane(dialogue);
        // panel for checkbox, message field and button
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox(CHB_AI);
        ai.doClick();
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton(BTN_ENTER);
        enter.addActionListener(this);
        // adding all elements to the window
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (message.getText().trim().length() > 0) {
            try {
                dialogue.append(message.getText() + "\n");
                BufferedWriter out = new BufferedWriter(new FileWriter("1.txt", true));

                out.write(message.getText());
                out.newLine();
                out.close();
            } catch (Exception e) {
            }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}
