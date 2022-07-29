package at.htlklu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CesarGUI {
    private JPanel contentPane;
    private JTextArea txtInput;
    private JLabel lblKey;
    private JTextField txtKey;
    private JButton btnEncode;
    private JButton btnDecode;


    public CesarGUI() {
        btnEncode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                encodeDecode(true);
            }
        });
        btnDecode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encodeDecode(false);
            }
        });
    }

    private void encodeDecode(boolean encode) {

        // Auslesen der GUI
        String input = txtInput.getText();
        String keyAsString = txtKey.getText();
        int key = Integer.parseInt(keyAsString);

        // Verschlüsseln

        String encodedInput;

        if(encode) {
            encodedInput = CesarEncoder.encode(input, key);
        } else {
            encodedInput = CesarEncoder.decode(input, key);
        }

        // in das Textfeld zurückschreiben
        txtInput.setText(encodedInput);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cäsar Verschlüsselung");
        frame.setContentPane(new CesarGUI().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
