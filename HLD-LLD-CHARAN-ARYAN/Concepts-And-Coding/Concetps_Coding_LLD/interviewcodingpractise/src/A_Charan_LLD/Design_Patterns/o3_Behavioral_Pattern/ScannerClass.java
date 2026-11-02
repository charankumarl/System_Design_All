package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern;

import java.util.Scanner;

public class ScannerClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        /// To consumer 1 word String
//
//        String name = sc.next();
//
//        ///  To consumer senetnce with spaces
//
//        String name1 = sc.nextLine();
//
//        ///  To cinumer Othere datatypes
//
//        int a = sc.nextInt();
//        long b = sc.nextLong();
//
//        ///  OR
//
//        int a1 = Integer.parseInt(sc.nextLine());
//
//        ///  since we need to consume the new line use like this or.
//
        System.out.println("enter an integer");
        int a2 = sc.nextInt();
        sc.nextLine(); // consume the newline character , means we press enter to give input of integer or string so.
        System.out.println("enter a string");
        String str = sc.nextLine(); // now read the string input

        System.out.println("enter another string");
        String str2 = sc.nextLine();

        System.out.println(a2);
        System.out.println(str);
        System.out.println(str2);


        sc.nextLine();/// This will be added only after consumer any other data type except string

        ///  for string if we used nextline, then dont add it.
    }
}
