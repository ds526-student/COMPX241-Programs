public class Main{
    public static void main(String[] args) {
        System.out.println("Printing Hash Table");;

        IntHashTable hashTable = new IntHashTable(5);
        hashTable.print();

        hashTable.insert(1, 10);
        hashTable.insert(2, 20);
        hashTable.print();

        hashTable.delete(1);
        hashTable.print();
    }
}