package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return Collections.emptyList();
    }

    /*
        Time Complexity O(log N + k)
        Space Complexity O(1)
     */
    public List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(k);

        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int index = lo + (hi - lo) / 2;

            if (arr[index] == x) {
                lo = index;
                break;
            }

            if (arr[index] > x) {
                hi = index;
            } else {
                lo = index + 1;
            }
        }

        int left = lo - 1, right = lo;

        for (; k > 0; k--) {
            if (left >= 0 && (right >= arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))) {
                result.add(0, arr[left--]);
            } else {
                result.add(arr[right++]);
            }
        }

        return result;
    }


    /*
        Not Mine
        Time Complexity O(log (N - k) + k)
        Space Complexity O(1)
     */
    public List<Integer> findClosestElementsBinarySearchV2(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;

        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Create output in correct format
        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
