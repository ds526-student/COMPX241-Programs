

public class IntHashTable {
    Node[] hashTable;
    
    int size, numFullEntries, numCollisions, numRehashes;

    public IntHashTable(int size) {
        hashTable = new Node[size];
        this.size = size;
    }

    public void rehash() {
        Node[] temp = hashTable;
        size *= 2;
        hashTable = new Node[size];

        for (int i = 0; i < temp.length; i++) {
            Node t = temp[i];
            insert(t.k, t.v);
            numFullEntries--;
        }
    }

    public int getHash (int k) {
        return k % size;
    }

    public void insert(int k, int v) {
        Node newNode = new Node(k, v);

        if(numFullEntries >= size) {
            rehash();
            numRehashes++;
        }

        /* old
        if(hashTable[getHash(k)] == null) {
            hashTable[getHash(k)] = newNode;
            numFullEntries++;
        } else {
            System.out.println("Collision");
            numCollisions++;
        }
            */

        int i = 0;
        while(hashTable[(getHash(k) + i) % size] != null) {
            i++;
            numCollisions++;
        }
        hashTable[(getHash(k) + i) % size] = newNode;
        numFullEntries++;
    }

    public void delete(int k) {
        if(hashTable[getHash(k)] == null) {
            return;
        } else if(hashTable[getHash(k)].k == k) {
            hashTable[getHash(k)] = null;
            numFullEntries--;
        } else {
            System.out.println("Key not found!");
        }
    }

    public void print() {
        for (int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] == null) {
                System.out.println("Key:Value -> null");
            } else {
                System.out.println("Key:Value -> " + hashTable[i].k + ":" + hashTable[i].v);
            }
        }
    }
}