public class Main {
    public static void main(String[] args) {
        System.out.println("Sets!");
        
        IntSet set = new IntSet(5);
        set.print();

        System.out.println("Is empty: " + set.isEmpty());
        System.out.println("Has a 5 in it: " + set.hasElement(5));

        System.out.println(" ");

        set.addElement(5);
        set.print();
        System.out.println("Is empty: " + set.isEmpty());
        System.out.println("Has a 5 in it: " + set.hasElement(5));
        
        set.addElement(1);
        set.addElement(3);
        set.addElement(4);
        set.print();

        set.removeElement(3);
        set.print();
    }
}