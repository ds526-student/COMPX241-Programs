public class Main{
    public static void main(String[] args) {
        System.out.println("Testing HashTables!");

        IntHashTable hashTable = new IntHashTable(3);
        hashTable.print();
        
        hashTable.insert(123, 1);
        hashTable.insert(3415, 2);
        hashTable.insert(9075329, 3);

        System.out.println();
        hashTable.print();
        
        hashTable.insert(9075330, 3);
        hashTable.insert(0, 4);
        System.out.println();
        hashTable.print();
    }
}