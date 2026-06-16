class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int[][] meet = new int[start.length][2];

        for (int i = 0; i < start.length; i++) {
            meet[i][0] = start[i];
            meet[i][1] = end[i];
        }

        Arrays.sort(meet, Comparator.comparingInt(a -> a[1]));

        int last = -1;
        int count = 0;

        for(int i=0;i<meet.length;i++){
            if(meet[i][0] > last){
                last = meet[i][1];
                count++;
            }
        }

        return count;
    }
}