package com.company.superme198.Sorting;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int[] arr, int left, int right){
        if (left >= right) return;
        int pivot = arr[left];
        int i = left, j = right;
        while (i <= j){
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i<=j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        quickSort(arr, left, i -1);
        quickSort(arr, i, right);
    }

    static int[] quickSort1(int[] a, int l, int r) {

        if (l >= r) {
            return a;
        }

        int x = a[l];
        int i = l;
        int j = r;

        while (i <= j) {
            while (a[i] < x) {
                i++;
            }
            while (a[j] > x) {
                j--;
            }
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }

        quickSort1(a, l,  i-1 );
        quickSort1(a,i , r);

        return a;
    }
    public static void main(String...args){
        int[] arr = new int[]{85, 24, 63, 45, 17, 31, 96, 50};
        quickSort1(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
