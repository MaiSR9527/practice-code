import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/3/16 13:18
 * @version: v1.0
 */

public class Test {


    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                Test test = new Test();
//                int id = test.idWorker();
//                System.out.println(id);
//            }, "thread" + i).start();
//        }
        new Thread(()->{
            int worker = new Test().idWorker();
        },"A").start();
    }

    public int idWorker() {
        int id = 0;
        int now = counter.get();
        if (counter.compareAndSet(now, now + 1)) {
            id = counter.get();
        }
        return id;
    }

}
