package part1;

/**
 * Class for production of smartphones
 */
public abstract class Smartphone {
    /**
     * type of model
     */
    String name;
    /**
     * type of display
     */
    String display;
    /**
     * type of battery
     */
    String battery;
    /**
     * type of CPU& Ram
     */
    String CPUandRam;
    /**
     * type of storage
     */
    String storage;
    /**
     * type of camera
     */
    String camera;
    /**
     * type of case
     */
    String Case;

    /**
     * attach cpu & ram to the board
     */
    void attachCPUandRAM() {
        System.out.println("Attaching CPU & Ram (" + CPUandRam + ")");
    }

    /**
     * attach display
     */
    void attachDisplay() {
        System.out.println("Attaching display (" + display + ")");
    }

    /**
     * attach battery
     */
    void attachBattery() {
        System.out.println("Attaching battery (" + battery + ")");
    }

    /**
     * attach storage
     */
    void attachStorage() {
        System.out.println("Attaching storage (" + storage + ")");
    }

    /**
     * attach camera
     */
    void attachCamera() {
        System.out.println("Attaching camera (" + camera + ")");
    }

    /**
     * enclose the phone case
     */
    void enclosePhoneCase() {
        System.out.println("Enclosing the phone case (" + Case + ")");
    }

    /**
     * Gets name of smartphone model
     * @return Returns name of smartphone model
     */
    String getName(){
        return name;
    }

}


