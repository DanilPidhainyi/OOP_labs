package lab7;

import lab6.FromSocket;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class MySet implements Set<FromSocket> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    // перегрузка
    MySet() {
    }

    MySet(FromSocket fromSocket) {
        add(fromSocket);
    }

    MySet(Collection<FromSocket> collection) {
        addAll(collection);
    }

    public void show() {
        MyIterator iter = new MyIterator();
        FromSocket item = iter.next();
        while (item != null) {
            System.out.println(item.name);
            item = iter.next();
        }
    }
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        Node checkItem = first;
        while (checkItem != null) {
            if (checkItem.getFromSocket() == obj) {
                return true;
            }
            checkItem = checkItem.getNext();
        }
        return false;
    }

    @Override
    public Iterator<FromSocket> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<FromSocket> {
        protected Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public FromSocket next() {
            if (!hasNext()) {
                return null;
            }
            FromSocket fromSocket = currentNode.getFromSocket();
            currentNode = currentNode.getNext();
            return fromSocket;
        }
    }

    @Override
    public Object[] toArray() {
        FromSocket[] arr = new FromSocket[size];
        MyIterator iterFromSocket = new MyIterator();
        for (int i = 0; i < size; i++) {
            arr[i] = iterFromSocket.next();
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(FromSocket fromSocket) {
        if (contains(fromSocket)) {
            return false;
        }
        Node node = new Node(fromSocket, null, last);
        if (first == null) {
            first = node;
        } else {
            last.setNext(node);
        }
        last = node;
        size++;
        return true;
    }

    private void removeNode(Node node) {
        if (size == 1) {
            first = null;
        }
        if (node.getPrevious() != null) {
            node.getPrevious().setNext(node.getNext());
        }
        if (node.getNext() != null) {
            node.getNext().setPrevious(node.getPrevious());
        }
        size--;
    }

    @Override
    public boolean remove(Object obj) {
        Node checkItem = first;
        while (checkItem != null) {
            if (checkItem.getFromSocket() == obj) {
                removeNode(checkItem);
                return true;
            }
            checkItem = checkItem.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean checkItem = true;
        for (Object item : collection) {
            checkItem &= contains(item);
        }
        return checkItem;
    }

    @Override
    public boolean addAll(Collection<? extends FromSocket> collection) {
        boolean checkAdd = false;
        for (FromSocket item : collection) {
            checkAdd |= add(item);
        }
        return checkAdd;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean checkRetain = false;
        Node verifiableItem = first;
        while (verifiableItem != null) {
            if (collection.contains(verifiableItem.getFromSocket())) {
                removeNode(verifiableItem);
                checkRetain = true;
            }
            verifiableItem = verifiableItem.getNext();
        }
        return checkRetain;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean checkRemove = false;
        for (Object item : collection) {
            checkRemove |= remove(item);
        }
        return checkRemove;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
}
