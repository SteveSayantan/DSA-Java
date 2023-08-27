public class TypeCasting {
    public static void main(String[] args) {
        /*

        For automatic type conversion
        1. The two types should be compatible e.g. char/string --> float conversion not possible
        2. The destination type should be greater than the source type e.g. int can automatically be converted to float but the vice-versa is not possible (as float>int) 

        */
        int letter= 'A';
        System.out.println(letter);//65, the ASCII value


        
        //TypeCasting is when we explicitly do the type conversion ourselves i.e. compressing the bigger type in a smaller one  

        int num= (int)(45.235f);
        System.out.println(num); //45
        
        int a = 259;
        byte b=(byte)(a); //byte can store upto 256. As it exceeds the range while typecasting (as we are giving 259 i.e. >256)
        System.out.println(b); //259%256 =3 is stored in b;


        //Automatic Type promotion in expressions

        byte num1=40;
        byte num2=50;
        byte num3=100;
        int num4= num1*num2/num3 ; //40*50 gives 2000 which exceeds the range of byte, to solve this Java automatically promotes num1 and num2 to integers. 
        System.out.println(num4);

        //When bytes are used in a calculation, they are promoted to integers.
       // byte val= num1*3 this gives error as num1*3 is converted to an int which can not be stored in a byte, unless we explicitly do typecasting.

       /*
        * Rules for Automatic Type Promotion

        1. In a calculation, all the byte,short,char are always promoted to int.
        2. If any of the values involved is long, the whole calculation gives a long. In case of a float/double, the whole calculation gives float/double (i.e. to the biggest datatype) 

        */

        /**
         * Example1:
         * 
         *  (float*byte)+(int/char)-(double*short)
         *  = float + int + double
         *  = double (as it is the biggest datatype among them)
         * 
         * Example2:
         * 
         * float a = 7/4; // 1.0 (As 7 and 4 both are integers and int/int= int. Therefore, the int value of the actual result(1.75) is stored in a,after getting converted into float)
        *     
        * float a = 7.0f/4 //1.75 (As 7.0f is a float, the whole operation returns a float value)
        * 
        * 
        */

    }
}
