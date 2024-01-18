
/**
*-----------------------------------------------------
* Akdeniz University CSE111 Physics
* Name: Yahya Efe Kurucay
* Date: 14.01.2024  
* Description: 2023 Fall Final Exam Homework Part Question 1
* Score: ?
* Website: https://efekurucay.com
*-----------------------------------------------------
 */

 public class Final {
 

    final public static double g = 9.8;

    public static int initialVelocity(String studentNum){
        String initialVelocityString = studentNum.substring(2, 4);
        int initialVelocity =2*Integer.parseInt(initialVelocityString);
        return initialVelocity;
    }
    
    public static int angleWithHorizontal(String studentNum){
        int length = studentNum.length();
        String angleString= studentNum.substring(length-2,length);
        int angle = Integer.parseInt(angleString);

            if(angle<20)return angle+20;
            else return angle;
    }



    public static double calculateTimeOfFlight(String studentNum ){

        double x = Math.toRadians(angleWithHorizontal(studentNum));
        double sin = Math.sin(x);
        return (2*initialVelocity(studentNum)*sin)/g;
    }
     
    public static double calculateMaxHeight(String studentNum ){
        double x = Math.toRadians(angleWithHorizontal(studentNum));
        double sin = Math.sin(x);

        double t =calculateTimeOfFlight(studentNum)/2; // half of flight time

        return (initialVelocity(studentNum)*sin*t)-((g*t*t)/2);
    }
    
    public static double calculateRange( String studentNum){
        double x = Math.toRadians(angleWithHorizontal(studentNum));
        double cos = Math.cos(x);

        double t =calculateTimeOfFlight(studentNum);

        return initialVelocity(studentNum)*cos*t;
    }
    public static void main(String[] args) {
       
       
       
    }

}//class Final

