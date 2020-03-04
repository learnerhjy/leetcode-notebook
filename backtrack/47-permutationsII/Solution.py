#coding:UTF-8
class Solution:

    def backtracking(self,nums,path,res,used):
        if(len(path)==len(nums)):
            res.append(path[:])
            return
        for i in range(len(nums)):
            if(used[i]):
                continue
            if(i>0 and nums[i]==nums[i-1] and not used[i-1]):
                continue
            used[i] = True
            path.append(nums[i])
            self.backtracking(nums,path,res,used)
            path.pop()
            used[i] = False

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        if(len(nums)==0):
            return res
        nums.sort()
        used = [False for _ in range(len(nums))]
        self.backtracking(nums,[],res,used)
        return res

'''
此题与46的区别也是是否有重复数字。
用和40题相同的方法剪枝。
combination和permutation不同的一点在于combination与顺序无关，而permutation就是由顺序决定的。因此在combination中可以通过改变每次搜索时的起始index而不用使用used数组，而在permutation中就要使用used数组。（当然像45题中使用swap也可以避免使用used数组来记录访问情况）
'''
