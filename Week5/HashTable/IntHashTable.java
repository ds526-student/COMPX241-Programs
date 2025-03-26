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

        for(int i = 0; i < temp.length; i++) {
            Node t = temp[i];
            insert(t.k, t.v);
            numFullEntries--;
        }
    }

    public int getHash (int k) {
        return k % size;
    }

    public void insert(int k, int v) {
        int index = getHash(k);
        hashTable[index] = new Node(k, v);

        if (numFullEntries >= size) {
            System.out.println("Rehashing required, current size: " + size);
            rehash();
            numRehashes++;
        }

        // if (hashTable[index] == null) {
        //     hashTable[index] = new Node(k, v);
        //     numFullEntries++;
        // } else {
        //     System.out.println("Collision detected at index " + index + " for key " + k);
        //     numCollisions++;
        // }

        int i = 0;
        while(hashTable[(index + i) % size] != null) {
            i++;

        }

        hashTable[(index + i) % size] = new Node(k, v);
        numFullEntries++;
    }

    public void delete(int k) {
        int index = getHash(k);
        if (hashTable[index] != null && hashTable[index].k == k) {
            hashTable[index] = null;
            numFullEntries--;
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