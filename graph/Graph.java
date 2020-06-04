package graph;

import java.util.Stack;

//图   这里是无向图
public class Graph {
    //存的都是顶点
    Vertex[] vertices;
    int currentSize;//代表的是当前这个数组存了多少元素

    //临接矩阵。用于存储顶点的关系
    int[][] adjMat;

    public Graph(){};

    public Graph(int size){
        vertices = new Vertex[size];
        adjMat = new int[size][size];
        //自己和自己是不通的
        for (int i=0;i<size;i++){
            adjMat[i][i] = 1;
        }
    }


    /**
     * 创建一个图
     * @param data  数组
     */
    public void createGraph(String[] data){
        //根据数组长度创建数组
        vertices = new Vertex[data.length];
        adjMat = new int[data.length][data.length];
        //自己和自己是不通的
        for (int i=0;i<data.length;i++){
            adjMat[i][i] = 1;
        }
        //放入顶点数组中
        for (String i:data){
            Vertex v = new Vertex(i);
            addVertex(v);
        }
    }

    /**
     * 图中添加顶点
     * @param x
     */
    public void addVertex(Vertex x){
        //存顶点的数组已经满了
        int i = currentSize;
        if (i++ > vertices.length){
            throw new IndexOutOfBoundsException("满了满了!!!");
        }
        vertices[currentSize] = x;
        currentSize++;
    }

    /**
     * 更改两个顶点的连接状态
     * @param v1
     * @param v2
     */
    public void addEdge(String v1,String v2){
        //找出两个顶点的下标
        int index1=0;//java局部变量必须要默认值
        for (int i=0;i<vertices.length;i++){
            if (vertices[i].value.equals(v1)){
                index1 = i;
                break;
            }
        }

        int index2=0;//java局部变量必须要默认值
        for (int i=0;i<vertices.length;i++){
            if (vertices[i].value.equals(v2)){
                index2 = i;
                break;
            }
        }
        //更改顶点之间状态值
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }

    /**
     * 返回临接矩阵中的某一行未被访问过的顶点
     * @param v  行号
     * @return  这一行中第一个未被访问过的节点的下标
     */
    public int getAdjUnvisitedVertex(int v){
        for (int i=0;i<vertices.length;i++){
            if (adjMat[v][i] == 1 && vertices[i].visted == false){
                return i;
            }
        }
        return -1;
    }


    /**
     * 深度优先搜索
     */
    public void dsf(){
        //用于存储下标的栈
        Stack<Integer> stack = new Stack<>();
        //默认从第一个顶点开始，把它置为访问过状态
        vertices[0].visted = true;
        System.out.println(vertices[0].value);
        //入栈，存的是下标
        stack.push(0);
        while ( !stack.isEmpty()){
            //这里注意，是先查看，再决定出不出栈
            int v = getAdjUnvisitedVertex(stack.peek());
            //没有这个顶点
            if( v== -1){
                //退回上一层
                stack.pop();
            }else {
                //标记为访问过
                vertices[v].visted = true;
                System.out.println(vertices[v].value);
                //入栈
                stack.push(v);
            }
        }
        //重置所有访问标志
        for (int j=0;j<vertices.length;j++){
            vertices[j].visted = false;
        }
    }
}
