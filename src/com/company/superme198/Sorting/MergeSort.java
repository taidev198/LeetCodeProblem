package com.company.superme198.Sorting;

import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int[] arr, int left, int right){
        if ( right - left <=1)//if arr has one element. it have already sorted.
            return;//return;
        int mid = left+  ( - left + right) /2;
        mergeSort(arr, left, mid );
        mergeSort(arr, mid+1, right);
        merge(arr, left, right, mid);
    }

    static void merge(int[] arr,int left, int right, int mid){
        int size = right -left +1;
        int[] temp = new int[size];
        int i=0;
        int lower = left;
        int upper = mid;
        while ( lower < mid &&   upper < right ) {
            if (arr[lower] >arr[ upper])
                temp[i++] = arr[ upper++];
            else temp[i++] = arr[lower++];
        }
        while (lower < mid ) temp[i++] = arr[lower++];
        while (upper < right ) temp[i++] = arr[ upper++];
        for (int j = left; j < right; j++) {
            arr[j] = temp[j-left];
        }
    }

    public static void main(String...args){
        int[] arr = new int[]{85, 24, 63, 45, 17, 31, 96, 50};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
