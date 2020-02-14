class Solution:
    def maxProfit(self, prices, fee):

        dp_i_0,dp_i_1 = 0,float("-inf")
        for i in range(len(prices)):
            dp_i_0,dp_i_1 = max(dp_i_0,dp_i_1+prices[i]),max(dp_i_1,dp_i_0-prices[i]-fee)
        return dp_i_0