import java.util.Scanner;

/**
*-----------------------------------------------------
* Akdeniz University CSE111 Physics
* Name: Yahya Efe Kurucay
* Date: 18.01.2024  
* Description: 2023 Fall Final Exam Homework Part Question 3
* Score: ?
* Website: https://efekurucay.com
*-----------------------------------------------------
 */
public class CalculateVelocity {
   

static final double g = 9.8;

static double calculateFinalVelocity(double h , double initialVelocityOnYAxis,double mass){

    double vi= initialVelocityOnYAxis;
    double vFinalSquare = (2*g*h)+(vi*vi);
    double vFinal = Math.sqrt(vFinalSquare);
    return vFinal;
}

public static void main(String[] args) {
System.out.println("Enter the height");

Scanner input = new Scanner(System.in);
System.out.println("Welcome to the final velocity calculation program.");
System.out.println("You will be launching an object downward, and we will determine its final velocity just before impact.");
System.out.println("-------------------");
System.out.println("");

System.out.print("Please enter the mass of the object: ");
double mass = input.nextDouble();
System.out.print("Enter the velocity with which you are launching the object: ");
double velocity = input.nextDouble();
System.out.print("Enter the height from which you are launching the object: ");
double height = input.nextDouble();
System.out.println("");
System.out.println("Calculating...");
System.out.println("");

System.out.printf("The final velocity just before impact is %.4f%n", calculateFinalVelocity(height, velocity, mass));

input.close();

}









}
