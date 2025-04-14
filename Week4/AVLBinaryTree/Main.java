public class Main {
    public static void main(String[] args) {
        IntAVL tree = new IntAVL();
        // tree.insert(1);
        // tree.insert(3);
        // tree.insert(2);
        // tree.printTree();
        // // System.out.println(tree.search(3));
        // // System.out.println(tree.search(2));

        // // tree.print();

        // System.out.println("Tree height: " + tree.getHeight());
        // System.out.println("The Tree has a balance factor of: " + tree.BalanceFactor());

        
        // tree.insert(10);
        // tree.printTree();
        // tree.insert(12);
        // tree.printTree();
        // tree.insert(15);
        // tree.printTree();
        // tree.insert(17);
        // tree.printTree();
        
        // System.out.println("Tree height: " + tree.getHeight());
        // System.out.println("The Tree has a balance factor of: " + tree.BalanceFactor());

        
        tree.insert(18);
        tree.insert(10);
        tree.insert(12);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(11);
        tree.insert(22);
        tree.insert(20);
        tree.insert(21);
        tree.insert(19);
        tree.insert(26);
        tree.insert(23);
        tree.insert(29);

        tree.printTree();

        tree.delete(12);
        tree.printTree();
    }
}
