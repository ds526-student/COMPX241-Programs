public class Main
{
    public static void main(String[] args)
    {
        IntQueue queue = new IntQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}