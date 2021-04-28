package com.company;

import java.util.Arrays;

/**
 * Обертка над статическим массивом
 */
public class StaticArray implements Array {

    protected int[] array;

    public StaticArray(int[] a) {
        this.array = new int[a.length];
        System.arraycopy(a, 0, this.array, 0, a.length);
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean contains(int value) {
        for(int i = 0;i< array.length;i++) {
            if(array[i]==value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int set(int index, int value) {
        if(index>array.length-1 || index<0){
            return -1;
        }
        int tmp = array[index];
        array[index] = value;
        return tmp;
    }

    @Override
    public int indexOf(int value) {
        for(int i = 0;i< array.length;i++) {
            if(array[i]==value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for(int i = array.length-1;i>=0;i--) {
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void reverse() {
        for(int i = 0; i<=array.length;i++){
            int tmp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = tmp;
        }
    }

    @Override
    public Array subArray(int fromIndex, int toIndex) {
        int[] new_array = new int[toIndex-fromIndex];
        int j = 0;
        for(int i = fromIndex;i<toIndex;i++, j++) {
            new_array[j] = array[i];
        }
        StaticArray res = new StaticArray(new_array);
        return res;
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    @Override
    public void sort(ArraySort sort) {
        switch (sort) {
            case BUBBLE:
                bubbleSort();
                break;
            case INSERTION:
                insertionSort();
                break;
            case SELECTION:
                selectionSort();
                break;
            case MERGE:
                mergeSort();
                break;
            case QUICK:
                quickSort();
                break;
            default:
                sort();
                break;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private void bubbleSort() {
        boolean not_sorted = true;
        while(not_sorted){
            not_sorted = false;
            for(int i = 0;i<array.length-1;i++){
                if(array[i]>array[i+1]){
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    not_sorted = true;
                }
            }
        }
    }

    private void insertionSort() {
        for(int i = 1;i<array.length;i++){
            int j = i;
            while((array[j]<array[j-1])&&(j>0)){
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
                j--;
            }
        }
    }

    private void selectionSort() {
        for(int i = 0;i<array.length-1;i++){
            int idx_min = i;
            for(int j = i;j<array.length;j++){
                if(array[idx_min]>array[j]){
                    idx_min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[idx_min];
            array[idx_min] = tmp;
        }
    }

    private void mergeSort() {
        //TODO**: сортировка слиянием (по возрастанию)
    }

    private void quickSort() {
        //TODO**: быстрая сортировка (по возрастанию)
    }

    public boolean isAscSorted() {
        for(int i = 0;i< array.length-1;i++) {
           if(array[i]>array[i+1]){
               return false;
           }
        }
        return true;
    }
}
