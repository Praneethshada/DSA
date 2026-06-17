class Solution {
    public boolean palindrome(String st,int s,int e){
        while(s<=e){
            if(st.charAt(s)!=st.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    public void bt(String s,int idx,List<String> sub,List<List<String>> ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(palindrome(s,idx,i)){
                sub.add(s.substring(idx,i+1));
                bt(s,i+1,sub,ans);
                sub.remove(sub.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        bt(s,0,sub,ans);
        return ans;
    }
}