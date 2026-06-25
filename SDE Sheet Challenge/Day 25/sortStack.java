class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        int[] nums = new int[1001];
        while(!st.isEmpty()){
            nums[st.pop()]++;
        }
        
        for(int i=0;i<1001;i++){
            while(nums[i]!=0){
                st.push(i);
                nums[i]--;
            }
        }
    }
}