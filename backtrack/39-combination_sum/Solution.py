# coding:UTF-8
class Solution:
    def backtracking(self,start,candidates,path,res,target):
        if(target==0):
            res.append(path[:])
            return 
        for i in range(start,len(candidates)):
            if(target-candidates[i]<0): # 剪枝
                break
            self.backtracking(i,candidates,path+[candidates[i]],res,target-candidates[i])# path+[candidates[i]]函数返回时保证path恢复原状态，进行下一次搜索

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort() # 排序后可以进行剪枝
        self.backtracking(0,candidates,[],res,target)
        return res
