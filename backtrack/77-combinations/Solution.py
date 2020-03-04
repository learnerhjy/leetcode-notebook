# coding:UTF-8
class Solution:
    def backtracking(self,k,n,start,res,path):
        if(len(path)==k):
            res.append(path[:])
            return
        for i in range(start,n+1):
            path.append(i)
            self.backtracking(k,n,i+1,res,path)
            path.pop()

    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        if(k<=0):
            return res

        self.backtracking(k,n,1,res,[])
        return res

'''
此题也是组合，通过每次搜索的起始index避免重复
'''
