package tree.binaryBalanceTree;

import org.junit.Test;

public class BalanceTreeTest {

    @Test
    public void addNode() {
        int[] arr = new int[]{8,9,5,4,6,7};
        BalanceTree st = new BalanceTree(arr);
//        st.leftRotate(st.root.leftNode);
//        st.rightRotate(st.root);
        ///st.midShow();
        System.out.println(st.height(6));
        TreeNode node = st.searchNodeByF(6);
        System.out.println(node.height());
    }
}