class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }
        long ans = 0;
        int idx = 0;
        boolean neg = false;

        if(s.charAt(0) == '-'){
            neg = true;
            idx = 1;
        }
        else if(s.charAt(0) == '+'){
            idx = 1;
        }

        for(int i=idx;i<s.length();i++){
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)){
                break;
            }
            ans = ans*10 + (ch-'0');

            if(!neg && ans>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if(neg && ans*(-1)<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        if(neg){
            ans *= -1;
        }
        return (int)ans;
    }
}