package part1;

/**
 * Class for Global type smartphone's factory
 * It creates proper components
 */
public class GlobalSmartphoneFactory implements SmartphoneFactory {
    /**
     * Creates 2 cores CPU&Ram
     * @return Returns 2 cores CPU&Ram
     */
    @Override
    public CPUandRam createCPUandRAM() {
        return new core2();
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
     * Creates Lithium-Cobalt battery
     * @return Returns Lithium-Cobalt battery
     */
    @Override
    public Battery createBattery() {
        return new LithiumCobalt();
    }

    /**
     * Creates max 32 GB storage
     * @return Returns max 32 GB storage
     */
    @Override
    public Storage createStorage() {
        return new GB32();
    }

    /**
     * Creates opt. zoom x2 camera
     * @return Returns opt. zoom x2 camera
     */
    @Override
    public Camera createCamera() {
        return new Zoomx2();
    }

    /**
     * Creates waterproof up to 50cm case
     * @return Returns waterproof up to 50cm case
     */
    @Override
    public Case createPhoneCase() {
        return new WProof50cm();
    }
}
