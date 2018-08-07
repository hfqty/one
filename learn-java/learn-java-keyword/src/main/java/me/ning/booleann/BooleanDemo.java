package me.ning.booleann;

public class BooleanDemo {

    public static void main(String []args){
        Boolean a = false;
        byte[] bytes = a.toString().getBytes();
        System.out.println(bytes.length);
        for(int i = 0;i<bytes.length;i++){
            System.out.println(bytes[i]);
        }
    }
}
