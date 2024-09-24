import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class Queue<T> {
	private DoublyLinkedList<T> queue;
	
	public Queue() {
        queue = new DoublyLinkedList<>();
    }

    // Add an element to the queue
    public void enqueue(T value) {
    	if(value == null) {
    		return;
    	}
        queue.add(value);
    }

    // Remove an element from the queue
    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return queue.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.size() == 0;
    }
    
    public void printQueue() {
    	queue.printList();
    }
}
