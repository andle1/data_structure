package heap;

//二叉堆
//最大堆：父节点大于子节点，根节点最大的完全二叉树
//最小堆：父节点小于子节点，根节点最小的完全二叉树
//构建二叉堆：就是把一个无序的完全二叉树调整为二叉堆，本质就是
//让所有的非叶子节点依次下沉
public class heap {
    int[] data;

    /**
     * 上浮
     * 插入节点后，插入的位置是最后一个节点。再去比较节点值大小
     * @param data
     */
    public void upAdjust(int[] data){

    }

    /**
     * 下沉
     * 删除一个节点后，会默认把最后的节点拿到根节点，才会继续为完全二叉树，再去比较节点值大小
     * @param data
     * @param parent
     * @param length
     */
    public void downAdjust(int[] data,int parent,int length){}
}
