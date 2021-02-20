package part1;

public class SingletonCloneable implements Cloneable {
    private static SingletonCloneable uniqueInstance;
    private int val;

    private  SingletonCloneable() {}

    public static SingletonCloneable getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new SingletonCloneable();
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
    }
}
