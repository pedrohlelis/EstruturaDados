public class Node<T> {
    public Node<T> next;
    public T data;
    public Node<T> previous;

    public Node(T value){
        this.data = value;
    }
}
