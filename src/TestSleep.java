public class TestSleep{
    //模拟倒计时
    //每一个对象都有一个锁，sleep不会释放锁
    public static void main(String[] args) {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tenDown() throws InterruptedException{
        int num = 10;
        while(true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if(num <= 0) {
                break;
            }
        }
    }

}
