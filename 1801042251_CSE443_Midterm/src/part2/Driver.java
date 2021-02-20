package part2;

/**
 * Driver class for part2
 */
public class Driver {
    public static void main(String[] args) {
        ConcreteModernPayment concreteModernPayment = new ConcreteModernPayment();
        ConcreteTurboPayment concreteTurboPayment = new ConcreteTurboPayment();
        TurboPayment turboPaymentAdapter = new ModernPaymentAdapter(concreteModernPayment);

        System.out.println("--------Modern Payment Behaviour--------");
        concreteModernPayment.pay("0000000000", 1000, "1111111111", "Yes");
        System.out.println();

        System.out.println("--------Turbo Payment Behaviour--------");
        concreteTurboPayment.payInTurbo("2222222222", 2000, "3333333333", "Yes");
        System.out.println();

        System.out.println("--------Turbo Payment Adapter Behaviour--------");
        turboPaymentAdapter.payInTurbo("4444444444", 3000, "5555555555", "Yes");
        System.out.println();
    }
}
