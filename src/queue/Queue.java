package queue;

/**
 * Created by XiaoXian on 2020/12/30.
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
