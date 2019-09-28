package aareview.sort;

import java.util.Arrays;

//归并排序
//归并意思是将两个或者两个以上的有序表组合成新的有序表
//归并排序则是递归将表一直拆分，直到最小，然后排序。再接着和前面的归并
public class MergeSort {
    public static void main(String[] args){
        int[] arr=new int[]{3,2,4,7,2,88,44};
        int[] arr2 = new int[]{1,2,3,6,2,4,8,9};
        merge(arr2,0,3,arr2.length-1);
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        int mid = (start+end)/2;
        //找到最小的数组
        if (start<end){
            //处理左边
            mergeSort(arr,start,mid);
            //处理右边
            mergeSort(arr,mid+1,end);
            //归并（其实这个时候归并的是递归到最后的两个数字，比较的是两个数字大小）
            merge(arr,start,mid,end);
        }
    }

    /**
     * 归并 即 {1,2,3,6,2,4,8,9}变为{1,2,2,3,4,6,8,9}
     * @param arr
     * @param start
     * @param mid 中间位置.也就是要拆分为两个有序数组的位置，这里是元素6代表的位置
     * @param end
     */
    public static void merge(int[] arr,int start,int mid,int end){
        //用于存储归并后的临时数组
        int[] temp = new int[end-start+1];
        //记录第一个数组中需要开始遍历的下标
        int begin1 = start;
        //记录第二个数组中需要开始遍历的下标
        int begin2 = mid+1;
        //用于记录在临时数组中存放的下标
        int index=0;
        //遍历两个数组取出小的数字，放入临时数组中
        while (begin1<=mid && begin2<=end){
            //比较两个有序数组中的大小
            if (arr[begin1] < arr[begin2]){
                //把小的数据放入临时数组中
                temp[index] = arr[begin1];
                //下标后移
                begin1++;
            }else {
                temp[index] = arr[begin2];
                begin2++;
            }
            index++;
        }
        //处理多余的数据.
        while (begin1<=mid){
            temp[index] = arr[begin1];
            index++;
            begin1++;
        }
        while (begin2<=end){
            temp[index] = arr[begin2];
            index++;
            begin2++;
        }
        //把临时数组中的数据重新放入原数组
        for(int k=0;k<temp.length;k++){
            //处理右边的时候low的值不是从0开始的(注意这里是传入的起始位置)
            arr[k+start] = temp[k];
        }
    }
}
