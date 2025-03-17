public class Main {
    public static void main(String[] args) {
        System.out.println("Linked Lists!");

        IntLinkedList list = new IntLinkedList();

        System.out.println("Empty lists");
        list.print();
        System.out.println("Is Empty " + list.isEmpty());
        System.out.println("Has 20  " + list.hasElement(20));
        System.out.println("Length " + list.length());

        System.out.println("Adding items to the list.....");

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.print();
        System.out.println("Is Empty " + list.isEmpty());
        System.out.println("Has 20  " + list.hasElement(20));
        System.out.println("Length " + list.length());

        list.remove(30);
        list.print();

        list.removeAt(2);
        list.print();

        list.insert(15, 1);
        list.print();
    }

}