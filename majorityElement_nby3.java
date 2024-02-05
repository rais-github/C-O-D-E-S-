import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] ele_cnt = new int[4];
        ele_cnt[0] = Integer.MIN_VALUE;
        ele_cnt[2] = Integer.MIN_VALUE;
        int size = nums.length;

        for (int i : nums) {
            if (ele_cnt[1] == 0 && ele_cnt[2] != i) {
                ele_cnt[1] = 1;
                ele_cnt[0] = i;
            } else if (ele_cnt[3] == 0 && ele_cnt[0] != i) {
                ele_cnt[3] = 1;
                ele_cnt[2] = i;
            } else if (i == ele_cnt[0]) {
                ele_cnt[1]++;
            } else if (i == ele_cnt[2]) {
                ele_cnt[3]++;
            } else {
                ele_cnt[1]--; ele_cnt[3]--;
            }
        }

        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == ele_cnt[0]) {
                count1++;
            } else if (num == ele_cnt[2]) {
                count2++;
            }
        }

        if (count1 > size / 3) {
            res.add(ele_cnt[0]);
        }
        if (count2 > size / 3) {
            res.add(ele_cnt[2]);
        }

        return res;
    }
}
