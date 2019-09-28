package aareview.stack;

public class Stack {
    //栈顶指针
    int top;
    //栈底指针
    int base;
    int [] data;

    //初始栈的大小
    private int n = 10;

    public Stack(){
        //默认栈空间为10
        this.data = new int[n];
        base = top = 0;
    }
    public Stack(int i){
        this.n = i;
        this.data = new int[n];
        base = top = 0;
    }

    /**
     * 入栈
     */
    public void push(int element){
        //判断是否满     若栈未满
        if (top+1 <= n){
            data[top] = element;
            top++;
        }else {
            throw new IndexOutOfBoundsException("栈满了");
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        //判断是否为空
        if (top != base){
            top--;
            return data[top];
        }else {
            throw new IndexOutOfBoundsException("介系个空栈");
        }
    }

    /**
     * 输出栈
     */
    public void output(){
        for (int i=0;i<top;i++){
            System.out.println(data[i]);
        }
    }
}
