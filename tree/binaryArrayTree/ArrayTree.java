package tree.binaryArrayTree;

//完全二叉树
//完全二叉树 所有叶子节点都在最后一层或者倒数第二层，且最后一层的叶子节点在左边连续，倒数第二层的叶子节点在右边连续
//数组实现
public class ArrayTree {
    int[] data;

    public ArrayTree(int[] data){
        this.data = data;
    }

    /**
     * 前序遍历
     */
    public void frontShow(int index){
        if (data == null && data.length == 0){
            return;
        }
        System.out.println(data[index]);
        if (2*index+1 < data.length){
            frontShow(2*index+1);
        }
        if (2*index+2 < data.length){
            frontShow(2*index+2);
        }
    }
}
