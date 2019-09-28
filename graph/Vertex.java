package aareview.graph;

//顶点
public class Vertex {
    String value;

    //是否被遍历。默认是false
    boolean visted = false;

    public Vertex(String value){
        this.value = value;
    }


}
