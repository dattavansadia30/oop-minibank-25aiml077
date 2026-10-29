
public class MiniBank {

    public static void main(String[] args) throws InterruptedException {

        TransactionBuffer buffer = new TransactionBuffer();

        Thread producer = new Thread(() -> {
            try {
                buffer.addTransaction(100);
                buffer.addTransaction(200);
                buffer.addTransaction(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    buffer.getTransaction();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("All transactions processed.");
    }
}
