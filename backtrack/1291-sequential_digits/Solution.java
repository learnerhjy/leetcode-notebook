class Solution {

    private void backtracking(int low,int high,int num,int last_digit,List<Integer> res){
        if(num>=low&&num<=high)
            res.add(num);
        if(last_digit<9)
            if(num*10+last_digit+1<=high)
                backtracking(low,high,num*10+last_digit+1,last_digit+1,res);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if(low>high)
            return res;
        for(int i=1;i<10;i++)
            backtracking(low,high,i,i,res);
        Collections.sort(res);
        return res;
    }
}

/*
回溯生成<=high的所有顺次数，并把在[low,high]范围中的加入解集
*/
