package list.doubleLinkedList;

//双向链表
//特点：一个指向前一个节点，一个指向后一个节点。尾节点指向头节点，头节点指向尾节点
public class DoubleList {
    //头节点
    public Node head;
    //尾节点
    public Node last;
    //链表实际长度
    public int size;

    /**
     * 链表插入元素
     * @param data
     * @param index
     */
    public void insert(int data,int index){
        if (index <0 || index >size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node inNode = new Node(data);
        if (size == 0){
            //空链表
            head = inNode;
            last = inNode;

            head.pre = last;
            last.next = head;
        }else if (index == 0){
            //插入头部
            inNode.next = head;
            //未改变头节点之前的头节点的指向
            head.pre = inNode;
            head = inNode;
            head.pre = last;
        }else if(index == size){
            //插入尾部
            last.next = inNode;
            inNode.pre = last;
            last = inNode;
            last.next = head;
        }else {
            //插入中间
            Node preNode = get(index - 1);
            inNode.next = preNode.next;//当前节点的前后节点
            inNode.pre = preNode;
            preNode.next.pre = inNode;
            preNode.next = inNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     * @param index
     * @return
     */
    public Node remove(int index){
        if (index <0 || index>=size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node removeNode = null;
        if (index == 0){
            //删除头节点
            removeNode = head;
            head = head.next;
            head.pre = last;
        }else if (index == size-1){
            //删除尾节点
            Node preNode = get(index-1);
            removeNode = preNode.next;
            preNode.next = null;
            last = preNode;
            last.next = head;
        }else{
            //删除中间节点
            Node preNode = get(index-1);
            Node nextNode = preNode.next.next;
            removeNode = preNode.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }
        size --;
        return removeNode;
    }

    /**
     * 链表查找元素
     * @param index
     * @return
     */
    public Node get(int index){
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output(){
        Node temp = head;
        //直接用大小去循环
        for (int i=0;i<size;i++){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
