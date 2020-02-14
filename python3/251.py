class Solution:
    def minCost(self, costs):
        dp_0,dp_1,dp_2 = 0,0,0
        for cost in costs:
            dp_0,dp_1,dp_2 = min(dp_1,dp_2)+cost[0],min(dp_0,dp_2)+cost[1],min(dp_0,dp_1)+cost[2]
        return min(dp_0,dp_1,dp_2)

'''
	动态规划问题
	三个变量代表该房子刷红色 蓝色 绿色的花费（总花费）
	转换方程
		dp_i = min(dp_j,dp_k) + cost 
	例如对于某一个房子 该房子刷红色的最低花费为 刷红色的费用+上一个房子刷蓝色或者绿色的总花费的较小值

	Time Complexity O(n)
	Space Complexity O(1)
'''