// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//Brute Force
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0 || needle.length() == 0){
            return -1;
        }

        int i = 0; //haystack index
        int m = haystack.length();
        int n = needle.length();

        while(i < m){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = i;
                int k = 0; // needle index

                while(k<n && j< m && haystack.charAt(j) == needle.charAt(k)){
                    j++;
                    k++;
                }
                if(k == n){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}