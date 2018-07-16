package chapter03_stream.section03;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {

    public void collectTest01(){
        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(collected);
    }


    public static void main(String []args){
        CollectDemo collectDemo = new CollectDemo();
        collectDemo.collectTest01();
    }
}
