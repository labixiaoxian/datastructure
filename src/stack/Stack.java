package stack;

/**
 * Created by XiaoXian on 2020/12/25.
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
