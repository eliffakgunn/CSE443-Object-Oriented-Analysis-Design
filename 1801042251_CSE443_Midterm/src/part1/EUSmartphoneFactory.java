package part1;

/**
 * Class for EU type smartphone's factory
 * It creates proper components
 */
public class EUSmartphoneFactory implements SmartphoneFactory {
    /**
     * Creates 4 cores CPU&Ram
     * @return Returns 4 cores CPU&Ram
     */
    @Override
    public CPUandRam createCPUandRAM() { 
        return new core4();
    }
    
    /**
     * Creates 24 bit display
     * @return Returns 24 bit display
     */
    @Override
    public Display createDisplay() {
        return new Bit24();
    }

    /**
     * Creates Lithium-Ion battery
     * @return Returns Lithium-Ion battery
     */
    @Override
    public Battery createBattery() { 
        return new LithiumIon();
    }

    /**
     * Creates max 64 GB storage
     * @return Returns max 64 GB storage
     */
    @Override
    public Storage createStorage() { 
        return new GB64();
    }

    /**
     * Creates opt. zoom x3 camera
     * @return Returns opt. zoom x3 camera
     */
    @Override
    public Camera createCamera() { 
        return new Zoomx3();
    }

    /**
     * Creates waterproof up to 1m case
     * @return Returns waterproof up to 1m case
     */
    @Override
    public Case createPhoneCase() {
        return new WProof1m();
    }
}


