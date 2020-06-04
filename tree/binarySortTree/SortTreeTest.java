package tree.binarySortTree;

import org.junit.Test;

public class SortTreeTest {

    @Test
    public void addNode() {
//        int[] arr = new int[]{7,3,1,5,10,9,12};
        int[] arr = new int[]{7,3,11,1,5,9,12,10};
        SortTree st = new SortTree(arr);
        //st.midShow();
//        TreeNode s = st.searchNodeByF(1);
//        System.out.println(s.value);
       // st.delNode(7);
        st.midShow();


    }
}