package me.ning.annoationn;

public class AnnoationDemo {

    public static void main(String[]args){
        DoSomething doSomething = new DoSomething();
        boolean has = DoSomething.class.isAnnotationPresent(CanDoIt.class);
        if(doSomething.getClass().getAnnotations().length>0){
            CanDoIt canDoIt = DoSomething.class.getAnnotation(CanDoIt.class);
               if(has){
                   doSomething.doit("coding   "+canDoIt.value());
               }
            }

        }


    }
