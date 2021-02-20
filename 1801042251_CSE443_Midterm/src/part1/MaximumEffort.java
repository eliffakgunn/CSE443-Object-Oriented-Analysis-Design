package part1;

/**
 * Class for MaximumEffort model smartphone
 */
public class MaximumEffort extends Smartphone {
    /**
     * Sets data field of class with appropriate items
     * Thanks to polymorphism it goes proper factory and creates components at runtime
     * @param smartphoneFactory type of factory. It can be Turkey, EU, or Global
     */
    public MaximumEffort(SmartphoneFactory smartphoneFactory){
        name = "MaximumEffort";
        display = "5.5 inches, " + smartphoneFactory.createDisplay();
        battery = "27h, 3600mAh, " + smartphoneFactory.createBattery();
        CPUandRam = "2.8GHz, 8GB, " + smartphoneFactory.createCPUandRAM();
        storage = "MicroSD support, 64GB, " + smartphoneFactory.createStorage();
        camera = "12Mp front, 8Mp rear, " + smartphoneFactory.createCamera();
        Case = "151x73x7.7 mm dustproof, waterproof, aluminum, " +smartphoneFactory.createPhoneCase();
    }
}
