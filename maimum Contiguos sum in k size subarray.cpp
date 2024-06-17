#include <iostream>
using namespace std;

int maxSubArray(int* nums, int numsSize,int k){
    int maxSum = 0;
    int start=0;
    int windowSum=0;
    for(int end=0;end<numsSize;end++){
        windowSum+=nums[end];
        if(end>=k-1){
            maxSum = max(maxSum,windowSum);
            windowSum-=nums[start];
            start++;
        }
    }
    return maxSum;
}

int main(){

    cout<<maxSubArray(new int[9]{1,2,3,4,5,6,7,8,9},9,3)<<endl;
    return 0;
}
