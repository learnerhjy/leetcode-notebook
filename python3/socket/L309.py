class Solution:
    def maxProfit(self, prices):
        dp_i_0,dp_i_1=0,float("-inf")
        dp_i_pre = 0
        for i in range(len(prices)):
            tmp = dp_i_0
            dp_i_0,dp_i_1 = max(dp_i_0,dp_i_1+prices[i]),max(dp_i_1,dp_i_pre-prices[i])
            dp_i_pre = tmp
        return dp_i_0