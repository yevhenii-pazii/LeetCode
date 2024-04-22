package problem.p0000_0099;

class P88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m >= 0 && n > 0) {
            if (m == 0 || nums2[n - 1] > nums1[m - 1]) {
                n--;
                nums1[m + n] = nums2[n];
            } else {
                m--;
                nums1[m + n] = nums1[m];
            }
        }
    }
}

/* the best one in discussions

public void merge(int[] A, int m, int[] B, int n) {
	for (int i = m+n-1, a = m-1, b = n-1; b>=0; i--) {
		if (a >= 0 && A[a] > B[b]) A[i] = A[a--];
		else A[i] = B[b--];
	}
}

*/