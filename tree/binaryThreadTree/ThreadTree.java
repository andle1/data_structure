package aareview.tree.binaryThreadTree;

import java.util.LinkedList;

//线索二叉树            特殊的双向链表
//有前驱和后继
public class ThreadTree {
    TreeNode root;

    //存储前驱节点
    TreeNode pre = null;


    public ThreadTree(int[] data){
        LinkedList<TreeNode> list = new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for (int i=0;i<data.length;i++){
            list.add(new TreeNode(data[i]));
        }
        root = list.get(0);
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0;parentIndex<data.length/2 -1;parentIndex++){
            // 左孩子
            list.get(parentIndex).leftNode= list.get(parentIndex * 2 + 1);
            // 右孩子
            list.get(parentIndex).rightNode = list.get(parentIndex * 2 + 2);
        }

        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = data.length / 2 - 1;
        // 左孩子
        list.get(lastParentIndex).leftNode = list.get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (data.length % 2 == 1) {
            list.get(lastParentIndex).rightNode = list.get(lastParentIndex * 2 + 2);
        }
        frontThreadNodes();
    }

    private void frontThreadNodes(){
        frontThreadNodes(root);
    }
    /**
     * 中序线索化二叉树
     */
    private void frontThreadNodes(TreeNode node){
        //当前节点如果是null，直接返回。这是递归的出口，返回上一层不为null的节点
        if(node == null){
            return;
        }
        //处理左子树
        frontThreadNodes(node.leftNode);
        //没有左节点，就存前驱（第一次遍历到的前驱肯定为null）
        if (node.leftNode == null){
            //当前节点的左指针指向前驱节点
            node.leftNode = pre;
            //改变前驱节点的类型
            node.leftType = 1;
        }
        //这次处理是对于上一次的递归的处理
        //处理前驱节点的右指针，如果前驱节点的右指针是null（没有子树，就存后继）
        if (pre!=null && pre.rightNode == null){
            //把现在这和节点变为之前节点的后继
            pre.rightNode = node;
            //改变之前节点的右指针类型
            pre.rightType = 1;
        }
        //每处理一个节点，把当前节点变为前驱节点
        pre = node;
        //处理右子树
        frontThreadNodes(node.rightNode);
    }

    /**
     * 中序遍历线索二叉树(循环方式)
     *
     */

    public void midShow(){
        TreeNode node = root;
        while (node!=null){
            //找到左孩子
            while (node.leftType == 0){
                node = node.leftNode;
            }
            //打印当前节点的值
            System.out.println(node.value);
            //如果当前节点的右指针指向的是后继节点，可能后继节点还有后继节点
            while (node.rightType == 1){
                node = node.rightNode;
                System.out.println(node.value);
            }
            node = node.rightNode;
        }
    }

    public TreeNode frontSearch(int value){
        return frontSearch(root,value);
    }
    /**
     * 前序查找
     * @param value
     * @return
     */
    public TreeNode frontSearch(TreeNode node,int value){
        TreeNode target = null;
        //当前节点就是要查的节点
        if (node.value == value){
            return node;
        }else {
            if (node.leftNode.value != value){
                target = frontSearch(node.leftNode,value);
            }
            //如果不为空,说明左孩子已经找到了
            if (target != null){
                return target;
            }
            if (node.rightNode != null){
                target = frontSearch(node.rightNode,value);
            }
        }
        return target;
    }
}
