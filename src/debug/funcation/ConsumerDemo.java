package debug.funcation;

import java.util.function.Consumer;

interface SpendMoney{
    void bug(String money);
}

public class ConsumerDemo {
    public static void main(String[] args) {
        // 1. 自己写接口
        SpendMoney sm = new SpendMoney() {
            @Override
            public void bug(String money) {
                System.out.println("我用了"+money+"元，给我女朋友买了戴胜吹风机");
            }
        };
        sm.bug("2999");

        // 2. 使用现成的接口
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String money) {
                System.out.println("我用了"+money+"元，给我女朋友买了洗衣机");
            }
        };
        consumer.accept("5000");

        Consumer<String> lamdba = money -> System.out.println("我用了"+money+"元，给我女朋友买了房");
        lamdba.accept("6000");
    }
}
