package easy_level;

import java.sql.SQLOutput;

public class CheckIfPointFormSquare {


    public static void main(String[]args){
        Point p1 = new Point(20,10);
        Point p2 = new Point(10,20);
        Point p3 = new Point(20,20);
        Point p4 = new Point(10,10);
        System.out.println(isSuuare(p1,p2,p3,p4));

        Point a = new Point(10,20);
        Point b = new Point(10,10);
        Point c = new Point(50,10);
        Point d = new Point(50,20);
        System.out.println(isSuuare(a,b,c,d));




    }




    private static boolean isSuuare(Point a,Point b,Point c,Point d){
        boolean a_b = fallOnSameSide(a,b);
        boolean a_c = fallOnSameSide(a,c);
        boolean a_d = fallOnSameSide(a,d);
        if(a_b){
            return isSquareUtil(a,b,c,d);
        }
        else if(a_c){
            return isSquareUtil(a,c,b,d);
        }
        else if(a_d){
            return isSquareUtil(a,d,b,c);
        }else{
            return false;
        }
    }
    private static boolean isSquareUtil(Point a,Point b,Point c,Point d){
        if(fallOnSameSide(c,d)){
            int x_diff = Math.abs(a.x-c.x);
            int y_diff_left = Math.abs(b.y - a.y);
            int y_diff_right = Math.abs(d.y-c.y);
            return x_diff == y_diff_left&& x_diff == y_diff_right;

        }
        return false;
    }

    private static boolean fallOnSameSide(Point p1,Point p2){
        return p1.x == p2.x && p1.y != p2.y;
    }


}
class Point{
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}