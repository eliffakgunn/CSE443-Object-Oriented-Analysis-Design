package part1;

/**
 * Driver class for part1
 */
public class Driver {
    public static void main(String[] args) {
        PhoneStore turkeyStore = new TurkeyStore();
        PhoneStore euStore = new EUStore();
        PhoneStore globalStore = new GlobalStore();

        System.out.println("\n------------Production in Turkey------------");
        orderPhone(turkeyStore, "MaximumEffort");
        orderPhone(turkeyStore, "IflasDeluxe");
        orderPhone(turkeyStore, "I-I-Aman-Iflas");

        System.out.println("\n------------Production in EU------------");
        orderPhone(euStore, "MaximumEffort");
        orderPhone(euStore, "IflasDeluxe");
        orderPhone(euStore, "I-I-Aman-Iflas");

        System.out.println("\n------------Production in Global------------");
        orderPhone(globalStore, "MaximumEffort");
        orderPhone(globalStore, "IflasDeluxe");
        orderPhone(globalStore, "I-I-Aman-Iflas");
    }

    private static void orderPhone(PhoneStore mdl, String type){
        Smartphone model = mdl.orderSmartphone(type);
        System.out.println(model.getName() + " was produced.\n");
    }
}




