package array;

/**
 * @author 小贤
 * @PackageName:array
 * @ClassName:Array
 * @Description:数组数据结构
 * @data 2020/12/24 16:07
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * @return
     * @Author 小贤
     * @Description 构造函数，传入数组的容量capacity构造Array
     * @Date 16:11 2020/12/24
     * @Param [capacity]
     **/
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * @return
     * @Author 小贤
     * @Description 无参构造函数，默认数组的容量capacity=10
     * @Date 16:12 2020/12/24
     * @Param []
     **/
    public Array() {
        this(10);
    }

    /**
     * @return int
     * @Author 小贤
     * @Description 获取数组中的元素个数
     * @Date 16:13 2020/12/24
     * @Param []
     **/
    public int getSize() {
        return this.size;
    }

    /**
     * @return int
     * @Author 小贤
     * @Description 获取数组的容量
     * @Date 16:15 2020/12/24
     * @Param []
     **/
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return boolean
     * @Author 小贤
     * @Description 返回数组是否为空
     * @Date 16:16 2020/12/24
     * @Param []
     **/
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return void
     * @Author 小贤
     * @Description 在index个位置中插入一个新元素e
     * @Date 16:33 2020/12/24
     * @Param [index, e]
     **/
    public void add(int index, int e) {

        if (size == data.length) {
            throw new IllegalArgumentException("add faild.Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild.Require index >=0 and index <= size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * @return void
     * @Author 小贤
     * @Description 向所有元素后添加一个新元素
     * @Date 16:35 2020/12/24
     * @Param [e]
     **/
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * @return void
     * @Author 小贤
     * @Description 向所有元素前添加一个新元素
     * @Date 16:36 2020/12/24
     * @Param [e]
     **/
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * @return int
     * @Author 小贤
     * @Description 获取index索引位置的元素
     * @Date 16:56 2020/12/24
     * @Param [index]
     **/
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get faild.Require index >=0 and index < size");
        }
        return data[index];
    }

    /**
     * @return void
     * @Author 小贤
     * @Description 修改index索引位置的元素为e
     * @Date 16:57 2020/12/24
     * @Param [index, e]
     **/
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set faild.Require index >=0 and index < size");
        }
        data[index] = e;
    }

    /**
     * @return boolean
     * @Author 小贤
     * @Description 查找数组中是否有元素e
     * @Date 17:28 2020/12/24
     * @Param [e]
     **/
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return int
     * @Author 小贤
     * @Description 查找元素e所在的索引，如果不存在元素e，则返回-1
     * @Date 17:30 2020/12/24
     * @Param [e]
     **/
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return int
     * @Author 小贤
     * @Description 删除索引为index的元素，并返回被删除的元素
     * @Date 17:33 2020/12/24
     * @Param [index]
     **/
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set faild.Require index >=0 and index < size");
        }
        int res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    /**
     * @return int
     * @Author 小贤
     * @Description 删除索引为0的元素
     * @Date 17:39 2020/12/24
     * @Param []
     **/
    public int removeFirst() {
        return remove(0);
    }

    /**
     * @return int
     * @Author 小贤
     * @Description 删除数组所有元素的最后一个元素
     * @Date 17:40 2020/12/24
     * @Param []
     **/
    public int removeLast() {
        return remove(size - 1);
    }

    /**
        * @Author 小贤
        * @Description 从数组中删除元素e
        * @Date 17:46 2020/12/24
        * @Param [e]
        * @return void
        **/
    public void removeElement(int e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size is %d , capacity is %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }


    public static void main(String[] args) {
        Array array = new Array();
        for (int i = 0; i < 5; i++) {
            array.addFirst(i);
        }
        array.addLast(100);
        array.add(2, 99);

        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);


        array.removeElement(0);
        System.out.println(array);
    }
}
