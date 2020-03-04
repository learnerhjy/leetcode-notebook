#coding:UTF-8
class Solution:
    def backtracking(self,start,res,path,nums):
        res.append(path[:])
        if(start==len(nums)):
            return
        for i in range(start,len(nums)):
            self.backtracking(i+1,res,path+[nums[i]],nums)

    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtracking(0,res,[],nums)
        return res

'''
此题本质上也是求出所有组合，与combination和combination sum的不同在于每一个可行解的长度不是固定的
因此每一次搜索时都把当前路径加入解集中
同样适用改变每次搜索时的起始位置避免重复
'''
