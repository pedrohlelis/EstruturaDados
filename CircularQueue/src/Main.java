public class Main {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Added 1, 2 and 3 to Queue");
        queue.printQueue();


        System.out.println("remove method called:");
        System.out.println(queue.remove());
        queue.printQueue();

        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println("Added 4, 5 and 6 to queue");
        queue.printQueue();

        queue.clear();
        System.out.println("Cleared Queue:");
        queue.printQueue();
    }
}