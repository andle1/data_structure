package aareview.sort;

//快速排序  （交换排序）

import java.util.Arrays;

//原理：初始取第0位元素作为切分元素，然后从数组的右端开始向左扫描直到找到一个小于
// 等于切分元素的元素，把低位所指的大的元素值赋给高位，本身值不变，然后右边指针不变，
// 从数组左端向右扫描直到找到一个大于等于切分元素的元素，赋值，依此类推。
public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[]{5,3,8,2,4,1,66,11};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end){
            //默认选取数组第1个元素作为切分元素
            int temp = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //左右循环
            while (low < high){
                while ( low<high && temp <= arr[high]){
                    high--;
                }
                arr[low] = arr[high];
                while (low<high && temp >= arr[low]){
                    low++;
                }
                arr[high] = arr[low];
            }
            //把标准数赋值给低的所在位置的元素（这时候高低已经重合）
            arr[low] = temp;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);
        }
    }
}
