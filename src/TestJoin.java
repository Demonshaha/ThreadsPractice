//join 合并线程，等待此线程执行完成后，再执行其他线程，其他线程阻塞
//可以想象成插队
public class TestJoin implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);//不加这句的话一开始会一起跑，所以这一个线程可能已经执行完了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        //主线程
        for (int i = 0; i < 1000; i++) {
            if(i == 200) {
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
