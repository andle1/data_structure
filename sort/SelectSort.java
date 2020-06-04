package sort;

import java.util.Arrays;

//选择排序
//每一轮选出来的是最小元素的下标。有反冒泡的意思
//原理：初始从第0个元素开始，依次和后面所有的元素比较，找出最小的元素的下标，
// 和开始元素交换位置。再从第一个重复上面的动作
public class SelectSort {
    public static void main(String[] args){
        int[] arr=new int[]{1,4,5,2,8,3,6};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i=0;i<arr.length;i++){
            //默认初始最小元素为每轮的开始元素
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                //如果后面比较的数比记录的最小的数小。
                if (arr[j] < arr[minIndex]){
                    //记录最小的数的下标
                    minIndex = j;
                }
            }
            //如果最小的数和当前遍历数的下标不一致，说明下标minIndex的数比当前遍历的数更小
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
