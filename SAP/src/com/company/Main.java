package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SAP_GUI sp = new SAP_GUI("File Manipulator");
        sp.setVisible(true);
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Enter the directory of the file you want to manipulate: ");
        String directory = input.next();
        FileProcessor fp = new FileProcessor();
//        fp.readFile();
        fp.printFile();
        System.out.println("\n" + "--------------------------------------");
        System.out.println("\n" + "Choose what to do with the file.");
        System.out.println("Press 1 for switching one line with another. Press 2 for switching one word with another.");
        int choice = input.nextInt();
        if (choice == 1){
            /*try {
                fp.swapLines();
            } catch (InvalidNumException e) {
                e.printStackTrace();
            }*/
            fp.printFile();
        }
        else if (choice == 2){
            System.out.println("Enter:\n1)The first line index");
            int firstLineIndex = input.nextInt();
            System.out.println("2)The first word index");
            int firstWordIndex = input.nextInt();
            System.out.println("3)The second line index");
            int secondLineIndex = input.nextInt();
            System.out.println("4)The second word index");
            int secondWordIndex = input.nextInt();
            try {
                fp.swapWords(firstLineIndex, firstWordIndex, secondLineIndex, secondWordIndex);
            } catch (InvalidNumException e) {
                System.out.println("The number you've entered is invalid.");
            }
            fp.printFile();
        }
        else{
            System.err.println("I said 1 or 2.");
        }
        fp.saveFile();
    }
}

