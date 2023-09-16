#include <stdio.h>

int result;
int sum;

void dfs(int presum, int nums[], int idx);

int countMaxOrSubsets(int nums[], int length) {
    result = 0;
    sum = 0;
    
    for (int i = 0; i < length; i++) {
        sum |= nums[i];
    }
    
    dfs(0, nums, 0, length);
    
    return result; 
}

void dfs(int presum, int nums[], int idx, int length) {
    if (presum == sum) {
        result += 1 << (length - idx);
        return;
    }
    
    if (idx == length) {
        return;
    }
    
    dfs(presum | nums[idx], nums, idx + 1, length);
    dfs(presum, nums, idx + 1, length);
}

int main() {
    int nums[] = {1, 2, 3};
    int length = sizeof(nums) / sizeof(nums[0]);
    int maxOrSubsets = countMaxOrSubsets(nums, length);
    printf("Maximum OR Sum: %d\n", maxOrSubsets);
    
    return 0;
}
