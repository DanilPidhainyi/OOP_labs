package lab7;

import lab6.FromSocket;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        MySet newSet0 = new MySet();
        MySet newSet1 = new MySet(new FromSocket("Холодильник", 5, 100, true));
        HashSet<FromSocket> hashSet = new HashSet<>();
        FromSocket phone = new FromSocket("Телефон", 50, 10, true);
        hashSet.add(new FromSocket("Холодильник", 5, 100, true));
        hashSet.add(phone);
        MySet newSet2 = new MySet(hashSet);
        newSet2.remove(phone);
    }
}

