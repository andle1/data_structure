package tree.binaryThreadTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadTreeTest {

    @Test
    public void frontThreadNodes() {
        int[] arr = new int[]{3,7,2,9,4,3,6,0};
        ThreadTree threadTree = new ThreadTree(arr);
        threadTree.midShow();
        TreeNode node = threadTree.frontSearch(3);
        System.out.println(node.value);
    }
}