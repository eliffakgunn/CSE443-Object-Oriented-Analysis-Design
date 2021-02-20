package part2;

/**
 * Interface for modern payment
 */
public interface ModernPayment {
    /**
     * This method pays with modern payment method
     * @param cardNo card no
     * @param amount amount of money
     * @param destination destination account
     * @param installments installments
     * @return Returns 0 if payment is successful
     */
    int pay(String cardNo, float amount, String destination, String installments);
}
