package chapter03_stream.section03;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ReduceDemo {

    public void useStream(){
        int count = Stream.of(1,2,3).reduce(0,(acc,element) -> acc + element);
        assertEquals(6,count);
    }

    public void useCommand(){
        int acc = 0;
        for(Integer element : Arrays.asList(1,2,3)){
            acc =  acc+ element;
        }
        assertEquals(6,acc);
    }

    public void expandStream(){
        BinaryOperator<Integer> accumulator  = (acc,element) -> acc+element;
        int count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0,1),
                2),3);
        assertEquals(6,count);
    }

    public static void main(String[]args){
        ReduceDemo reduceDemo = new ReduceDemo();
        reduceDemo.useStream();
        reduceDemo.expandStream();
        reduceDemo.useCommand();
    }
}
