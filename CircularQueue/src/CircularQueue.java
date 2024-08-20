public class CircularQueue<T> {
    private int top = 0;
    private int base = 0;
    private T[] data;

    public CircularQueue(int size){
        this.data = (T[]) new Object[size];
    }

    public void add(String value){
        top++;
        if(!isFull()){

        }
    }

    private int move(int position){
        return (position + 1) % data.length;
    }

    public boolean isFull(){
        return move(top) == base && data[move(top)] != null;
    }

    public boolean isEmpty(){
        return this.top == -1 || this.data[base] != null ? true : false;
    }
}
