package lab7;

import lab6.FromSocket;

public class Node {
    // дані
    private FromSocket fromSocket;
    private Node next;
    private Node previous;

    public Node(FromSocket fromSocket, Node next, Node previous) {
        this.fromSocket = fromSocket;
        this.next = next;
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public FromSocket getFromSocket() {
        return fromSocket;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }
}