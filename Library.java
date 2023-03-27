import java.util.Hashtable;
import java.util.Enumeration;
public class Library extends Building{
    public Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection= new Hashtable<String, Boolean>();
      System.out.println("You have built a library");
    }
    /**
     * adds a title to the hashtable
     * @param title
     */
    public void addTitle(String title){
      if (this.collection.containsKey(title)){
        throw new RuntimeException("This book is already in the library");
      }
      this.collection.put(title, true);
    }
    /**
     * remoces title from hashtable
     * @param title
     * @return title
     */
    public String removeTitle(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException("This book is not in the library");
      }
      this.collection.remove(title);
      return title;
    }
    /**
     * changes the boolean to false to check out the book
     * @param title
     */
    public void checkOut(String title){
      if(!this.collection.containsKey(title)){
        throw new RuntimeException("This book is not in the library");
      }
      if(!this.collection.get(title)){
        throw new RuntimeException("This book is not available");
      }
      this.collection.replace(title, false);
    }
    /**
     * reverts boolean to true to return the book
     * @param title
     */
    public void returnBook(String title){
      if(!this.collection.containsKey(title)){
        throw new RuntimeException("This book is not in the library");
      }
      if(this.collection.get(title)){
        throw new RuntimeException("This book is not checked out");
      }
      this.collection.replace(title, true);
    }
    /**
     * checks if the library has the book
     * @param title
     * @return true/false if hashtable contains title
     */
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }
    /**
     *checks if the book is available 
     * @param title
     * @return true/false if the book is availbale 
     */
    public boolean isAvailable(String title){
      if(!this.collection.containsKey(title)){
        throw new RuntimeException("This book is not in the library");
      }
      return this.collection.get(title);
    }
    /**
     * this wont print!!
     */
    public void printCollection(){
      Enumeration<String> e = this.collection.keys();

      while (e.hasMoreElements()) {
        String nextElem = e.nextElement();
        if (this.collection.get(nextElem)) {
          System.out.println(nextElem + " is available");
        } else {
          System.out.println(nextElem + " is not available");
        }
      }
    }

    public static void main(String[] args) {
      Library forbes = new Library("Forbes Library", "Green Street", 4);
      forbes.addTitle("LOTR");
      forbes.addTitle("Harry Potter");
      forbes.addTitle("Name of the Wind");
      forbes.printCollection();
      System.out.println(forbes);
    }
  }