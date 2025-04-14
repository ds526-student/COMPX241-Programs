import HashTable.Node;

public class IntLinkedList {

    Node head;

    public IntLinkedList() {
        head = null;
    }

    /**
     * Prints the values in the linked list to the console
     */
    // public void print() {
    //     Node curr = head;
    //     while (curr != null) {
    //         System.out.print(curr.value + " -> ");
    //         curr = curr.next;
    //     }
    //     System.out.println();
    // }

    /**
     * Adds a new value to the head of the linked list
     * @param n
     */
    public void add(int n){
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
    }

    public boolean hasElement(int n) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == n) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int length() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void remove(int n) {
        if (head == null) {
            return;
        }
        if (head.value == n) {
            head = head.next;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.value == n) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public void removeAt(int n){
        if (head == null) {
            return;
        }
        if (n == 0) {
            head = head.next;
            return;
        }
        Node curr = head;
        for (int i = 0; i < n - 1; i++) {
            if (curr.next == null) {
                return;
            }
            curr = curr.next;
        }
        if (curr.next == null) {
            return;
        }
        curr.next = curr.next.next;
    }

    // public void insert(int n, int i){
    //     Node newNode = new Node(n);
    //     if (i == 0) {
    //         newNode.next = head;
    //         head = newNode;
    //         return;
    //     }
    //     Node curr = head;
    //     for (int j = 0; j < i - 1; j++) {
    //         if (curr.next == null) {
    //             return;
    //         }
    //         curr = curr.next;
    //     }
    //     newNode.next = curr.next;
    //     curr.next = newNode;

    // }

    // Write a public method insert(x) that creates a new Node whose value has the same value as x and adds it to the start of the Queue.
    public void insert(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    // Write a public method print() that removes the head item from the Queue. 
    public void print() {
        Node temp = head;
        head = head.next;
        System.out.println("Removed: " + temp.value);
    }

    public void insertAt(int x, int i) {
        Node curr = head;
        Node newNode = new Node(x);
        for (int j = 0; j < i - 1; j++) {
            if (curr.next == null) {
                return;
            }
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }
    // Write a public method getLength(x) that returns the length of the Queue.
    public int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

}
