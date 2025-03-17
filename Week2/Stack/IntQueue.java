public class IntQueue {
    int[] queue;
    
    int start;
    int end;
    int size;

    public IntQueue(int size) {
        queue = new int[size];
        start = 0;
        end = 0;
        this.size = size;
    }

    public void print(){
        // int i = head;
        for ( int i = start; i < end; i++){
            System.out.println(queue[i % size] + "->");
        }

        System.out.println();
    }

    public void enqueue(int n){
        if(start + size != end){
            queue[end % size] = n;
            end++;
        }
    }

    public int dequeue(){
        if(start <= end){
            int returnValue = queue[start % size];
            start++;
            return returnValue;
        }
        return 0;
    }
}
