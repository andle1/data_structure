package aareview.array;

import java.util.Arrays;

//数组
//查询快，增删慢
public class Array {

    //用于存储数据的数组
    private int[] elements;

    public Array(){
        elements = new int[0];
    }

    /**
     * 获取数组长度
     * @return
     */
    public int size(){
        return elements.length;
    }

    /**
     * 往数组的末尾添加一个元素
     * @param element 要添加的元素
     */
    public void add(int element){
        //创建一个新的数组
        int[] newArr = new int[elements.length+1];
        //把原数组中的元素复制到新数组中
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        //把添加的元素放入新数组中
        newArr[elements.length]=element;
        //替换原数组
        elements=newArr;
    }

    /**
     * 打印所有元素到控制台
     */
    public void show(){
        System.out.println(Arrays.toString(elements));
    }

    /**
     * 删除数组中的元素
     * @param index
     */
    public void delete(int index){
        //判断下标是否越界
        if (index < 0 || index > elements.length-1){
            throw new RuntimeException("下标越界");
        }
        //创建一个新数组，长度为原数组长度-1
        int[] newArr = new int[elements.length-1];
        //复制原数组中除了要删除的那个元素以外的其他元素
        for (int i=0;i<newArr.length;i++){
            //要删除的元素之前的元素
            if (i<index){
                newArr[i]=elements[i];
            }else {
                newArr[i]=elements[i+1];
            }
        }
        //新数组替换旧数组
        elements = newArr;
    }

    /**
     * 获取某个元素
     * @param index
     * @return
     */
    public int get(int index){
        return elements[index];
    }

    /**
     * 插入一个元素到指定位置
     */
    public void insert(int index,int element){
        //只要是传入下标，都应该检查下标范围，否者报错，下标超出范围.
        //创建一个新的数组
        int[] newArr = new int[elements.length+1];
        //将原数组中的元素放在新数组中
        for (int i=0;i<elements.length;i++){
            //目标元素之前的元素
            if (i<index){
                newArr[i] = elements[i];
            }else {
                newArr[i+1] = elements[i];
            }
        }
        //插入的新元素
        newArr[index] = element;
        //替换原数组
        elements = newArr;
    }

    /**
     * 替换指定位置的元素
     * @param index  位置
     * @param element 要替换的元素
     */
    public void set(int index ,int element){
        elements[index] = element;
    }

    /**
     * 线性查找元素位置
     * @param target  目标元素
     * @return   -1代表不存在
     */
    public int listSearch(int target){
        //遍历数组
        for(int i=0;i<elements.length;i++){
            if(elements[i] == target){
                return i;
            }
        }
        //没有就返回 -1
        return -1;
    }

    /**
     *二分查找(前提是有序的)
     * @param target
     * @return 位置
     */
    public int binarySearch(int target){
        //记录开始位置
        int begin = 0;
        //记录结束位置
        int end = elements.length-1;
        //记录中间位置(如果不是整数，向下取整数)
        int mid = (begin+end)/2;

        //循环查找
        while(true){
            //没有这个元素(begin不能等于end，否则找不出最后一位)
            if (begin > end){
                return -1;
            }
            //判断中间的这个元素是不是要查找的元素
            if(elements[mid] == target){
                return mid;
            }else {
                //判断中间元素是不是比目标元素大
                if(elements[mid] > target){
                    //把位置调整到中间位置前面一位
                    end = mid-1;
                }else {
                    begin = mid+1;
                }
                //取出新的中间位置
                mid = (begin+end)/2;
            }
        }
    }

}
