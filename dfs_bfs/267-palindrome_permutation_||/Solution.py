class Solution:
    def generatePalindromes(self, s):
        from collections import defaultdict
        counter = defaultdict(lambda:0)
        num_of_odd = 0
        mid = ''
        temp = []
        for elem in s:
            counter[elem] += 1

        for key in counter:
            if(counter[key])%2!=0:
                num_of_odd += 1
                if num_of_odd>1:
                    return []
                mid = key
            temp += [key]*(counter[key]//2)

        size = len(temp)
        res = []
        used = [False for _ in range(len(temp))]

        def dfs(path,l):
            if(l==size):
                res.append(''.join(path)+mid+''.join(path[::-1]))
                return
            for i in range(size):
                if used[i] or (i>0 and temp[i]==temp[i-1] and not used[i-1]):
                    continue
                used[i] = True
                path.append(temp[i])
                dfs(path,l+1)
                path.pop()
                used[i] = False
        
        dfs([],0)
        return res