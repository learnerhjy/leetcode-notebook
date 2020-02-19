class Solution {

    private boolean isValid(int window_size,int length,int right,Set<String> set,Map<String,Integer> map,String s){  
            Map<String,Integer> cur_map = new HashMap<>();
            for(int i=right+1-window_size;i<=right;i+=length){
                String word = s.substring(i,i+length);
               // System.out.println(word);
                if (!set.contains(word))
                    return false;
                int temp = cur_map.getOrDefault(word,0);
                cur_map.put(word,temp+1);
            }
            if(map.size()!=cur_map.size())
                return false;
            for(Map.Entry entry:map.entrySet())
                if(!entry.getValue().equals(cur_map.get(entry.getKey())))
                    return false;
            return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length==0)
            return new ArrayList<>();
        int length = words[0].length();
        int window_size = words.length*length;
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        //int[] counter = new int[26];
        for(String word:words){
            set.add(word);
            int temp = map.getOrDefault(word,0);
            map.put(word,temp+1);
        }
        /*for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        */
        int right = 0;
        while(right<s.length()){
            if(right>=window_size-1){
                // for循环找word
                // hashmap记录word出现次数
                // set判断word是否出现在words里 若否直接break
                // 如果都在set里 再判断出现次数
                // 然后继续右移 出现次数减少 为0时移除key
                if(isValid(window_size,length,right,set,map,s))
                    res.add(right+1-window_size);
            }
        right++; 
        }
        return res;
    }
}