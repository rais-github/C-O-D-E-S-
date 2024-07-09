class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        int numberOfCustomers = customers.size();
        long totalTime = 0, prePrepTime = 0;

        for(int i = 0; i < numberOfCustomers; i++) {
            int arrivalTime = customers[i][0];
            int prepareTime = customers[i][1];

            if(prePrepTime > arrivalTime) {
                prePrepTime += prepareTime;
                totalTime += prePrepTime - arrivalTime;
            } else {
                prePrepTime = arrivalTime + prepareTime;
                totalTime += prepareTime;
            }
        }

        return double(totalTime) / numberOfCustomers;
    }
};
