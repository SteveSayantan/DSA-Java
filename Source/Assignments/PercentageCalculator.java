import java.util.Scanner;

public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int subject,totalMarks;
        float sum=0.0f,percentage;
        System.out.println("Enter the number of Subjects: ");
        subject= in.nextInt();

        System.out.println("Enter the total marks of each subject: ");
        totalMarks= in.nextInt();
        
        if(subject<=0||totalMarks<=0) {
            System.out.println("Invalid Input");
            return;
        }

        System.out.print("Enter the number obtained in each subject: ");
        for (int i = 0; i <subject; i++) {
            sum+=in.nextFloat();
        }
        percentage= sum*100/(totalMarks*subject);
    
        System.out.println();
        System.out.println("Obtained Percentage: "+percentage);


    }
}
