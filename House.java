import java.util.ArrayList;
public class House extends Building{
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDining) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDining;
    this.residents= new ArrayList<String>();
    System.out.println("You have built a house:");
  }

  public String toString() {
    String description = super.toString();
    description += " There are currently" + this.residents.size() + " people living in the house";
    description += " This house ";
    if(this.hasDiningRoom){
      description+= "has a dining hall";
    }
    if (this.hasDiningRoom){
      description += "does not have a dining hall";
    }
    return description;
  }
  
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();
  }

  public void moveIn(String name){
    if(this.residents.contains(name)){
      throw new RuntimeException(name + " already lives here");
    }
    this.residents.add(name);
      System.out.println(name + " has just moved in to" + this.getName());
  }

  public String moveOut(String name){
    if(!this.residents.contains(name)){
      throw new RuntimeException(name + " does not live in " + this.getName());
    }
    this.residents.remove(name);
    System.out.println(name + " has moved out of " + this.getName());
    return name;
  }

  public boolean isResident(String name){
    return this.residents.contains(name);
  }
  public static void main(String[] args) {
    House king = new House("king", "180 Elm Street", 3, true);
    System.out.println(king);
    king.moveIn("Sophia");
    king.moveIn("Isobel");
    System.out.println(king.isResident("Sophia"));
  }
}