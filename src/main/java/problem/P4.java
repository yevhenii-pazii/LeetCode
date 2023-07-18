package problem;

public class P4 {

    /*
        The assumption was that one array is strictly in the middle of another
         case like [1,3] [2,4] is not supported.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var totalLength = nums1.length + nums2.length;
        int num2Start, num2End; // inclusive, exclusive

        if (nums1.length == 0 || nums2.length == 0 || nums1[nums1.length - 1] <= nums2[0]) {
            num2Start = nums1.length;
            num2End = num2Start + nums2.length;
        } else if (nums2[nums2.length - 1] <= nums1[0]) {
            var temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            num2Start = nums1.length;
            num2End = num2Start + nums2.length;
        } else { //one array is in the middle of another
            if (nums1[0] > nums2[0] || nums2[nums2.length - 1] > nums1[nums1.length - 1]) {
                var temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            int lo = 0, hi = nums1.length - 1;
            while (lo < hi) {
                var index = lo + (hi - lo) / 2;

                if (nums2[0] < nums1[index]) {
                    hi = index;
                } else {
                    lo = index + 1;
                }
            }
            num2Start = lo;
            num2End = num2Start + nums2.length;
        }

        var middle = totalLength / 2;
        return (totalLength & 1) == 1 ?
                get(nums1, nums2, num2Start, num2End, middle) :
                (get(nums1, nums2, num2Start, num2End, middle)
                        + get(nums1, nums2, num2Start, num2End, middle - 1)) / 2.0;
    }

    private int get(int[] nums1, int[] nums2, int start, int end, int index) {
        if (index < start) {
            return nums1[index];
        } else if (index < end) {
            return nums2[index - start];
        } else {
            return nums1[index - end + start];
        }
    }
}
