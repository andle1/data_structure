package tree.binarySortTree;

//二叉排序树     也叫二叉查找树，二叉搜索树。BST。
//对于二叉树中的任何一个非叶子节点，要求左子节点比当前节点值小，右子节点比当前节点值大
//优点：查询方便      缺点：{1,2,3,4,5,6,7,8} ,这样已经排好序的数组会让二叉排序树变成一条线

public class SortTree {
    //根节点
    public TreeNode root;

    /**
     * 创建二叉排序树
     * @param data
     */
    public SortTree(int[] data){
        for (int i = 0; i < data.length; i++) {
            addNode2(data[i]);
        }
    }

    /**
     * 添加节点
     */
    public void addNode(int value){
        TreeNode currentNode = root;
        //没有根节点
        if (root==null){
            root = new TreeNode(value);
            return;
        }
        while(true){
            //在左子树
            if (value < currentNode.value){
                //左子节点为空，直接放左子节点。
                if (currentNode.leftNode == null){
                    currentNode.leftNode = new TreeNode(value);
                    return;
                }else {
                    currentNode = currentNode.leftNode;
                }
            //在右子树
            }else {
                if ( currentNode.rightNode == null){
                    currentNode.rightNode = new TreeNode(value);
                    return;
                }else {
                    currentNode = currentNode.rightNode;
                }
            }
        }
    }

    public void addNode2(int value){
        addNode2(root,value);
    }
    /**
     * 添加节点方法2   (递归方式)
     */
    public void addNode2(TreeNode node,int value){
        if(root == null) {
            root = new TreeNode(value);
            return;
        }

        if(value > node.value) {
            if(node.rightNode == null) {
                node.rightNode = new TreeNode(value);
            } else {
                addNode2(node.rightNode, value);
            }
        } else {
            if(node.leftNode== null) {
                node.leftNode = new TreeNode(value);
            } else {
                addNode2(node.leftNode, value);
            }
        }
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


    public TreeNode searchNodeByD(int value){
        return searchNodeByD(root,value);
    }
    /**
     * 二叉排序树查找(递归方式)
     * 由于二叉排序树可以看成是一个有序表，所以在二叉排序树上进行查找类似于折半查找，
     * 即逐步缩小查找范围的过程。
     */
    public TreeNode searchNodeByD(TreeNode node,int value){
        if (node == null){
            return null;
        }
        //首先判断本节点的值
        if (node.value == value){
            return node;
        }else if (node.value > value){
            if (node.leftNode == null){
                return null;
            }
            return searchNodeByD(node.leftNode,value);
        }else {
            if (node.rightNode == null){
                return null;
            }
            return searchNodeByD(node.rightNode,value);
        }
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

//    这种写法和上面一模一样，只是把当前的调用者直接变为root，比上面简便
//    public TreeNode searchNodeByF(int value) {
//        TreeNode temp = root;
//        while(temp != null) {
//            if(temp.value == value) {
//                return temp;
//            }
//            if(value < temp.value) {
//                temp = temp.leftNode;
//            } else {
//                temp = temp.rightNode;
//            }
//        }
//        return null;
//    }

    /**
     * 删除节点（删除的就是一个节点）
     * 三种情况：叶子节点，一个节点，两个节点
     * 两个节点一般就是在右子树找到最小的
     */
    public void delNode(int value){
        TreeNode cur = root;  //当前节点
        TreeNode parent = null;  //父节点

        //查找待删结点p和待删结点的父结点
        while (true){
            if (value == cur.value){
                break;
            }
            parent = cur;
            if (value < cur.value){
                cur = cur.leftNode;
            }else {
                cur = cur.rightNode;
            }
        }

        //如果没有这个节点
        if (cur == null){
            return;
        }

        //要删除的节点没有右子树
        if (cur.rightNode == null){
            //要删除的节点是叶子节点
            if(cur.leftNode == null){
                //判断当前要删除的节点是左节点还是右节点
                if(parent.leftNode.value == value){
                    parent.leftNode = null;
                }else {
                    parent.rightNode = null;
                }
            //要删除节点只有左子树
            }else {
                //判断当前要删除的节点是左节点还是右节点
                if (parent.leftNode == cur){
                    parent.leftNode = cur.leftNode;//待删结点的左子节点变为父节点的左子节点
                }else {
                    parent.rightNode = cur.leftNode; //待删结点的左子节点变为父节点的右子节点
                }
            }
        }else {
            //要删除的节点只有右子树
            if (cur.leftNode == null){
                if (parent.leftNode == cur){
                    parent.leftNode = cur.rightNode;
                }else {
                    parent.rightNode = cur.rightNode;
                }
            //要删除的节点有两个节点
            }else {
                //找到右子树最左下角的节点（即最小节点），替换当前节点.,（这里注意最小的节点是否还有子节点）
                TreeNode temp = cur;//最小节点的父节点
                TreeNode delNode = cur.rightNode;//最小节点
                //查找待删结点的最左下角结点(也就是最小的节点)
                while (delNode.leftNode != null){
                    temp = delNode;
                    delNode = delNode.leftNode;
                }
                //最小的节点是叶子节点（最小的节点如果有子节点，一定在右节点上。）
                if (delNode.rightNode == null){
                    temp.leftNode = null;//删掉最小的节点，也就是delNode.
                    cur.value = delNode.value;
                //
                }else {
                    temp.leftNode = delNode.rightNode;//把最小节点的右节点指向父节点的左节点
                    cur.value = delNode.value;
                }

            }
        }
    }
}
