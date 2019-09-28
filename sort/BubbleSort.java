package aareview.sort;

import java.util.Arrays;

//冒泡排序  （交换排序）
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,2,9,4,1,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        //比较的轮数(注意比较的轮数是数组长度减一)
        for (int i=0;i<arr.length-1;i++){
            //每轮比较的次数
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
