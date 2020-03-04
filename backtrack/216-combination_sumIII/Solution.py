# coding:UTF-8

class Solution:
    def backtracking(self,target,k,start,path,res):
        if(target==0 and len(path)==k):
            res.append(path[:])
            return
        if(len(path)>k):
            return
        for i in range(start,10):
            if(target-i<0):
                break
            self.backtracking(target-i,k,i+1,path+[i],res)


    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []
        self.backtracking(n,k,1,[],res)
        return res

'''
target-i剪枝 len(path)>k剪枝
'''
