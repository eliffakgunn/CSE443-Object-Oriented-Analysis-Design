package part4;

/**
 * Driver class for part4
 */
public class Driver extends Thread{
    private static ProxyDataBaseTableA proxyDataBaseTableA;
    private static ProxyDataBaseTableB proxyDataBaseTableB;
    static int flag = 0;
    static int part_flag = 0;

    public static void main(String[] args) throws InterruptedException {
        DataBaseTable dataBaseTable = new DataBaseTable();
        proxyDataBaseTableA = new ProxyDataBaseTableA(dataBaseTable);
        proxyDataBaseTableB = new ProxyDataBaseTableB(dataBaseTable);

        System.out.println("----------------Testing part a----------------");
        createThread();

        part_flag = 1;

        System.out.println("\n----------------Testing part b----------------");
        createThread();

    }

    static void createThread() throws InterruptedException {
        Driver[] drivers = new Driver[4];

        for (int i=0; i<2; ++i){
            drivers[i] = new Driver();
            drivers[i].start();
        }

        Thread.sleep(2000);
        flag = 1;

        for (int i=2; i<4; ++i){
            drivers[i] = new Driver();
            drivers[i].start();
        }

        try
        {
            for (int i=0; i<4; ++i){
                drivers[i].join();
            }
        }
        catch(Exception e)
        {
            //System.out.println("Interrupted");
        }
    }

    @Override
    public void run(){
        if(flag == 0){
            try {
                if(part_flag == 0)
                    proxyDataBaseTableA.getElementAt(0, 0);
                else
                    proxyDataBaseTableB.getElementAt(0, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                if(part_flag == 0)
                    proxyDataBaseTableA.setElementAt(0, 0, this);
                else
                    proxyDataBaseTableB.setElementAt(0, 0, this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

