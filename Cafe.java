/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces= 50;
        this.nSugarPackets=20;
        this.nCreams=20;
        this.nCups=20;
    }

    public void sellCoffee(int size, int nSugar, int nCream) {
        if(this.nCoffeeOunces<size) {
            this.restock(size, 0, 0, 0);
        }
        if(this.nSugarPackets<nSugar) {
            this.restock(0, nSugar, 0, 0);
        }
        if(this.nCreams<nCream) {
            this.restock(0, 0, nCream, 0);
        }
        if(this.nCups<1) {
            this.restock(0, 0, 0, 20);
        }
        this.nCoffeeOunces = this.nCoffeeOunces- size;
        this.nSugarPackets = this.nSugarPackets-nSugar;
        this.nCreams = this.nCreams - nCream;
        this.nCups = this.nCups-1;
        System.out.println("you've sold a coffee");
    }

    private void restock(int coffee, int nSugar, int nCream, int cups) {
        this.nCoffeeOunces+= coffee;
        this.nSugarPackets+=nSugar;
        this.nCreams+=nCream;
        this.nCups+=cups;
    }
    public static void main(String[] args) {
        Cafe woodstar = new Cafe("Woodstar", "Northampton", 1);
        woodstar.sellCoffee(10, 2, 2);
        System.out.println(woodstar);

    }
}
