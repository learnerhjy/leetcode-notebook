# coding:UTF-8
class Solution:
    def backtracking(self,target,start,candidates,res,path,used):
        if(target==0):
            res.append(path[:])
            return
        for i in range(start,len(candidates)):
            if(i>0 and candidates[i]==candidates[i-1] and not used[i-1]):
                continue
            if(target-candidates[i]<0):
                break
            used[i] = True
            path.append(candidates[i])
            self.backtracking(target-candidates[i],i+1,candidates,res,path,used)
            path.pop()
            used[i] = False

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        used = [False for _ in range(len(candidates))]
        self.backtracking(target,0,candidates,res,[],used)
        return res
'''
此题与39的不同就在于candidates中可能有重复数字
可以看到与39题相比多使用了一个used数组来记录当前数字的使用情况以及line 8，line 9两行代码
画出搜索树可以直观地看到对于重复的数字在树的同一层不能再次使用，否则在结果中就会出现重复
而在不同层可以使用重复的数字
使用used数组就能区分出如果当前数字是重复数字是否还可以加入当前路径中
如果位于同一层，则从上一个重复数字的搜索已经完毕，回溯到这一层，则used数组应该是未标记的，则当前重复数字应该剪枝
如果不是位于同一层，则上一个重复数字必然已经在used数组中标记为使用过，则当前数字可以加入路径

'''
