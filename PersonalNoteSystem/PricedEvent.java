/**
 * The package of all the classes which make the personal note system work
 */
package PersonalNoteSystem;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A sub-class of Note for creating priced event notes
 */
public class PricedEvent extends Note implements Serializable {
    /**
     * A String for storing the location
     */
    public String location;
    /**
     * An Integer for storing the price
     */
    public int price;

    // Constructors:

    /**
     * The default constructor which calls the Note class constructor
     * @param noteTitle
     * @param creationDate
     * @param author
     * @param noteText
     */
    public PricedEvent(String noteTitle, LocalDate creationDate, String author, String noteText) {
        super(noteTitle, creationDate, author, noteText);
    }

    /**
     * The main constructor of the class
     * @param noteTitle
     * @param creationDate
     * @param dueDate
     * @param author
     * @param location
     * @param price
     * @param noteText
     */
    public PricedEvent(String noteTitle, LocalDate creationDate, LocalDate dueDate, String author,
                       String location, int price, String noteText){
        super.noteTitle = noteTitle;
        super.created = creationDate;
        super.due = dueDate;
        super.author = author;
        this.location = location;
        this.price = price;
        super.noteText = noteText;
    }

    // Get/Set methods:

    /**
     * Sets the given location
     * @param location
     */
    public void setLocation(String location){
        this.location = location;
    }

    /**
     * Returns the location
     * @return
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * Sets the given price
     * @param price
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Returns the price
     * @return
     */
    public int getPrice(){
        return this.price;
    }

    // Methods:

    /**
     * Returns all the information of the object in a neat way
     * @return
     */
    public String toString(){
        return "(Priced Event) " + super.noteTitle + ", by: " + super.author + ", at: " + this.location + ", for: " + this.price + " [" + super.created + " - " + super.due +"] Contents:\n   " + super.noteText;
    }

    /**
     * Adds the given location to the location(s) in the note
     * @param newLocation
     */
    public void addLocation(String newLocation) {
        this.location += ", " + newLocation;
    }
}
