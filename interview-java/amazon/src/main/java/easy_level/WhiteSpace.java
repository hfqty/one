package easy_level;

public class WhiteSpace {

    public static void print(String a,String b,int start){
        System.out.println(a+b+start);
        if(start == a.length() - 1){
            System.out.println(a+b+start);
            System.out.println(b+a.charAt(start));
            return;
        }
        print(a,b+a.charAt(start),start+1);
        print(a,b+a.charAt(start)+" ",start+1);
    }

    public static void main(String[]args){
        print("BCDE","",0);
    }
}
