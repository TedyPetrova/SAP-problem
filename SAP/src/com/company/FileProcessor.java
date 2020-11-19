package com.company;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class FileProcessor {
    File file;
    HashMap<Integer, List<String>> mapOfFile = new HashMap();
    public void readFile(File fileInput){
        try {
            file = fileInput;  //opening the file
            Scanner scan = new Scanner(file);  //reads the first line
            for (int i = 1; scan.hasNextLine(); i++){
                String data = scan.nextLine();  //stores it into a String
                String[] str = data.split(" ");
                List<String> list  = Arrays.asList(str);
                mapOfFile.put(i, list);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found.");
            System.exit(1);
        }
    }
    public void printFile(){
        for(int i = 1; i <= mapOfFile.size(); i++){
            List<String> list = this.mapOfFile.get(i);
            String joinedList = String.join(" ", list);
            System.out.println(joinedList);
        }
    }
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= this.mapOfFile.size(); i++) {
            sb.append(String.join(" ", this.mapOfFile.get(i)));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    public void swapLines(int l1, int l2) throws InvalidNumException, InputMismatchException {
        Scanner input = new Scanner(System.in);
        int line1, line2;
        ArrayList<String> templist = new ArrayList<String>();
        System.out.println("Enter both the lines that you want to swap.");
            line1 = l1;
            line2 = l2;
            if (line1 > mapOfFile.size() || line1 <=0 || line2 > mapOfFile.size() || line2 <=0){
                throw new InvalidNumException();
            }
            templist.add("temp");
            mapOfFile.put(mapOfFile.size()+1, mapOfFile.get(line1));
            mapOfFile.put(line1, mapOfFile.get(line2));
            mapOfFile.put(line2, mapOfFile.get(mapOfFile.size()));
            mapOfFile.remove(mapOfFile.size());
            System.out.println("\nThe modified file:\n");
    }
    public void swapWords(int firstLineIndex, int firstWordIndex, int secondLineIndex, int secondWordIndex) throws InvalidNumException{
        String tempWord = this.mapOfFile.get(firstLineIndex).get(firstWordIndex-1);
        this.mapOfFile.get(firstLineIndex).set(firstWordIndex-1, this.mapOfFile.get(secondLineIndex).get(secondWordIndex-1));
        this.mapOfFile.get(secondLineIndex).set(secondWordIndex-1, tempWord);
        System.out.println("\nThe modified file:");
    }
    public void saveFile(){
        List<String> tempList;
        String tempString = "";
        try {
            FileWriter writer = new FileWriter(file);
            for(int i = 1; i <= mapOfFile.size(); i++){
                tempList = mapOfFile.get(i);
                for (int j=0; j<tempList.size(); j++){
                    tempString = tempList.get(j);
                    writer.write(tempString+" ");
                }
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
