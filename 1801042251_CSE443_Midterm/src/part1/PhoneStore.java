package part1;

/**
 * Class for stores of smartphone
 */
public abstract class PhoneStore {
    /**
     * Creates proper smartphone object and produces model
     * @param type type of smartphone
     * @return proper smartphone object
     */
    public Smartphone orderSmartphone(String type) {
        Smartphone smartphone = createSmartphone(type);
        smartphone.attachCPUandRAM();
        smartphone.attachDisplay();
        smartphone.attachBattery();
        smartphone.attachStorage();
        smartphone.attachCamera();
        smartphone.enclosePhoneCase();

        return smartphone;
    }

    /**
     * Createse proper smartphone object
     * @param item type of smartphone
     * @return proper smartphone object
     */
    abstract Smartphone createSmartphone(String item);
}

