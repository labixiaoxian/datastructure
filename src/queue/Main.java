package queue;

import java.util.Random;

/**
 * @author 小贤
 * @PackageName:queue
 * @ClassName:Main
 * @Description:
 * @data 2021/1/2 13:43
 */
public class Main {

    public static double testQueue(Queue<Integer> queue, int opCount) {
        Random random = new Random();
        long startTime = System.nanoTime();

        //进队
        for (int i = 0 ; i < opCount ; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        //出队
        for (int i = 0 ; i < opCount ; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time is :" + time1 + "s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time is :" + time2 + "s");
    }
}
