import java.util.ArrayList;

public class Cykliczna<E> implements MyQueue<E>{

    private ArrayList<E> queue;
    private int f;
    private int r;
    private int maxSize;

    public Cykliczna(int maxSize) {
        queue = new ArrayList<E>(maxSize + 1);
        for (int i = 0; i < maxSize + 1; i++) {
            queue.add(null);
        }
        r = 0;
        f = 0;
        this.maxSize = maxSize + 1;
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull()) {
            throw new FullException("Cykliczna: enqueue");
        }
        else {
            queue.set(r, x);
            r = (r + 1) % maxSize;
        }
    }

    @Override
    public void dequeue() {
        if (!isEmpty()) {
            f = (f + 1) % maxSize;
        }
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Cykliczna: first");
        }
        return queue.get(f);
    }

    @Override
    public boolean isEmpty() {
        return r == f;
    }

    @Override
    public boolean isFull() {
        return (r + 1) % maxSize == f;
    }
}
