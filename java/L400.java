class Solution {
    public int findNthDigit(int n) {
        int digits = 1;
        long num_of_digit = 9;
        long bar = digits*num_of_digit;
        while(n>bar){
            digits ++;
            num_of_digit *= 10;
            bar += digits*num_of_digit;
        }
        //System.out.println(digits);

        long nth_digit = (n - (bar-digits*num_of_digit));
        int nth_number = (int)nth_digit%digits;
        nth_digit = nth_digit/digits;
        if(nth_number!=0)
            nth_digit++;
        //System.out.println("几位数" + digits + "第几个数" + nth_digit + "第几位" + nth_number);
        String string_of_digit = Long.toString((long)Math.pow(10,digits-1)+nth_digit-1);
        if(nth_number!=0)
            return Integer.parseInt(string_of_digit.substring(nth_number-1,nth_number));
        else
            return Integer.parseInt(string_of_digit.substring(string_of_digit.length()-1));

    }
}

/*
    要找到第n个数字等价于找到该数字所在的数i以及该数字在数i中的位置j
    规律1：1位数有9个 2位数有90个 3位数有900个......
    根据规律1 可以找到数i的位数digits
    根据digits可以找到数i是第几个digits位数 以及n是数i中的第几个数
    规律2：第m个n位数等于 10^(n-1)+m-1 
    根据规律2 可以找到数i
    再从数i中找到结果n 这里采用了将i转换为字符串再去找的方法

    Time complexity O(n)
    Space complexity O(1)

    需要注意某些变量需要使用long类型否则会溢出

*/