package tree.binaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void frontShow2() {
        int[] arr = new int[]{3,7,2,9,4,3,6,0};
        BinaryTree b =new BinaryTree(arr);
        b.frontShow();
        System.out.println("++++++++++++++++++++++++=");
        b.frontShow2();
    }
}