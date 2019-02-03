package HW5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 *
 * Java home work 5 lesson
 * @author Alexey Denisov
 * @version dated Feb 03, 2019
 */

public class HomeWork5 {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {

        CountDownLatch startLatch = new CountDownLatch(CARS_COUNT + 1);
        Semaphore tunnelSemaphore = new Semaphore(CARS_COUNT/2, true);
        CyclicBarrier finishBarrier = new CyclicBarrier(CARS_COUNT + 1);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), startLatch, tunnelSemaphore, finishBarrier);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            while (startLatch.getCount() > 1) {
                Thread.sleep(100);
            }
            startLatch.countDown();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            finishBarrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
        catch (InterruptedException | BrokenBarrierException ex) {
            ex.printStackTrace();
        }
    }
}
