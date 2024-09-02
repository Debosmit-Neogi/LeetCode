class Solution {
    public int rob(int[] nums) {
        /* DP: Memoization */
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1, dp);
    }

    private int rob(int[] nums, int index, int[] dp){
        if(index < 0){
            return 0;
        }
        if(index == 0){
            return nums[index];
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + rob(nums, index-2, dp);
        int notpick = rob(nums, index-1, dp);

        dp[index] = Math.max(pick, notpick);
        return dp[index];
    }
}