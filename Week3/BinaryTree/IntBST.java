public class IntBST {
    Node root;

    public IntBST(){
        root = null;
    }

    public void insert(int key){
        root = insertIntoSubtree(key, root);
    }

    private Node insertIntoSubtree(int n, Node cRoot){
        if(cRoot == null){
            return new Node(n);
        } else if (n < cRoot.value){
            cRoot.left = insertIntoSubtree(n, cRoot.left);
        } else if ( n > cRoot.value){
            cRoot.right = insertIntoSubtree(n, cRoot.right);
        }
        return cRoot;
    }

    public boolean search(int n) {
        return searchSubtree(n, root);
    }

    public boolean searchSubtree(int n, Node cRoot){
        if(cRoot == null) return false;
        else if(cRoot.value == n) return true;
        else if(n < cRoot.value) return searchSubtree(n, cRoot.left);
        else if(n > cRoot.value) return searchSubtree(n, cRoot.right);
        return false;
    }

    public void printTree() {
        System.out.println("Tree: ");
        BSTPrinter.printNode(root);
    }

    public void print() {
        printR(root);
    }

    private void printR(Node cRoot) {
        if(cRoot == null) return;

        printR(cRoot.left);
        System.out.print(cRoot.value);
        if(cRoot.left == null) {
            System.out.print("| null");
        } else {
            System.out.print("| " + cRoot.left.value);
        }
        if(cRoot.right == null) {
            System.out.println(" null");
        } else {
            System.out.println(" " + cRoot.right.value);
        }
        System.out.println();
        printR(cRoot.right);
        
    }
}
