package part1;

/**
 * Class for store of EU to create ordered smartphone
 */
public class EUStore extends PhoneStore {
    /**
     * Creates proper smartphone object
     * @param item type of smartphone
     * @return object of ordered type of smartphone
     */
    @Override
    Smartphone createSmartphone(String item) {
        if(item.equals("MaximumEffort")){
            return new MaximumEffort(new EUSmartphoneFactory());
        }else if(item.equals("IflasDeluxe")){
            return new IflasDeluxe(new EUSmartphoneFactory());
        }else if(item.equals("I-I-Aman-Iflas")){
            return new IIAmanIflas(new EUSmartphoneFactory());
        }else{
            return null;
        }
    }
}

