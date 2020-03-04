# coding:UTF-8
class Solution:
    def backtracking(self,n,start,res,path):
        '''
        if(n==1 and len(path)>1):
            res.append(path[:])
        for i in range(start,n+1):
            if(n%i==0):
                self.backtracking(int(n/i),i,res,path+[i])
        '''
        for i in range(start,int(math.sqrt(n))+1):
            if(n%i==0):
                path.append(i)
                path.append(int(n/i))
                res.append(path[:])
                path.pop()
                self.backtracking(int(n/i),i,res,path)
                path.pop()
        
    def getFactors(self, n: int) -> List[List[int]]:
        res = []
        self.backtracking(n,2,res,[])
        return res

'''
此题为组合 第二种方法比注释掉的代码快很多
'''
