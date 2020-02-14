class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0;i<=num;i++)
            res[i] =res[i>>1]+(i&1);
        return res;
    }
}

/*
    计算二进制中1的数目
    一个数二进制形式中1的数目等于其右移后的数加上该数二进制与1（即该数的最低位是1还是0）
    
    例如    110101011 中1的个数 = 11010101（该数右移后的数中1的个数） + 1（该数&1）
            110101010 中1的个数 = 11010101（该数右移后的数中1的个数） + 0 （该数&1）

    Time Complexity O(n)
    Space Complexity O(1)
*/