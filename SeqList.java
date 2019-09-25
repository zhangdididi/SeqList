import java.util.Arrays;
//顺序表擅长随机访问
//时间复杂度为O(1) 获取修改指定
//时间复杂度为O(N) 查找插入删除
//时间复杂度为O(1) 尾插尾删
public class SeqList {
    //创建一个类，一般先考虑类支持的操作（分析需求）
    //结合操作来考虑所需要的数据
    //插入之后才是有效元素
    private int[] data = new int[10];//最多容纳10个，无效元素
    // size 表示当前有效元素数量
    private int size = 0;

    //打印方法
    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //pos 表示位置  num 表示数字
    public void add(int pos, int num) {
        if (pos < 0 || pos > size) {
            return;//无效位置
        }
        if (pos == size) {
            this.data[pos] = num;//尾插
            this.size++;
            return;
        }
        if (size >= data.length) {
            //容量不够需要扩容
            realloc();
        }
        // 插入到中间位置，搬运，将后面元素向后挪
        for (int i = size; i > pos; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[pos] = num;
        size++;
    }

    //为顺序表扩容
    private void realloc() {
        //根据实际场景决定具体是线性增长还是指数增长
        //扩容是比较大的开销
        int[] newData = new int[data.length * 2];
        Arrays.copyOf(newData, this.data.length);
        this.data = newData;
    }

    //查找是否存在
    public boolean contains(int toFind) {
        return search(toFind) != -1;
    }

    //查找数字下标
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (toFind == data[i]) {
                return i;
            }
        }
        return -1;
    }

    //获取某个位置的元素
    public int getPos(int pos) {
        return data[pos];
    }

    //改变某个位置的元素
    public void setPos(int pos, int value) {
        data[pos] = value;
    }

    //按值删除
    public void remove(int toRemove) {
        int pos = search(toRemove);
        if (pos == -1) {
            System.out.println("无该值");
            return;
        }
        if (pos == size - 1) {
            size--;
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    //获取顺序表长度
    public int size() {
        return this.size;
    }

    //清空顺序表
    public void clear() {
        this.size = 0;

    }
}
