package aareview.tree.huffmanTree;

//赫夫曼树   （最优二叉树）  按权值大小创建节点
//最优二叉树：WPL最小的树
//叶节点的带权路径：到叶子节点的路径长度*该叶子节点的权值
//树的带权路径长度（WPL）:所有的叶节点的带权路径之和

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {


    public HuffmanTree(){

    }

    /**
     * 创建赫夫曼树
     * @param arr
     * @return
     */
    public TreeNode createHuffmanTree(int[] arr){
        //先使用数组中的所有元素都变为节点
        List<TreeNode> list = new ArrayList<>();
        for (int value:arr){
            list.add(new TreeNode(value));
        }
        //处理
        while (list.size()>1){
            //排序(这里注意，每次都会排序一次)
            Collections.sort(list);
            //取出权值最小的两个节点
            TreeNode leftNode = list.get(list.size()-1);
            TreeNode rightNode = list.get(list.size()-2);
            //创建一颗新的二叉树
            TreeNode parent = new TreeNode(leftNode.value+rightNode.value);
            parent.leftNode = leftNode;
            parent.rightNode = rightNode;
            //把取出来的两个二叉树移除
            list.remove(leftNode);
            list.remove(rightNode);
            //放入原来的二叉树集合中
            list.add(parent);
        }
        return list.get(0);
    }
}
