
public class MiniBank {

    public static void main(String[] args) throws InterruptedException {

        Account account = new SavingsAccount(
                "AC0001", "Riya", 0, 0);

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            AccountWorker worker = new AccountWorker(account, 1000, 1);

            threads[i] = new Thread(worker, "Thread-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
