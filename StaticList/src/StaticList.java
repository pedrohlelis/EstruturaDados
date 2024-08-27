

public class StaticList {
    public Node[] data;
    public int size;

    public StaticList(){
        ;
    }

    public void add(int data){
        Node node = new Node(data);
        Node top;
        Node base;
        if(this.size == 0){
            base = node;
            node.previous = null;
            node.next = null;
            this.size++;
        }
        top = node;
        if{
            node.previous = top;
        }
    }
}
