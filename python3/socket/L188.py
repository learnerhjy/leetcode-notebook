class Solution:
    def maxProfit(self, k, prices):
        if not prices or k==0:
            return 0
        if k>len(prices)//2:
            dp_i_0,dp_i_1 = 0,float("-inf")
            for i in range(len(prices)):
                dp_i_0,dp_i_1 = max(dp_i_0,dp_i_1+prices[i]),max(dp_i_1,dp_i_0-prices[i])
            return dp_i_0
        else:
            dp = [[[0,0] for _ in range(k+1)] for _ in range(len(prices))]
            for i in range(0,len(prices)):
                for j in range(k,0,-1):
                    if i==0:
                        dp[i][j][0] = 0
                        dp[i][j][1] = -prices[i]
                        continue
                    dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1]+prices[i])
                    dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i])
            return dp[-1][k][0]