package array.sorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 14/10/19.
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */
public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int size = Integer.parseInt(br.readLine());
            String []strArray = br.readLine().split(" ");
            int [] array = new int[size];
            for(int i=0; i<size;i++){
                array[i] = Integer.parseInt(strArray[i]);
            }
            int target = Integer.parseInt(br.readLine());
            int positions [] = getFirstAndLastElementInSortedArray(array, target);
            for(int pos: positions){
                System.out.print(pos +" ");
            }
        }
    }

    private static int [] getFirstAndLastElementInSortedArray(int [] array, int target){
        int firstPosition = getFirstPosition(array, 0, array.length -1, target);
        int lastPosition = getLastPosition(array, 0, array.length -1, target);
        return new int[]{firstPosition, lastPosition};
    }

    private static int getFirstPosition(int []array, int start, int end, int target){
        if(start <= end){
            int mid = start + (end - start) / 2;
            if( array[mid] == target  && ( mid == 0 || array[mid -1] < target))
                return mid;
            if(target > array[mid]){
                return getFirstPosition(array, mid + 1, end, target);
            }else{
                return getFirstPosition(array, start, mid -1, target);
            }
        }
        return -1;
    }

    private static int getLastPosition(int [] array, int start, int end, int target){
        if(start <= end){
            int mid = start + (end - start) / 2;
            if(array[mid] == target && (mid == array.length -1 || array[mid] < array[mid + 1]))
                return mid;
            if(array[mid] > target)
                return getLastPosition(array, start, mid -1, target);
            else
                return getLastPosition(array, mid +1 , end, target);
        }
        return -1;
    }
}
/**
 *
 * Input:
 10
 6
 5 7 7 8 8 10
 8
 * Output: 3, 4,
 * */