package com.algorithms;

public class MergeSort {
    private int[] numbers;
    private int[] array;
    private int num;

    public void sort(int[] values) {
            this.numbers = values;
            num = values.length;
            this.array = new int[num];
            mergesort(0, num - 1);
    }

    private void mergesort(int low, int high){
    	// check if low is smaller then high, if not then the array is sorted
    	if (low < high){
    		// Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
            }
    	}

    private void merge(int low, int middle, int high) {
    	// Copy both parts into the helper array
    	for (int i = low; i <= high; i++){
    		array[i] = numbers[i];
    		}

            int i = low;
            int j = middle + 1;
            int k = low;
            // Copy the smallest values from either the left or 
            // the right side back to the original array
            while (i <= middle && j <= high) {
                    if (array[i] <= array[j]) {
                            numbers[k] = array[i];
                            i++;
                    } else {
                            numbers[k] = array[j];
                            j++;
                    }
                    k++;
                 }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
                    numbers[k] = array[i];
                    k++;
                    i++;
            }
        }
    }
