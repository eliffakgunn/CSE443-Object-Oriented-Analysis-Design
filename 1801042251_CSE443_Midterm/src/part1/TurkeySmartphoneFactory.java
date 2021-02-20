package part1;

/**
 * Class for Turkey type smartphone's factory
 * It creates proper components
 */
public class TurkeySmartphoneFactory implements SmartphoneFactory {
    /**
     * Creates 8 cores CPU&Ram
     * @return Returns 8 cores CPU&Ram
     */
    @Override
    public CPUandRam createCPUandRAM() {
        return new core8();
    }

    /**
     * Creates 32 bit display
     * @return Returns 32 bit display
     */
    @Override
    public Display createDisplay() {
        return new Bit32();
    }

    /**
     * Creates Lithium-Boron battery
     * @return Returns Lithium-Boron battery
     */
    @Override
    public Battery createBattery() {
        return new LithiumBoron();
    }

    /**
     * Creates max 128 GB storage
     * @return Returns max 128 GB storage
     */
    @Override
    public Storage createStorage() {
        return new GB128();
    }

    /**
     * Creates opt. zoom x4 camera
     * @return Returns opt. zoom x4 camera
     */
    @Override
    public Camera createCamera() {
        return new Zoomx4();
    }

    /**
     * Creates waterproof up to 2m case
     * @return Returns waterproof up to 2m case
     */
    @Override
    public Case createPhoneCase() {
        return new WProof2m();
    }

}
