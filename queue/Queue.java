package queue;


import array.Array;

import java.util.ArrayList;

//队列
//这里用的是数组是实现。也可用链表实现
public class Queue {
    int[] data;
    //队头指针,指向第一个出队
    int front;
    //队尾指针，指向入队元素。注意队尾指针一直空 1.所以队列最大容量比数字小1
    int rear;

    //初始队列的大小
    private int n = 10;
    public Queue(){
        this.data = new int[n];
    }
    public Queue(int i){
        this.n = i;
        this.data = new int[n];
    }

    /**
     * 入队
     * @param element
     */
    public void enQueue(int element){
        //这里相等的时候表示 队尾已经走完了数组的长度并且重新第二轮添加元素
        //这里注意，事实上多用了 1 位，因为结束和判断的时候都 模了一次，目的是判别满的状态
        if ((rear+1)%n == front){
            throw new RuntimeException("队列已满");
        }
        data[rear] = element;
        //这里是把位置加 1的作用。并且在到达数组最大的时候，把下标重新置为0.
        rear = (rear+1)%n;
    }

    /**
     * 出队
     * @return
     */
    public int deQueue(){
        if (rear == front){
            throw new RuntimeException("队列已空!");
        }
        int deEmelent = data[front];
        front = (front+1)%n;
        return deEmelent;
    }

    /**
     * 输出队列
     */
    public void output(){
        for (int i=front;i!=rear;i=(i+1)%n){
            System.out.println(data[i]);
        }
    }

    // 这里队列还没有实现
    public boolean isEmpty() {
        return true;
    }
}
