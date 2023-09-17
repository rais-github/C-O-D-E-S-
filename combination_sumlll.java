class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(ans, res, k, n, 1);
        return res;
    }

    static void backtracking(List<Integer> list, List<List<Integer>> res, int k, int target, int start) {
    if (target == 0 && k == 0) {
        res.add(new ArrayList<>(list));
        return;
    }
    if (k <= 0 || target < 0 || start > 9) {
        return;
    }

    for (int i = start; i <= 9; i++) {
        list.add(i);
        backtracking(list, res, k - 1, target - i, i+1); 
        list.remove(list.size() - 1);
    }
}

}
