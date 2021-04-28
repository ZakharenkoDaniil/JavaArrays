package com.company;

public class App {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 8, 5, 6, 9, 8};
        var staticArray = new StaticArray(a);
        staticArray.sort();
        System.out.println(staticArray);

        var sortedArray = new SortedArray(a);
        System.out.println(sortedArray);
        System.out.println(sortedArray.lastIndexOf(8));

        var dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        System.out.println(dynamicArray);
    }
}
