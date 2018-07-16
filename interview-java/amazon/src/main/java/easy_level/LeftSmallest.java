package easy_level;

public class LeftSmallest {


    public static void show(int [] arr){
        if(arr.length == 0 ){
            return;
        }
        int len = arr.length;
        System.out.print("{");
        for(int i = 0;i< len;i++){
            if(i ==0) {
                System.out.print("_,");
                continue;
            }
            if(arr[i-1]<arr[i])
                System.out.print(arr[i-1]+",");
            else
                System.out.print("_,");
        }
        System.out.print("}");
    }

    public static void main(String[] args) {
        int [] arr = {1,3,1,22,31,2};
        show(arr);
    }
}
