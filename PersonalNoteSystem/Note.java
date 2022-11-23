/**
 * The package of all the classes which make the personal note system work
 */
package PersonalNoteSystem;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A class for creating standard notes
 */
public class Note implements Serializable {
    /**
     * A String for storing the note title
     */
    public String noteTitle;
    /**
     * A String for storing the note text
     */
    public String noteText;
    /**
     * A String for storing the author of the note
     */
    public String author;
    /**
     * A LocalDate variable for storing the creation date of the note
     */
    public LocalDate created;
    /**
     * A LocalDate variable for storing the due date of the note
     */
    public LocalDate due;

    // Constructors:
    /**
     * The standard constructor for the Note class
     */
    public Note(){
        this("Testas", LocalDate.now(), "Vardenis Pavardenis", "Sukurtas pasinaudojus this().");
    }

    /**
     * The extended constructor for the Note class
     * @param noteTitle
     * @param creationDate
     * @param author
     * @param noteText
     */
    public Note(String noteTitle, LocalDate creationDate,
                String author, String noteText){
        this.noteTitle = noteTitle;
        this.created = creationDate;
        this.author = author;
        this.noteText = noteText;
    }


    // Getters and Setters:

    /**
     * Sets the given due date
     * @param date
     */
    public void setDueDate(LocalDate date){
        this.due = date;
    }

    /**
     * Returns the due date
     * @return
     */
    public LocalDate getDueDate(){
        return this.due;
    }

    /**
     * Returns the creation date
     * @return
     */
    public LocalDate getCreationDate(){
        return this.created;
    }

    /**
     * Sets the given note title
     * @param noteTitle
     */
    public void setNoteTitle(String noteTitle){
        this.noteTitle = noteTitle;
    }

    /**
     * Returns the note title
     * @return
     */
    public String getNoteTitle(){
        return this.noteTitle;
    }


    // Methods:

    /**
     * Returns all the information of the object in a neat way
     * @return
     */
    public String toString(){
        return "(Note) " + this.noteTitle + ", by: " + this.author + " [" + this.created + "] Contents:\n   " + this.noteText;
    }

    /**
     * Adds the given text to the text in the note
     * @param newText
     */
    public void addMoreText(String newText) {
        this.noteText += " -ADDED: " + newText;
    }

    /**
     * Increases the due date by the given days
     * @param daysToAdd
     */
    public void increaseDueDate(long daysToAdd){
        this.due = this.due.plusDays(daysToAdd);
    }
}
