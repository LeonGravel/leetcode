package trees;

import java.util.LinkedList;

/**
 * @ClassName IsValidBST
 * @Description: 验证是否是二叉搜索树
 * @Author gravel
 * @Date 2019/11/24
 * @Version V1.0
 *
 * 思路：使用中序遍历，将数据压栈，每次在压栈之前，都去判断栈顶的数据是否小于等于当前节点的数据，如果符合，那么继续查找
 * 如果不符合，那么返回结果。
 **/
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        return MidOrder(root, queue);
    }

    public boolean MidOrder(TreeNode root, LinkedList<TreeNode> queue) {
        boolean left = true, right = true;
        if (root != null) {
            left = MidOrder(root.left, queue);  //中根遍历左子树
            TreeNode last = queue.peekLast();
            if (last != null && last.val >= root.val) return false;
            queue.add(root);//访问根节点
            right = MidOrder(root.right, queue);  //中根遍历右子树
        }
        return left && right;
    }
}
