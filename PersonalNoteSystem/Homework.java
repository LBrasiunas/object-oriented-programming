/**
 * The package of all the classes which make the personal note system work
 */
package PersonalNoteSystem;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A sub-class of Note for creating homework notes
 */
public class Homework extends Note implements Serializable {
    /**
     * A String for storing the subject
     */
    public String subject;

    // Constructors:
    /**
     * The default constructor which calls the Note class constructor
     * @param noteTitle
     * @param creationDate
     * @param author
     * @param noteText
     */
    public Homework(String noteTitle, LocalDate creationDate, String author, String noteText) {
        super(noteTitle, creationDate, author, noteText);
    }

    /**
     * The main constructor of the class
     * @param noteTitle
     * @param subject
     * @param creationDate
     * @param dueDate
     * @param author
     * @param noteText
     */
    public Homework(String noteTitle, String subject, LocalDate creationDate, LocalDate dueDate, String author, String noteText) {
        super.noteTitle = noteTitle;
        this.subject = subject;
        super.created = creationDate;
        super.due = dueDate;
        super.author = author;
        super.noteText = noteText;
    }

    // Get/Set methods:
    /**
     * Sets the given subject
     * @param subject
     */
    public void setSubject(String subject){
        this.subject = subject;
    }

    /**
     * Returns the subject
     * @return
     */
    public String getSubject(){
        return this.subject;
    }

    // Methods:
    /**
     * Returns all the information of the object in a neat way
     * @return
     */
    public String toString(){
        return "(Homework) " + super.noteTitle + ", by: " + super.author + ", for: " + this.subject + " [" + super.created + " - " + super.due +"] Contents:\n   " + super.noteText;
    }

    /**
     * Adds the given subject to the subject(s) in the note
     * @param newSubject
     */
    public void addSubject(String newSubject) {
        this.subject += ", " + newSubject;
    }

    /*public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
}
