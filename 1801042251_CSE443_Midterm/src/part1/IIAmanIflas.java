package part1;

/**
 * Class for I-I-Aman-Iflas model smartphone
 */
public class IIAmanIflas extends Smartphone {
    /**
     * Sets data field of class with appropriate items
     * Thanks to polymorphism it goes proper factory and creates components at runtime
     * @param smartphoneFactory type of factory. It can be Turkey, EU, or Global
     */
    public IIAmanIflas(SmartphoneFactory smartphoneFactory){
        name = "IIAmanIflas";
        display = "4.5 inches, " + smartphoneFactory.createDisplay();
        battery = "16h, 2000mAh, " + smartphoneFactory.createBattery();
        CPUandRam = "2.2GHz, 4GB, " + smartphoneFactory.createCPUandRAM();
        storage = "MicroSD support, 16GB, " + smartphoneFactory.createStorage();
        camera = "8Mp front, 5Mp rear, " + smartphoneFactory.createCamera();
        Case = "143x69x7.3 mm waterproof, plastic, " +smartphoneFactory.createPhoneCase();
    }
}
