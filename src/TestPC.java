public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }
    //produce
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + container.pop().id + "只鸡");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    public synchronized void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者消费
        if(count == chickens.length) {
            //通知生产者消费, 生产等待
        }

        //如果没有满就丢入产品
        chickens[count] = chicken;
        count++;

        //可以通知消费了
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            //等待生产者生产，消费者等待
        }

        count--;
        Chicken chicken = chickens[count];

        //吃完了通知可以生产了

        return chicken;
    }
}