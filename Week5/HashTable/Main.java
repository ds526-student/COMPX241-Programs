public class Main{
    public static void main(String[] args) {
        System.out.println("Printing Hash Table");;

        IntHashTable hashTable = new IntHashTable(3);
        hashTable.print();

        hashTable.insert(1, 10);
        hashTable.insert(2, 20);
        hashTable.insert(908234, 30);
        
        System.out.println();
        hashTable.print();

        hashTable.insert(1, 100); // This should cause a collision
        hashTable.insert(4, 40);
        System.out.println();
        hashTable.print();

        
    }
}