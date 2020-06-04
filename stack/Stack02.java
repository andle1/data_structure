package stack;

//仅仅单纯用数组实现的栈
public class Stack02 {

    //栈的底层用数组来存储数据
    int [] elements;

    public Stack02(){
        elements = new int[0];
    }

    /**
     * 压入元素
     * @param element 要添加的元素
     */
    public void push(int element){
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
     * 取出栈顶元素
     */
    public int pop(){
        if(elements.length == 0){
            throw new RuntimeException("栈为空");
        }
        //取出数组的最后一个元素
        int element = elements[elements.length-1];
        //创建一个新的数组
        int[] newArr = new int[elements.length-1];
        //把原数组中除了最后一个元素的其他元素都放入新的数组中
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        //替换数组
        elements=newArr;
        //返回栈顶元素
        return element;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek(){
        return elements[elements.length-1];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return elements.length == 0;
    }
}