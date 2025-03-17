public class Main {
    public static void main(String[] args) {
        IntBST tree = new IntBST();
        tree.insert(50);
        tree.insert(69);
        tree.insert(420);
        tree.insert(35);
        tree.printTree();
        System.out.println(tree.search(69));
        System.out.println(tree.search(40));

        tree.print();
    }
}
