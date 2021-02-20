package part1;

/**
 * Class for store of global to create ordered smartphone
 */
public class GlobalStore extends PhoneStore {
    /**
     * Creates proper smartphone object
     * @param item type of smartphone
     * @return object of ordered type of smartphone
     */
    @Override
    Smartphone createSmartphone(String item) {
        if(item.equals("MaximumEffort")){
            return new MaximumEffort(new GlobalSmartphoneFactory());
        }else if(item.equals("IflasDeluxe")){
            return new IflasDeluxe(new GlobalSmartphoneFactory());
        }else if(item.equals("I-I-Aman-Iflas")){
            return new IIAmanIflas(new GlobalSmartphoneFactory());
        }else{
            return null;
        }
    }
}


