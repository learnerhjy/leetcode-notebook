class Solution:
    def maxProfit(self, prices):
        if not prices:
            return 0

        dp = [[[0,0] for _ in range(3)] for _ in range(len(prices))]
        for i in range(0,len(prices)):
            for k in range(2,0,-1):
                if i==0:
                    dp[i][k][0] = 0
                    dp[i][k][1] = -prices[i]
                    continue
                dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
                dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
        return dp[-1][2][0]