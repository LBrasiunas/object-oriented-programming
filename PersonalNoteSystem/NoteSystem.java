/**
 * The package of all the classes which make the personal note system work
 */
package PersonalNoteSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class for executing the program
 */
public class NoteSystem {

    static ArrayList<Object> notes = new ArrayList<Object>();

    public static void main(String[] args) {

        JFrame f = new JFrame("Personal Note System");
        f.setSize(300, 80);
        f.setLocation(400,400);
        final JButton readButton = new JButton("Read");
        f.add(readButton);
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            FileInputStream fileIn = new FileInputStream("file.bin");
                            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                            notes = (ArrayList<Object>) objectIn.readObject();
                            objectIn.close();
                            fileIn.close();
                        } catch (ClassNotFoundException | IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
        final JButton writeButton = new JButton("Write");
        f.add(writeButton);
        writeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("file.bin");
                            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                            objectOut.writeObject(notes);
                            objectOut.flush();
                            objectOut.close();
                            fileOut.close();
                        } catch (IOException ex){
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
        f.setLayout(new FlowLayout());
        f.setVisible(true);

        System.out.println("\nPersonal Note System\n");
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Please select one of the following options (0-4):\n1.Create a new note" +
                    "\n2.Display created notes\n3.Delete a note\n0.Exit");
            int selection = -1;
            while(selection < 0 || selection > 4){
                selection = in.nextInt();
            }
            if(selection == 0){
                System.exit(0);
            }
            if(selection == 1){
                System.out.println("What do you want to create (1-4)?\n1.Simple note" +
                        "\n2.Homework note\n3.Standard event note\n4.Priced event note");
                selection = -1;
                while(selection < 1 || selection > 4){
                    selection = in.nextInt();
                }
                String s = in.nextLine();
                System.out.println("Enter the note title:");
                String noteTitle = in.nextLine();
                System.out.println("Enter the author:");
                String author = in.nextLine();
                LocalDate creationDate = LocalDate.now();
                if(selection == 1){
                    System.out.println("Enter the note text:");
                    String noteText = in.nextLine();
                    notes.add(new Note(noteTitle, creationDate, author, noteText));
                }
                if(selection == 2){
                    System.out.println("Enter the subject:");
                    String subject = in.nextLine();
                    System.out.println("Enter the due date year:");
                    int year = in.nextInt();
                    System.out.println("Enter the due date month:");
                    int month = in.nextInt();
                    System.out.println("Enter the due date day:");
                    int day = in.nextInt();
                    s = in.nextLine();
                    System.out.println("Enter the note text:");
                    String noteText = in.nextLine();
                    LocalDate dueDate = LocalDate.of(year, month, day);
                    notes.add(new Homework(noteTitle, subject, creationDate, dueDate, author, noteText));
                }
                if(selection == 3){
                    System.out.println("Enter the location:");
                    String location = in.nextLine();
                    System.out.println("Enter the due date year:");
                    int year = in.nextInt();
                    System.out.println("Enter the due date month:");
                    int month = in.nextInt();
                    System.out.println("Enter the due date day:");
                    int day = in.nextInt();
                    s = in.nextLine();
                    System.out.println("Enter the note text:");
                    String noteText = in.nextLine();
                    LocalDate dueDate = LocalDate.of(year, month, day);
                    notes.add(new Event(noteTitle, creationDate, dueDate, author, location, noteText));
                }
                if(selection == 4){
                    System.out.println("Enter the location:");
                    String location = in.nextLine();
                    System.out.println("Enter the price:");
                    int price = in.nextInt();
                    System.out.println("Enter the due date year:");
                    int year = in.nextInt();
                    System.out.println("Enter the due date month:");
                    int month = in.nextInt();
                    System.out.println("Enter the due date day:");
                    int day = in.nextInt();
                    s = in.nextLine();
                    System.out.println("Enter the note text:");
                    String noteText = in.nextLine();
                    LocalDate dueDate = LocalDate.of(year, month, day);
                    notes.add(new PricedEvent(noteTitle, creationDate, dueDate, author, location, price,noteText));
                }
                selection = -1;
                System.out.println("\nSuccess!");
            }
            if(selection == 2){
                if(notes.size() == 0){
                    System.out.println("There are no created notes. Nothing to display.\n");
                }
                else{
                    for(int i = 0; i < notes.size(); i++) {
                        System.out.print((i + 1) + ") " + notes.get(i).toString() + "\n");
                    }
                    System.out.println("\n");
                }
            }
            if(selection == 3){
                System.out.println("Which note would you like to delete? (enter the index number)");
                notes.remove(in.nextInt()-1);
            }
            /*if(selection == 4){
                if(notes.size() == 0){
                    System.out.println("There are no created notes. Nothing to manage.\n");
                }
                else{
                    System.out.println("Please select the note you want to manage (1-" + (notes.size()+1) + ").");
                    int index = -1;
                    while(index < 1 || index > notes.size() + 1){
                        index = in.nextInt();
                    }
                    System.out.println("\nNow select one of the following options (0-):\n1.Change note title\n2.Increase due date\n" +
                            "3.Add more text\n4.Change the subject\n5.Change the location\n6.Change the price" +
                            "\n0.Return to the main menu\n");
                    selection = -1;
                    while(selection < 0 || selection > 6){
                        selection = in.nextInt();
                    }
                    if(selection == 1){

                    }
                }
            }*/
        }
    }
}
