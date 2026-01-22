public class DoublyLinkedList<E>  implements List{
    Node head;
    Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.setNextNode(newNode);
        newNode.setPrevNode(tail);
        tail = newNode;
        size++;
    }


    public void addAtHead(Object data) {
        Node newNode = new Node(data);
        Node current = head;
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        current.setPrevNode(newNode);
        newNode.setNextNode(current);
        newNode.setPrevNode(null);
        head = newNode;
        size++;
    }


    @Override
    public void add(int i, Object element) throws IndexOutOfBoundsException {

        if(i > size ){
            System.out.println("Invalid postion");
            return;
        }

        if( i == 0){
            addAtHead(element);
            return;
        }

        if(i== size){
            add(element);
            return;
        }

        Node newNode = new Node(element);
        Node current = head;
        for (int j = 0; j < i-1; j++) {
            current = current.next;
        }


        newNode.setNextNode(current.next);
        newNode.setPrevNode(current);

        current.next.setPrevNode(newNode);
        current.setNextNode(newNode);
        size++;

    }

    @Override
    public void remove() {

    }

    @Override
    public Node remove(int i) throws IndexOutOfBoundsException {
        Node current = head;
        if(i > size ){
            System.out.println("Invalid postion");
            return null;
        }

        if (i==size-1){
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            } else {
                tail = null;
            }
            size--;
            return null;
        }

        if(i == 0){
            head = head.next;
            if (tail != null) {
                head.previous = null;
            } else {
                tail = null;
            }
            size--;
            return null;
        }

        for (int j = 0; j < i ; j++) {
            current = current.next;
        }

        if (current.previous != null) {
            current.previous.next = current.next;
        }


        if (current.next != null) {
            current.next.previous = current.previous;
        } else {

            tail = current.previous;
        }
        size--;
        return null;
    }

    @Override
    public Node get(int i) throws IndexOutOfBoundsException {
        Node current = head;
        for (int j = 0; j < i ; j++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void set(int i, Object element) throws IndexOutOfBoundsException {
        Node current = head;
        if(i > size ){
            System.out.println("Invalid postion");
            return;
        }

        if( i == 0){
            current = head;
            current.value = element;
            return;
        }

        if(i == size-1){
            current = tail;
            current.value = element;
            return;
        }


        for (int j = 0; j < i ; j++) {
            current = current.next;

        }
        current.value = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return false;
        } else {
            return true;
        }

    }

    @Override
    public String toString(){
        String say = "";
        Node current = head;
        while (current != null) {
            say += current.value + ", ";
            current = current.next;
        }
        if(size == 0){
            say = null;
        }

        return say;
    }
}
