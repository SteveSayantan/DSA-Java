import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.print("Enter the radius of the circle : ");
        float rad= in.nextFloat();
        float area=3.14f*rad*rad;
        float circumference=2*3.14f*rad;

        System.out.printf("Area of the circle is %.2f unit and its circumference is %.2f unit",area,circumference);        

    }
}
