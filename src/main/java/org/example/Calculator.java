package org.example;


public class Calculator {
    
    public static int LinealSearch(String[] listNumbers, String toFindn){ 
        int position = -1;
        for  (int i=0 ;i < listNumbers.length; i++){
            if (toFindn.equals(listNumbers[i])) {
                position = i;
                break;
            }
        }
        return position;
    }

    public static int BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }
        return -1;
    }
}
