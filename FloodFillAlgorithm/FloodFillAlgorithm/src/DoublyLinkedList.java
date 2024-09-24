
public class DoublyLinkedList<T> {
    private Node<T> top;  // Refere-se ao último nó (no topo)
    private Node<T> base; // Refere-se ao primeiro nó (na base)
    private int size;     // Tamanho da lista

    // Construtor da lista
    public DoublyLinkedList() {
        this.top = null;
        this.base = null;
        this.size = 0;
    }

    // Adiciona um novo valor ao final da lista
    public void add(T value) {
        Node<T> node = new Node<>(null, value, null);
        if (size > 0) {
            top.next = node;    // O novo nó é anexado ao próximo do nó top atual
            node.previous = top; // O nó anterior ao novo é o top atual
            top = node;          // Atualiza o top para o novo nó
        } else {
            // Se a lista estiver vazia, inicializa a base e o top
            top = node;
            base = node;
        }
        size++;
    }

    // Obter o valor de um nó em uma posição específica
    public T get(int pos) throws Exception {
	
        Node<T> node = getNode(pos);

        return node.data;
    }

    public void remove(int pos) throws Exception {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<T> nodeToRemove = getNode(pos);

        if (nodeToRemove.previous != null) {
            nodeToRemove.previous.next = nodeToRemove.next;
        } else {
            // Se for o primeiro nó
            base = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.previous = nodeToRemove.previous;
        } else {
            // Se for o último nó
            top = nodeToRemove.previous;
        }

        size--;
    }

    public T pop() throws Exception{
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop from an empty list.");
        }

        T data = base.data; // Get the data of the node to be removed
        remove(0); // Remove the first node
        return data; // Return the removed data
    }
    
    // Obter o tamanho da lista
    public int size() {
        return this.size;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Limpa a lista
    public void clear() {
        top = null;
        base = null;
        size = 0;
    }

    // Imprime a lista (do início ao fim)
    public void printList() {
        Node<T> current = base;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Função auxiliar: obter um nó por posição
    private Node<T> getNode(int pos) throws Exception {
        if (pos >= 0 && pos < this.size) {
            if (pos <= size / 2) {
                // Busca do início (base)
                Node<T> node = base;
                for (int i = 0; i < pos; i++) {
                    node = node.next;
                }
                return node;
            } else {
                // Busca do final (top)
                Node<T> node = top;
                for (int i = this.size - 1; i > pos; i--) {
                    node = node.previous;
                }
                return node;
            }
        }
        throw new Exception("Position out of bounds");
    }
}
