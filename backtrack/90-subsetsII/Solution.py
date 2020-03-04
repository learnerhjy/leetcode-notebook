#coding:UTF-8
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        def backtrack(i,tmp):
            res.append(tmp[:])
            if i == len(nums):
                return
            for j in range(i,len(nums)):
                if j>i and nums[j]==nums[j-1]:
                    continue
                backtrack(j+1,tmp+[nums[j]])
        backtrack(0,[])

        return res

'''
此题与subsets的区别在于有重复数字。通过第12，13行的代码进行剪枝。
由于本质上是组合，即与顺序无关，因此剪枝时也不需要使用used数组，直接跳过重复数字即可
'''
