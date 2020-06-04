package tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//普通二叉树
//存储结构：1、链式存储结构。 2、数组
public class BinaryTree {
    //根节点
    TreeNode root;

    /**
     *创建二叉树
     * @param data
     */
    public BinaryTree(int[] data){
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
    }

    public void frontShow(){
        frontShow(root);
    }
    /**
     * 前序遍历(递归方式)
     * @param node
     */
    public void frontShow(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.value);
        frontShow(node.leftNode);
        frontShow(node.rightNode);
    }

    /**
     * 前序遍历（栈方式,广度优先)
     */
    public void frontShow2(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并且入栈
            while (node != null){
                System.out.println(node.value);
                stack.push(node);
                node = node.leftNode;
            }
            //没有左孩子，则弹出栈顶元素，访问节点的右孩子
            if (!stack.isEmpty()){
                node = stack.pop();
                node = node.rightNode;
            }
        }
    }


    /**
     * 广度优先遍历
     * 利用队列
     */
    public void levelFrontShow(){
        //双向链表.它也可以被当作堆栈、队列或双端队列进行操作
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //出队
            TreeNode node = queue.poll();
            System.out.println(node.value);
            //把节点左节点放入队列(先放的左节点，所以先遍历锁节点。
            if (node.leftNode != null){
                //入队
                queue.offer(node.leftNode);
            }
            //把右节点放入队列
            if (node.rightNode != null){
                queue.offer(node.rightNode);
            }
        }
    }
}
