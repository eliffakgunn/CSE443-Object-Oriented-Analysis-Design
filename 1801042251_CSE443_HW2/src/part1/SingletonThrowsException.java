package part1;

public class SingletonThrowsException implements Cloneable {
    private static SingletonThrowsException uniqueInstance;
    private int val;

    private  SingletonThrowsException() {}

    public static SingletonThrowsException getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new SingletonThrowsException();
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
        throw new CloneNotSupportedException("Clone can not created.");
    }
}
