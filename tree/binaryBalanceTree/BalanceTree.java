package tree.binaryBalanceTree;

//平衡二叉树（AVL）
//左子树和右子树的高度差的绝对值不超过一,并且本身也是二叉排序树.可以看做是对于二叉排序树的改进

//左-左，左-右，右-右，右-左这4类情况分析，而对左-左，右-右情况进行单旋转，
// 也就是一次旋转，对左-右，右-左情况进行双旋转，两次旋转，最终恢复其平衡特性。
public class BalanceTree {
    TreeNode root;

    /**
     * 创建平衡二叉树
     * @param data
     */
    public BalanceTree(int[] data){
        for (int i = 0; i < data.length; i++) {
            addNode(data[i]);
        }
    }


    public void addNode(int value){
        addNode(root,value);
    }
    /**
     *添加节点
     */
    public void addNode(TreeNode node,int value) {
        //没有根节点
        if (node == null) {
            root = new TreeNode(value);
            return;
        }
        //添加到右子树
        if (node.value < value){
            if (node.rightNode == null ){
                node.rightNode = new TreeNode(value);
            }else {
                addNode(node.rightNode,value);
            }
        }else {
            if (node.leftNode == null){
                node.leftNode = new TreeNode(value);
            }else {
                addNode(node.leftNode,value);
            }
        }
        //检查是否平衡(这里注意，是以当前节点，就是root为根节点的树的高度，而不是递归时候每次变化的节点）
        //进行右旋转
        if (root.leftHeight() - root.rightHeight() >= 2){
            //LR  当前节点的左节点的左子树比右子树低，双旋转
            if(root.leftNode !=null  && root.leftNode.leftHeight()<root.leftNode.rightHeight()){
                //先左旋转的当前节点的左节点
                leftRotate(root.leftNode);
                //再右旋转
                rightRotate(root);
            }else {
                //LL 直接右旋转
                rightRotate(root);
            }
        //左旋转
        }
        if (root.leftHeight() - root.rightHeight() <= -2){
            if (root.rightNode != null && root.rightNode.leftHeight() > root.rightNode.rightHeight()){
                rightRotate(root.rightNode);
                leftRotate(root);
            }else {
                //RR
                leftRotate(root);
            }
        }
    }

    /**
     * LL   添加到当前节点的leftNode的左节点     右旋
     * LR    添加到当前节点的leftNode的右节点    这里注意，就是当前节点的左节点，而不是左节点下面的左节点。
     * @param node
     * @return
     */
    public void rightRotate(TreeNode node) {
        //创建一个新节点等于当前节点的值
        TreeNode temp = new TreeNode(node.value);
        //把当前节点的右子树等于新节点的右子树
        temp.rightNode = node.rightNode;
        //把当前节点的左子树的右子树等于新节点的左子树
        temp.leftNode = node.leftNode.rightNode;
        //把当前节点值换为左子节点的值
        node.value = node.leftNode.value;
        //把当前节点的左子树设置为左子树的左子树
        node.leftNode = node.leftNode.leftNode;
        //把当前节点的右子树设置为新节点
        node.rightNode = temp;
    }

    /**
     * RR     左旋
     * @param node
     * @return
     */
    public void leftRotate(TreeNode node) {
        //这里必须要创建一个新节点，而不是直接赋值，不然就是两个引用操作一个对象
        //TreeNode temp = node;
        TreeNode temp = new TreeNode(node.value);
        temp.leftNode = node.leftNode;
        temp.rightNode = node.rightNode.leftNode;
        node.value = node.rightNode.value;
        node.leftNode = temp;
        node.rightNode = node.rightNode.rightNode;
    }


    /**
     * 计算树中某一节点的高度
     * @param node  树的根节点
     * @return
     */
    public int height(int value){
        TreeNode node = searchNodeByF(value);
        return node.height();
    }

    public TreeNode searchNodeByF(int value){
        return searchNodeByF(root,value);
    }
    /**
     * 非递归实现二叉排序树查找
     * @param value
     * @return
     */
    public TreeNode searchNodeByF(TreeNode node, int value) {
        TreeNode temp = node;
        while(temp != null) {
            if(temp.value == value) {
                return temp;
            }
            if(value < temp.value) {
                temp = temp.leftNode;
            } else {
                temp = temp.rightNode;
            }
        }
        return null;
    }

    public void midShow(){
        midShow(root);
    }
    /**
     *中序遍历
     * 因为中序遍历的结果是顺序的
     */
    public void midShow(TreeNode root){
        if (root != null){
            midShow(root.leftNode);
            System.out.println(root.value);
            midShow(root.rightNode);
        }
    }
}
