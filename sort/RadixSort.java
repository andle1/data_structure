package sort;


import queue.Queue;

import java.util.Arrays;

//基数排序   按照位数，先排各位，分别放入不同的数组，再取出来，再排十位
public class RadixSort {
    public static void main(String[] args){
        int[] arr = new int[]{23,4,167,33,8,344,65,908,3,6,16};
        radixSort(arr);
        //radixQueueSortA(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //存数组中最大的元素
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }

        //二维数组，用来存储值
        int[][] temp = new int[10][arr.length];
        //用于记录不同余数所存放的数量
        int[] counts = new int[10];
        //由最大值获得位数，也就知道了比较多少轮
        int maxLength = String.valueOf(max).length();
        //从个位开始存值
        for (int j=0,n=1;j<maxLength;j++,n*=10){
            //存一次
            for (int k=0;k<arr.length;k++){
                //%10是取余数, arr[k]/n 代表每次的位数
                int ys = arr[k]/n %10;
                temp[ys][counts[ys]] = arr[k];
                //代表的某个余数对于的元素个数
                counts[ys]++;
            }
            int index = 0;
            //取一次
            for (int i=0;i<counts.length;i++){
                if (counts[i] != 0){
                    //取出对应的余数的所有元素
                    for (int l=0;l<counts[i];l++){
                        arr[index] = temp[i][l];
                        index++;
                    }
                    //把数量置为0(下一次他需要记录的是其他位的个数)
                    counts[i]=0;
                }
            }
        }
    }

    /**
     * 用队列实现基数排序
     */
    public static void radixQueueSortA(int[] arr){
        //存数组中最大的数(这里定义为最小的整数)
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        //计算最大数字是几位数(加上空字符串变为字符串，求长度！！！）
        //int maxLength = (max+"").length();
        int maxLength = String.valueOf(max).length();

        //用于临时存储数据的队列数组
        Queue[] temp = new Queue[10];
        //为队列数组赋值
        for (int i=0;i<temp.length;i++){
            temp[i] = new Queue();
        }
        //根据最大长度的数决定比较的轮数,n是用来取个十百位的值
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //分别计算每一个数字的余数
            for(int j=0;j<arr.length;j++){
                int ys = arr[j]/n%10;
                //把当前的数字放入指定的数组中（这里的counts[ys]代表余数为ys的数组里面有几个数，开始是0）
                temp[ys].enQueue(arr[j]);
            }
            //记录取的元素需要放的位置
            int index = 0;
            //把所有队列中的数字取出来
            for(int k=0;k<temp.length;k++){
                //记录数量的队列中当期余数记录的数量不为0
                // 这里的 isEmpty 还未实现
                while (!temp[k].isEmpty()){
                    arr[index] = temp[k].deQueue();
                    index++;
                }
            }
        }
    }
}
