package com.company;

/**
 * Динамический массив
 */
public class DynamicArray extends StaticArray implements Dynamic {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_FACTOR = 1.5f;

    /**
     * текущая длина массива
     */
    private int size;

    public DynamicArray() {
        super(new int[DEFAULT_CAPACITY]);
        size = 0;
    }

    public DynamicArray(int[] array) {
        super(array);
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        if(size==array.length){
            int[] new_array = new int[(int)(array.length*GROW_FACTOR)];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(int index, int value) {
        if(index>size+1){
            return;
        }
        if(size==array.length){
            int[] new_array = new int[(int)(array.length*GROW_FACTOR)];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
        }
        array[size] = value;
        for(int i = size-2;i>=index;i--)
        {
            int tmp = array[i];
            array[i] = array[i+1];
            array[i+1] = tmp;
        }
    }

    @Override
    public void addAll(Array array) {
        int new_size = this.array.length;
        while(size + array.size()>new_size){
            new_size = (int)(new_size*GROW_FACTOR);
        }
        if(new_size!=this.array.length){
            int[] new_array = new int[new_size];
            this.array = new_array;
        }
        int j = size;
        for(int i = 0;i<array.size();i++, j++){
            this.array[j] = array.get(i);
        }
        size+= array.size();
    }

    @Override
    public boolean remove(int value) {
        int rem_idx = -1;
        for(int i = 0; i<size; i++){
            if(array[i]==value){
                rem_idx = i;
            }
        }
        if(rem_idx!=-1){
            for(int i = rem_idx;i<size-1;i++){
                int tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(int[] values) {
        boolean rem_flag = false;
        for(int i = 0;i< values.length;i++){
            boolean flag = true;
            while(flag){
                flag = remove(values[i]);
                if(flag){
                    rem_flag = true;
                }
            }
        }
        return rem_flag;
    }

    @Override
    public int removeOf(int index) {
        if(index>=size || index < 0){
            return -1;
        }
        for(int i = index;i<size-1;i++){
            int tmp = array[i];
            array[i] = array[i+1];
            array[i+1] = tmp;
        }
        return 0;
    }
}
