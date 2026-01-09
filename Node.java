public class Node<E> {
    private E value;
    private E next;
    private E previous;


    public Node(E val) {
        value = val;
        next = null;
        previous = null;
    }

    public Node(E val, Node maybe) {
        if(maybe.toString().equals("Next")){
            next = val;
        } else if (maybe.toString().equals("Prev")) {
            previous = val;
        }
    }

    public E getValue() {
        return value;
    }


    public void setNextNode(E next) {
        this.next = next;
    }

    public void setPrevNode(E previous) {
        this.previous = previous;
    }

    public Node<E> getPrevNode(){
        return previous;
    }

    public Node<E> getNextNode(){
        return next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Node<E> obj) {
        return value.equals(obj);
    }
}