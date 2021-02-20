package part1;

/**
 * Class for IflasDeluxe model smartphone
 */
public class IflasDeluxe extends Smartphone {
    /**
     * Sets data field of class with appropriate items
     * Thanks to polymorphism it goes proper factory and creates components at runtime
     * @param smartphoneFactory type of factory. It can be Turkey, EU, or Global
     */
    public IflasDeluxe(SmartphoneFactory smartphoneFactory){
        name = "IflasDeluxe";
        display = "5.3 inches, " + smartphoneFactory.createDisplay();
        battery = "20h, 2800mAh, " + smartphoneFactory.createBattery();
        CPUandRam = "2.2GHz, 6GB, " + smartphoneFactory.createCPUandRAM();
        storage = "MicroSD support, 32GB, " + smartphoneFactory.createStorage();
        camera = "12Mp front, 5Mp rear, " + smartphoneFactory.createCamera();
        Case = "149x73x7.7 mm waterproof, aluminum, " +smartphoneFactory.createPhoneCase();
    }
}
