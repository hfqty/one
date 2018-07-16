package easy_level;

public class TwoRactangleIsOverlap {

    public static boolean check(int [] l1,int [] r1,int [] l2,int []r2){
        if(l1[0] > r2[0] || r1[0]>l2[0]){
            return false;
        }
        if(r1[1]>l2[1] || l1[1]<r2[1]){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int [] l1 = {10,20};
        int [] r1 = {5,10};
        int [] l2 = {30,10};
        int [] r2 = {20,20};
        System.out.println(check(l1,r1,l2,r2)?"是":"否");
    }
}
