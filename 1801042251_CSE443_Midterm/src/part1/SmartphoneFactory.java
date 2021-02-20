package part1;

/**
 * Interface for factories
 */
public interface SmartphoneFactory {
    /**
     * Creates proper CPU&Ram
     * @return Returns proper CPU&Ram
     */
    CPUandRam createCPUandRAM();
    /**
     * Creates proper display
     * @return Returns proper display
     */
    Display createDisplay();
    /**
     * Creates proper battery
     * @return Returns proper battery
     */
    Battery createBattery();
    /**
     * Creates proper storage
     * @return Returns proper storage
     */
    Storage createStorage();
    /**
     * Creates proper camera
     * @return Returns proper camera
     */
    Camera createCamera();
    /**
     * Creates proper case
     * @return Returns proper case
     */
    Case createPhoneCase();
}


