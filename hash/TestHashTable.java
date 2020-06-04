package hash;

import hash.HashTable;


public class TestHashTable {
    //直接订址法
    public static void main(String[] args){
        StuInfo s1 = new StuInfo(16,3);
        StuInfo s2 = new StuInfo(17,11);
        StuInfo s3 = new StuInfo(18,23);
        StuInfo s4 = new StuInfo(19,24);
        StuInfo s5 = new StuInfo(20,9);

        HashTable hashTable = new HashTable();
        hashTable.put(s1);
        hashTable.put(s2);
        hashTable.put(s3);
        hashTable.put(s4);
        hashTable.put(s5);

        //获取目标数据
        StuInfo stuInfo = new StuInfo(18);
        StuInfo info = hashTable.get(stuInfo);
        System.out.println(info);
    }
}
