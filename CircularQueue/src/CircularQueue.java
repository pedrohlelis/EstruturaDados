public class CircularQueue<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size){
        this.data = (T[]) new Object[size];
    }

    public void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        top = move(top);
        data[top] = element;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T removedElement = data[base];
        data[base] = null;
        base = move(base);
        return removedElement;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        top = -1;
        base = 0;
        data = (T[]) new Object[data.length];
    }

    private int move(int position){
        return (position + 1) % data.length;
    }

    public boolean isFull(){
        return move(top) == base && data[move(top)] != null;
    }

    public boolean isEmpty(){
        return this.top == -1 || this.data[base] == null ? true : false;
    }

    public void printQueue() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}