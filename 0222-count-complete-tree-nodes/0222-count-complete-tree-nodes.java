/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftHeight = getHeightLeft(root);
        int rightHeight = getHeightRight(root);

        if(leftHeight == rightHeight){
            
            // return 2^h - 1;
            return (2<<leftHeight)-1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getHeightLeft(TreeNode node){
        int height = 0;
        while(node.left != null){
            height++;
            node = node.left;
        }
        return height;
    }

    private int getHeightRight(TreeNode node){
        int height = 0;
        while(node.right != null){
            height++;
            node = node.right;
        }
        return height;
    }
}