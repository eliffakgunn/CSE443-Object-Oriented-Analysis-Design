package part1;

public class Singleton {
    private static Singleton uniqueInstance;
    private int val;

    private  Singleton() {}

    public static Singleton getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Singleton();
        return uniqueInstance;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        //return uniqueInstance;
    }
}
