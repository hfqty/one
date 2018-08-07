package me.ning.annoationn;
@CanDoIt("ok")
public class DoSomething {


    public void doit(String something){
        System.out.println("there are something with :" +something);
    }

    public static void main(String[]args){
        if(DoSomething.class.isAnnotationPresent(CanDoIt.class)) {
            CanDoIt canDoIt = DoSomething.class.getAnnotation(CanDoIt.class);
            System.out.println(canDoIt.value());
        }
    }
}
