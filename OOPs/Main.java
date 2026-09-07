package OOPs;

import DP.dpOnSubsequences.partitionEqualSumSuset;

//SWAP GAME
public class Main {

    public static class Person {// classs
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[ " + age + " ] Syas Hi!");
        }

        // in java constructor will be by default if you forget to make
        Person() {
            // without parameter-> Default
        }

        Person(int age, String name) {// paraneterized construvtor
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String args[]) {
        Person p1 = new Person();// Person -> class , p1 -> object
        p1.age = 20;
        p1.name = "Vikrant Yadav";

        Person p3 = new Person(20, "Aadi");// paraneterized construvtor used
        p3.saysHi();

        Person p2 = new Person();// Person -> class , p1 -> object
        p2.age = 18;
        p2.name = "Rahul Yadav";

        p1.saysHi();
        p2.saysHi();

        swap1(p1, p2);// It wont get swapped -> because only references are gettin swapped and they
                      // are dead after the function is finished -> still p1 and p2 are not swapped

        p1.saysHi();
        p2.saysHi();

        p1.saysHi();
        p2.saysHi();

        swap2(p1, p2);// will be swappped now ->

        p1.saysHi();
        p2.saysHi();
    }

    public static void swap1(Person p1, Person p2) {
        Person t = p1;
        p1 = p2;
        p2 = t;
    }

    public static void swap2(Person p1, Person p2) {
        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;

        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;
    }
}
