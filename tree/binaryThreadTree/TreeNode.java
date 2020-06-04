package tree.binaryThreadTree;

public class TreeNode {
    //节点的权
    int value;
    //左孩子
    TreeNode leftNode;
    //右孩子
    TreeNode rightNode;

    //leftType  0 ：指向左孩子    1：指向节点的前驱
    //这里的前驱和后继指向的不是左右孩子，前驱是已经访问的节点，后继是未访问的节点
    int leftType;   //默认为0
    //rightType  0 ：指向右孩子    1：指向节点的后继
    int rightType;

    public TreeNode(int value){
        this.value = value;
    }
}
