package part1;

public class Driver {
    public static void main(String[] args) {
        System.out.println("------Testing Singleton Class------");
        Singleton singleton = Singleton.getInstance();

        singleton.setVal(1);
        System.out.println("val=" +singleton.getVal());
        try {
            Singleton clone = (Singleton) singleton.clone();
            clone.setVal(3);
            System.out.println("val=" +clone.getVal());
            System.out.println("val=" +singleton.getVal());
        }catch (CloneNotSupportedException exception){
            System.out.println("error");
        }

        System.out.println("\n------Testing SingletonCloneable Class------");
        SingletonCloneable singletonCloneable = SingletonCloneable.getInstance();

        singletonCloneable.setVal(5);
        System.out.println("val=" +singletonCloneable.getVal());
        try {
            SingletonCloneable clone = (SingletonCloneable) singletonCloneable.clone();
            clone.setVal(7);
            System.out.println("val=" +clone.getVal());

        }catch (CloneNotSupportedException exception){
            System.out.println("error");
        }
        
        System.out.println("\n------Testing SingletonThrowsException Class------");
        SingletonThrowsException singletonThrowsException = SingletonThrowsException.getInstance();

        singletonThrowsException.setVal(9);
        System.out.println("val=" +singletonThrowsException.getVal());
        try {
            SingletonThrowsException clone = (SingletonThrowsException) singletonThrowsException.clone();
            clone.setVal(11);
            System.out.println("val=" +clone.getVal());

        }catch (CloneNotSupportedException exception){
            System.out.println("error");
        }        
    }
}
