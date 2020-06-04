package sort;

import java.util.Arrays;


//希尔排序 (插入排序)

//原理：利用步长分组，再进行直接插入排序。
public class ShellSort {
    public static void main(String[] args){
        int[] arr = new int[]{5,6,7,2,4,9,2};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        //按照步长值进行分组(逻辑上的分组)
        for (int gap=arr.length/2;gap>0;gap/=2){
            //遍历所有元素(每一组都是从末尾开始的从末尾开始的）
            for (int i=gap;i<arr.length;i++){
                //将arr[i]插入正确的位置
                insertI(arr,gap,i);
            }
        }
    }

    private static void insertI(int[] arr, int gap, int i) {
        int temp = arr[i];
        int j;
        //插入的时候，组内两个元素之间相隔gap
        for (j=i-gap;j>=0&&arr[j]>temp;j-=gap){
            arr[j+gap] = arr[j];
        }
        arr[j+gap] = temp;
    }

    //用冒泡的思想去实现(不过是从后往前冒泡)
    public static void shellSort2(int[] arr){
        //遍历所有的步长
        for(int tag=arr.length/2;tag>0;tag/=2){
            //遍历所有元素(初始值为d 是因为遍历的次数是减去步长以后的次数）
            for(int i=tag;i<arr.length;i++){
                //从每一组元素的第一个元素开始遍历本组所有元素
                for (int j=i-tag;j>=0;j-=tag){
                    //当前元素大于加上步长以后的那个元素
                    if(arr[j]>arr[j+tag]){
                        int temp=arr[j];
                        arr[j] = arr[j+tag];
                        arr[j+tag] = temp;
                    }
                }
            }
        }
    }
}
