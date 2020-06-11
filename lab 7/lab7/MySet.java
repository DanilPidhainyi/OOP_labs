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


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean findItem(Node checkItem, Object obj) {
        if (checkItem.getFromSocket() == obj) {
            return true;
        }
        if (checkItem.getNext() != null) {
            return findItem(checkItem.getNext(), obj);
        }
        return false;
    }

    @Override
    public boolean contains(Object obj) {
        return findItem(first, obj);
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

    @Override
    public boolean remove(Object obj) {
        Node checkItem = first;
        while (checkItem != null) {
            if (checkItem.getFromSocket() == obj) {
                checkItem.getPrevious().setNext(checkItem.getNext());
                size--;
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
        Node checkItem = first;
        while (checkItem != null) {
            if (collection.contains(checkItem.getFromSocket())) {
                checkItem.getPrevious().setNext(checkItem.getNext());
                size--;
                checkRetain = true;
            }
            checkItem = checkItem.getNext();
        }
        return checkRetain;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean checkRemove = false;
        for (Object item: collection) {
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
