// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return new ArrayList<>();
        }
     
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int match = 0;

        for(int i = 0; i< p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i = 0; i<s.length(); i++){
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)){
                int cnt = map.get(incoming);
                cnt--;
                if(cnt == 0){
                    match++;
                }
                map.put(incoming, cnt);
            }
            if(i>=p.length()){
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)){
                    int cnt = map.get(outgoing);
                    cnt++;
                    if(cnt == 1){
                        match--;
                    }
                    map.put(outgoing, cnt);
                }
            }
            if(map.size() == match){
                res.add(i - p.length() + 1);
            }
        }
        return res;
        
    }
}