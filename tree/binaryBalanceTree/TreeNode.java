package tree.binaryBalanceTree;

public class TreeNode {
    int value;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 返回的是以这个节点为根节点的树的高度
     * @return
     */
    public int height(){
        //比较的是左右子树的高度，本身的高度需要加 1.
        return Math.max(leftNode==null?0:leftNode.height(),rightNode==null?0:rightNode.height())+1;
    }

    /**
     * 左子树高度
     * @return
     */
    public int leftHeight(){
        if (leftNode==null){
            return 0;
        }
        return leftNode.height();
    }

    /**
     * 左子树高度
     * @return
     */
    public int rightHeight(){
        if (rightNode==null){
            return 0;
        }
        return rightNode.height();
    }
}
