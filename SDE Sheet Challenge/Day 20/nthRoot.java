class Solution {
    public int nthRoot(int n, int m) {
        
        if(m==0){
            return 0;
        }
        
        int low = 1;
        int high = m;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            int p = (int)(Math.pow(mid, n));
            
            if(p == m){
                return mid;
            }
            else if(p < m){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}