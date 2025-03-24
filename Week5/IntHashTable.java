
public class IntHashTable {
    Node[] hashTable;
    int size;

    public IntHashTable(int size) {
        hashTable = new Node[size];
        this.size = size;
    }

    public int getHash (int k) {
        return k % size;
    }

    public void insert(int k, int v) {
        int index = getHash(k);
        hashTable[index] = new Node(k, v);

        if (hashTable[index] == null) {
            hashTable[index] = new Node(k, v);
        } else {
            System.out.println("Collision detected at index " + index + " for key " + k);
            // Handle collision (e.g., linear probing, chaining, etc.)
        }
    }

    public void delete(int k) {
        int index = getHash(k);
        if (hashTable[index] != null && hashTable[index].k == k) {
            hashTable[index] = null;
        } else {
            System.out.println("Key " + k + " not found for deletion.");
        }
    }

    public void print() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                System.out.println("Key:Value -> " + hashTable[i].k + ":" + hashTable[i].v);
            } else {
                System.out.println("Key:Value " + i + ": null");
            }
        }
    }
}