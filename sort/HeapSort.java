package sort;

import java.util.Arrays;

//堆排序
//利用完全二叉树
//大顶堆：父节点大于子节点，根节点最大的完全二叉树    反之小顶堆
//升序用大顶堆：原理是把大顶堆的根放到最后节点不动，再去从最后一个非叶子节点排序，就形成升序。降序使用小顶堆原理一样。
public class HeapSort {
    public static void main(String[] args){
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2};

        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr){
        //开始位置(最后一个元素的父节点）
        int start = (arr.length-1)/2;
        //从开始位置也就是最后一个父节点开始，整个调整树为大顶堆
        //等于0非常重要，因为这是第一个元素调整的关键
        for (int i=start;i>=0;i--){
            maxHeap(arr,arr.length,i);
        }
        //先把数组中的第0个和堆中的最后一个数交换位置，因为第0个经过一轮处理以后已经变味最大了。
        // 再把前面的处理为大顶堆.
        for (int i=arr.length-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //这里起始位置为0的原因是调换了第一个和最后一个位置以后，去除最后一个元素，然后
            //就根节点不符合大顶堆，故直接从根节点开始，其他节点都符合大顶堆
            maxHeap(arr,i,0);
        }

    }

    /**
     *产生大顶堆
     * @param arr
     * @param size     要调整多少个节点。因为产生了最大的节点以后，下一次就不再调整这个节点
     * @param index   要调整的是哪一个节点
     */
    public static void maxHeap(int[] arr,int size,int index){
        //找出左右节点
        int leftNode = 2*index+1;
        int rightNode = 2*index+2;
        //默认本节点最大
        int max = index;
        //和两个子节点分别对比，找出最大的节点
        if (leftNode<size && arr[leftNode] > arr[max]){
            max = leftNode;
        }
        if (rightNode<size && arr[rightNode] > arr[max]){
            max = rightNode;
        }
        //交换位置(不等于这个下标，说明最大的不是自己)这里不就是选择排序吗
        if (max != index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //交换位置以后可能破坏之前排好的堆，所以，之前排好的堆需要重新调整
            //这里是从调整之后的位置开始继续调整后面的
            maxHeap(arr,size,max);
        }
    }
}
