class Solution {

    private String hash(String str){
        int size = str.length();
        if(size==0)
            return "0";
        if(size==1)
            return "1";
        String hash_code = "";
        for(int i=0;i<size-1;i++){
            int origin = str.charAt(i)-str.charAt(i+1);
            if(origin<0)
                origin = 26 + origin;
            hash_code += origin + "/";
        }
        return hash_code;
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strings){
            String hash_code = hash(str);
            List<String> temp = map.getOrDefault(hash_code,new ArrayList<String>());
            temp.add(str);
            map.put(hash_code,temp);
        }
        for(List<String> value:map.values()){
            res.add(value);
        }
        return res;
    }
}

/*
    字符串移位
    使用hash 根据字符串中各相邻字符之间的距离计算hash 注意距离为负的情况
*/