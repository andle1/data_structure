package aareview.tree.huffmanTree;

public class TreeNode implements Comparable<TreeNode>{
    //节点的权
    int value;
    //左孩子
    TreeNode leftNode;
    //右孩子
    TreeNode rightNode;

    public TreeNode(int value){
        this.value = value;
    }

    @Override
    public int compareTo(TreeNode o) {
        return this.value - o.value;
    }
}
