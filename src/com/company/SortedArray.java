package com.company;

import java.util.Arrays;

/**
 * Сортированный статический массив (по возрастанию).
 *
 * Любая операция должна гарантировать, что массив, по ее окончании, отстортирован
 */

public class SortedArray extends StaticArray {

    public SortedArray(int[] array) {
        super(array);
        if (!isAscSorted()) {
            super.sort();
        }
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value, 0, array.length) != -1;
    }

    @Override
    public int set(int index, int value) {
        if(index>array.length-1 || index<0){
            return -1;
        }
        array[index] = value;
        sort();
        return 0;
    }

    @Override
    public int indexOf(int value) {
        return binarySearch(value, 0, array.length - 1);
    }

    @Override
    public int lastIndexOf(int value) {
        int i = binarySearch(value, 0, array.length - 1);
        int idx = i;
        if(i==-1){
            return -1;
        }
        while((array[i]==value)&&(i<array.length)){
            idx = i;
            i++;
        }
        return idx;
    }

    @Override
    public void sort() {
        return;
    }

    @Override
    public void sort(ArraySort sort) {
        return;
    }

    private int binarySearch(int value, int left, int right) {
        int middle = left+(right-left)/2 ,idx = -1;
        if(value==array[middle])
        {
            return middle;
        }
        if(value<array[middle] && left<middle){
            idx = binarySearch(value, left, middle);
        }
        else if(value>array[middle] && middle<right){
            idx = binarySearch(value, middle, right);
        }
        return idx;
    }

    public SortedArray merge(SortedArray other) {
        // TODO: произвести слияние двух сортированных массивов
        int[] new_array = new int[array.length+other.size()];
        System.arraycopy(this.array, 0, new_array, 0, array.length);
        System.arraycopy(other.array, 0, new_array, array.length, other.size());
        SortedArray new_arr = new SortedArray(new_array);
        return new_arr;
    }

    public SortedArray mergeAll(SortedArray... others) {
        int total_size = array.length;
        for(SortedArray current : others){
            total_size+= current.size();
        }
        int[] new_array = new int[total_size];
        System.arraycopy(this.array, 0, new_array, 0, array.length);
        int cur_size = array.length;
        for(SortedArray current : others){
            System.arraycopy(current.array, 0, new_array, cur_size, current.size());
            cur_size+=current.size();
        }
        SortedArray new_arr = new SortedArray(new_array);
        return new_arr;
    }
}
