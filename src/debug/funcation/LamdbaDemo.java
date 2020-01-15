package debug.funcation;

interface HelloService{
    void sayHello();
}

class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}

/////////////////////////////////////////////////////////////////////////

interface OneService{
    void sayNum(int x);
}

interface  TwoService{
    String sayNum(int x, int y);
}

public class LamdbaDemo {
    public static void main(String[] args) {
        // 1. 直接实现类
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHello();

        //2. 匿名内部类
        HelloService niMingHello = new HelloService() {
            @Override
            public void sayHello() {
                System.out.println("匿名说 hello");
            }
        };
        niMingHello.sayHello();

        // 3. 函数式编程
        // Lamdba 本质就是一个接口的一个实例
        HelloService functionHello = ()->{
            System.out.println("函数式 hello");
        };
        functionHello.sayHello();

        // 4. 有一个参数的情况
        // 4.1 int可以省略，会进行类型推断
        // 4.2 只有一个参数的情况下 参数括号也可以省略 花括号也省略
        OneService functionService = (int num)->{
            System.out.println(num);
        };
        functionService.sayNum(12);

        // 5.两个参数的情况
        // 返回值 只有一句话时 return 和 {} 都可以省略
        TwoService twoService = (one,two)->{
//            System.out.println(one+"\t"+two);
            return "我是两个参数的返回值";
        };
        System.out.println(twoService.sayNum(36,27));
    }
}
