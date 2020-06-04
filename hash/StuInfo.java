package hash;

public class StuInfo {
    private int age;
    private int count;

    public StuInfo(int age, int count) {
        this.age = age;
        this.count = count;
    }

    /**
     * 散列函数
     * @return
     */
    public int hashCode(){
        return age;
    }

    public StuInfo(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
