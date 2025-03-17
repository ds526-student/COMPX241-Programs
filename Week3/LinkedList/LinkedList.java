public class LinkedList<T> {
    Node head;

    public LinkedList(){
        head = null;
    }

    public void add(T n){
        Node newNode = new Node(n);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

class Node{
    int value;
    Node next;
    public Node(int n){
        value = n;
        next = null;
    }
}
}
