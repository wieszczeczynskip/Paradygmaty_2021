public class main {
    public static void main(String[] args) throws EmptyException, FullException {
        Cykliczna<Integer> cq = new Cykliczna<>(3);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        System.out.println(cq.first());
        System.out.println(cq.isFull());
        cq.dequeue();
        cq.enqueue(4);
        System.out.println(cq.isFull());
        System.out.println(cq.first());
        cq.dequeue();
        System.out.println(cq.first());
        cq.dequeue();
        System.out.println(cq.first());
        cq.dequeue();
        System.out.println(cq.isEmpty());

    }
}
