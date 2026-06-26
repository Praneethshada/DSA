class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            stack.push(arr[i]);
        }

        Collections.reverse(ans);
        return ans;
    }
}
