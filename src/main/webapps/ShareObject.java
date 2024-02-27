package main.webapps;

public class ShareObject {
    private int count;
    private String str;

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ShareObject{" +
                "count=" + count +
                ", str='" + str + '\'' +
                '}';
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
