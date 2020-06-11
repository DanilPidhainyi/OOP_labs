package lab7;

import lab6.FromSocket;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // перший конструктор
        MySet newSet0 = new MySet();
        // другий
        MySet newSet1 = new MySet(new FromSocket("Холодильник", 5, 100, true));
        // третій
        HashSet<FromSocket> hashSet = new HashSet<>();
        FromSocket phone = new FromSocket("Телефон", 50, 10, true);
        FromSocket refrigerator = new FromSocket("Холодильник", 5, 100, true);
        hashSet.add(refrigerator);
        hashSet.add(phone);
        MySet newSet2 = new MySet(hashSet);

        // методи
        System.out.println("Початковий: ");
        newSet2.show();
        HashSet<FromSocket> setTest = new HashSet<>();
        setTest.add(phone);
        setTest.add(new FromSocket("", 5, 20, false));
        newSet2.removeAll(setTest);
        System.out.println("Після видалення: ");
        newSet2.show();
        System.out.println("Зробимо retainAll");
        newSet2.retainAll(hashSet);
        newSet2.show();
        System.out.println("Зробимо removeAll");
        HashSet<FromSocket> refSet = new HashSet<>();
        refSet.add(refrigerator);
        //newSet2.removeAll(refSet);
        newSet2.remove(refrigerator);
        newSet2.show();
        newSet2.toArray();

    }
}
