public class P26 {
    public int removeDuplicates(int[] nums) {
        var removed = 0;
        var i = 1;
        while (i + removed < nums.length) {
            if (nums[i - 1] == nums[i]) {
                for (var j = i + 1; j + removed < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                removed++;
            } else {
                i++;
            }
        }

        return nums.length - removed;
    }


/* better from discussion
    public int removeDuplicates(int[] nums) {
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

*/
}