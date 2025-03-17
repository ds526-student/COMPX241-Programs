public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        System.out.println("Empty List:");
        System.out.println("Add items to list......");

        list.add("Hello");
        list.add("World");
        list.add("!");

        list.print();

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        
        list2.add(1);
        list2.add(2);
        list2.add(3);

        list2.print();
    }
}
