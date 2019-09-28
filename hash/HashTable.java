package aareview.hash;

import hash.StuInfo;

public class HashTable {
    //这里数组的长度根据实际需要调整
    private StuInfo[] data = new StuInfo[100];

    /**
     * 存储元素
     * @param stuInfo
     */
    public void put(StuInfo stuInfo){
        //调用散列函数，获取存储位置
        int index = stuInfo.hashCode();

        data[index] = stuInfo;
    }

    /**
     * 取出 元素
     * @param stuInfo
     * @return
     */
    public StuInfo get(StuInfo stuInfo){
        return data[stuInfo.hashCode()];
    }

}
