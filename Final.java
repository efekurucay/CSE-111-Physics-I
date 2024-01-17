
/**
*-----------------------------------------------------
* Akdeniz University CSE 111 Physics
* Name: Yahya Efe Kurucay
* Date: 17.01.2024
* Description: 2023 Fall Final Exam Homework Part
* Score: ?
* Website: https://efekurucay.com
*-----------------------------------------------------
 * Final
 * Initial Velocity --> 20220808005  3 ve 4. rakamın değerinin 2 katı 22*2= 44.
 * Angle with horizontal axis --> 20220808005 son iki basamağı - Eğer 20 den küçükse 20 eklenecek.
 * g = 9,8 m/s^2 
 * Hareket yörüngesini çiz.
 * Uçuş süresi- time of flight
 * Maksimum yükseklik - the maximum height
 * Mermi hareketinin menzili - range of the projectile motion
 * 
 * Fizik 1 den başka bir konuda problem çöz.
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

        double t =calculateTimeOfFlight(studentNum);

        return (initialVelocity(studentNum)*sin*t)-((g*t*t)/2);
    }
    
    public static double calculateRange( String studentNum){
        double x = Math.toRadians(angleWithHorizontal(studentNum));
        double cos = Math.cos(x);

        double t =calculateTimeOfFlight(studentNum);

        return initialVelocity(studentNum)*cos*t;
    }
    public static void main(String[] args) {
        System.out.println(initialVelocity("20220808005"));
       
       
    }

}//class Final

