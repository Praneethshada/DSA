class Solution {
    public String reverseWords(String s) {
        if(s.length()<=1){
            return s;
        }

        int i = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0){f
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            int j=i;
            while(j>=0 && s.charAt(j)!=' '){
                j--;
            }

            sb.append(s.substring(j+1, i+1));
            sb.append(" ");

            i = j;
        }

        return sb.toString().trim();
    }
}