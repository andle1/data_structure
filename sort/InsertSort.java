package sort;

import java.util.Arrays;

//直接插入排序    (插入排序)
//原理：从第二个元素开始，依次和前面的元素比较，如果当前数字比前一个数字小，
// 则存储起来，把当前位置元素变为前一个值，再把存储起来的数值和前面的前面所有的数比较，
// 直到找到一个小于它的数，替换这个位置的后一位元素值为存储值
//目的：解决直接插入排序的缺点。

public class InsertSort {
    public static void main(String[] args){
        int[] arr = new int[]{5,3,2,6,8,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        //从带二个元素开始进行插入排序
        for (int i=1;i<arr.length;i++){
            //前一个元素大
            if (arr[i-1] > arr[i]){
                //把当前元素存起来
                int temp = arr[i];
                int j;
                for (j=i-1;j>=0&& arr[j]>temp;j--){
                    //每个元素依次向后移动
                    arr[j+1] = arr[j];
                }
                //把临时变量（外层for循环的当前元素）赋值给不满足条件的后一个元素
                arr[j+1] = temp;
            }
        }
    }
}
