import HashTable.Node;

public class IntAVL {
    Node root;

    public IntAVL(){
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

        int balance = getBalanceFactor(cRoot);
        if (balance > 1){
            if(n < cRoot.left.value){
                System.out.println("Tree is left imbalanced");
                return RotateRight(cRoot);
            }
            else if (n > cRoot.left.value){
                System.out.println("Tree is left-right imbalanced");
                return RotateLeftRight(cRoot);
            }
        }
        else if (balance < -1){
            if(n < cRoot.right.value){
                System.out.println("Tree is right-left imbalanced");
                return RotateRightLeft(cRoot);
            }
            else if (n > cRoot.right.value){
                System.out.println("Tree is right imbalanced");
                return RotateLeft(cRoot);
            }
        }

        return cRoot;
    }

    public void delete(int n) {
        root = deleteFromSubtree(n, root);
    }

    private Node deleteFromSubtree(int n, Node cRoot) {
        if (cRoot == null) return null;

        if (n < cRoot.value) {
            cRoot.left = deleteFromSubtree(n, cRoot.left);
        } else if (n > cRoot.value) {
            cRoot.right = deleteFromSubtree(n, cRoot.right);
        } else {
            if (cRoot.left == null) return cRoot.right;
            else if (cRoot.right == null) return cRoot.left;
            else {
                Node minNode = findMin(cRoot.right);
                cRoot.value = minNode.value;
                cRoot.right = deleteFromSubtree(minNode.value, cRoot.right);
            }
        }

        int balance = getBalanceFactor(cRoot);
        if (balance > 1) {
            if (getBalanceFactor(cRoot.left) >= 0) {
                return RotateRight(cRoot);
            } else {
                return RotateLeftRight(cRoot);
            }
        } else if (balance < -1) {
            if (getBalanceFactor(cRoot.right) <= 0) {
                return RotateLeft(cRoot);
            } else {
                return RotateRightLeft(cRoot);
            }
        }

        return cRoot;
    }

    private Node findMin(Node cRoot) {
        while (cRoot.left != null) {
            cRoot = cRoot.left;
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

    public int getHeight() {
        return getHeightOfSubtree(root);
    }

    private int getHeightOfSubtree(Node cRoot) {
        if (cRoot == null) return 0;
        return 1 + Math.max(getHeightOfSubtree(cRoot.left), getHeightOfSubtree(cRoot.right));

        // int leftHeight = getHeightOfSubtree(cRoot.left);
        // int rightHeight = getHeightOfSubtree(cRoot.right);

        // if (leftHeight > rightHeight) {
        //     return leftHeight + 1;
        // } else {
        //     return rightHeight + 1;
        // }
    }

    public int BalanceFactor() {
        return getBalanceFactor(root);
    }

    private int getBalanceFactor(Node cRoot) {
        if (cRoot == null) return 0;
        return getHeightOfSubtree(cRoot.left) - getHeightOfSubtree(cRoot.right);
    }

    private Node RotateLeft(Node parent) {
        Node child = parent.right;
        parent.right = child.left;
        child.left = parent;
        return child;   
    }

    private Node RotateRight(Node parent) {
        Node child = parent.left;
        parent.left = child.right;
        child.right = parent;
        return child;
    }

    private Node RotateLeftRight(Node parent) {
        parent.left = RotateLeft(parent.left);
        return RotateRight(parent);
    }

    private Node RotateRightLeft(Node parent) {
        parent.right = RotateRight(parent.right);
        return RotateLeft(parent);
    }   
}
