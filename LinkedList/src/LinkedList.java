public class LinkedList {
    private Node top;
    private Node base;
    private int size;

    public LinkedList(){

    }

    public <T> void add(T value){
        Node node = new Node(value);
        if(size > 0){
            top.next = node;
            node.previous = top;
            size++;
            top = node;
        }
        top = node;
        base = node;
    }

    private Node getNode(int pos) throws Exception {
        if(pos > this.size && pos > -1){
            if(pos <= size/2){
                Node node = base;
                for(int i = 0; i<pos; i++){
                    node = node.next;
                }
                return node;
            }
            else {
                Node node = top;
                for(int i = this.size -1; i > pos ; i--){
                    node = node.previous;
                }
                return node;
            }
        }
        throw new Exception();
    }

}
