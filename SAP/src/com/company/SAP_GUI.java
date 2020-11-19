package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class SAP_GUI extends JFrame {
    FileProcessor fp = new FileProcessor();
    private JPanel mainPanel;
    private JButton swapLinesButton;
    private JButton swapWordsButton;
    private JButton loadFileButton;
    private JButton saveFileButton;
    private JTextField textFieldForLine2Swap;
    private JTextField textFieldForLine1Swap;
    private JTextField textFieldLine1;
    private JTextField textFieldWord1;
    private JTextField textFieldLine2;
    private JTextField textFieldWord2;
    private JTextArea textShow;


    public SAP_GUI(String title){
        super(title);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        this.pack();
        swapLinesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   fp.swapLines(Integer.parseInt(textFieldForLine1Swap.getText()), Integer.parseInt(textFieldForLine2Swap.getText()));
                   textShow.setText(fp.getText());
                } catch (InvalidNumException invalidNumException) {
                    JOptionPane.showMessageDialog(mainPanel, "The number you've entered is invalid.");
                }
            }
        });
        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
                chooser.showOpenDialog(null);
                File file = chooser.getSelectedFile();
                String filename = file.getAbsolutePath();
                try{
                    fp.readFile(file);
                    FileReader reader = new FileReader(filename);
                    BufferedReader br = new BufferedReader(reader);
                    textShow.read(br, null);
                    br.close();
                    textShow.requestFocus();
                } catch (IOException fileNotFoundException) {
                    JOptionPane.showMessageDialog(mainPanel, "Invalid file.");
                }
            }
        });
        swapWordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fp.swapWords(Integer.parseInt(textFieldLine1.getText()), Integer.parseInt(textFieldWord1.getText()), Integer.parseInt(textFieldLine2.getText()), Integer.parseInt(textFieldWord2.getText()));
                    textShow.setText(fp.getText());
                } catch (InvalidNumException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "The number you've entered is invalid.");
                }
            }
        });
        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fp.saveFile();
            }
        });
    }
    public static void main(String args[]) {
        JFrame frame = new SAP_GUI("File Manipulator");
        frame.setVisible(true);

    }
}
