package algorithm.sort;

import java.util.Arrays;

/**
 * @author zuoshengli
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {1,4,6,7,5,4,3,2,4,5,13,45,32,10};
        int[] result = mergeSort(data, 0, data.length);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] data, int left, int right) {
        if (right - left <= 0) {
            return Arrays.copyOfRange(data, left, right+1);
        }
        int mid = left + ((right - left) >> 1);
        int[] leftArray = mergeSort(data, left, mid);
        int[] rightArray = mergeSort(data, mid+1, right);
        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int left = 0;
        int right = 0;
        int[] result = new int[leftArray.length+rightArray.length];
        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left] < rightArray[right]) {
                result[left+right] = leftArray[left];
                left++;
            } else {
                result[left+right] = rightArray[right];
                right++;
            }
        }
        while (left < leftArray.length) {
            result[left+right] = leftArray[left];
            left++;
        }

        while (right < rightArray.length) {
            result[left+right] = rightArray[right];
            right++;
        }
        return result;
    }
}
