/**
 * Java home work 4 (task1)
 * @author Alexey Denisov
 * @version dated Feb 03, 2019
 */


public class HomeWork4 {
    private static Object abc = new Object();
    private static volatile char currentLetter = 'A';
    private static int quantity = 5;

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            int count = 0;
            synchronized (abc) {
                while (true) {
                    if(currentLetter != 'A') {
                        try {
                            abc.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.print(currentLetter);
                        currentLetter = 'B';
                        count++;
                        abc.notifyAll();
                        if(count == quantity) break;
                    }

                }
            }
        });
        Thread thread1 = new Thread(() -> {
            int count = 0;
            synchronized (abc) {
                while (true){
                    if(currentLetter != 'B') {
                        try {
                            abc.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.print(currentLetter);
                        currentLetter = 'C';
                        count++;
                        abc.notifyAll();
                        if(count == quantity) break;
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            int count = 0;
            synchronized (abc) {
                while (true){
                    if(currentLetter != 'C') {
                        try {
                            abc.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.print(currentLetter);
                        currentLetter = 'A';
                        count++;
                        abc.notifyAll();
                        if(count == quantity) break;
                    }
                }
            }
        });
        thread.start();
        thread1.start();
        thread2.start();
    }
}
