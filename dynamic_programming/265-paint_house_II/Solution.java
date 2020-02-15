class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length==0)
            return 0;

        int ans = Integer.MAX_VALUE;
        int num_of_house = costs.length;
        int num_of_cost = costs[0].length;
        int[] dp = new int[num_of_cost];
        int[] most_small = {Integer.MAX_VALUE,-1},second_small = {Integer.MAX_VALUE,-1};
        for(int i=0;i<num_of_cost;i++){
            dp[i] = costs[0][i];
            if(dp[i]<most_small[0]){
                if(most_small[0]<second_small[0]){
                    second_small[0] = most_small[0];
                    second_small[1] = most_small[1];
                }
                most_small[0] = dp[i];
                most_small[1] = i;
            }
            else if(dp[i]<second_small[0]){
                second_small[0] = dp[i];
                second_small[1] = i;                
            }
        }

        for(int i=1;i<num_of_house;i++){
            int temp_1[] = Arrays.copyOf(most_small,2);
            int temp_2[] = Arrays.copyOf(second_small,2);
            most_small[0] = Integer.MAX_VALUE;
            second_small[0] = Integer.MAX_VALUE;
            for(int j=0;j<num_of_cost;j++){
                if(j!=temp_1[1])
                    dp[j] = temp_1[0] + costs[i][j];
                else
                    dp[j] = temp_2[0] + costs[i][j];

                if(dp[j]<most_small[0]){
                    if(most_small[0]<second_small[0]){
                        second_small[0] = most_small[0];
                        second_small[1] = most_small[1];
                    }
                    most_small[0] = dp[j];
                    most_small[1] = j;
                }
                else if(dp[j]<second_small[0]){
                    second_small[0] = dp[j];
                    second_small[1] = j;                
                }
            }

        }

    for(int num:dp)
        ans = Math.min(ans,num); 
    return ans;
    
    }
}