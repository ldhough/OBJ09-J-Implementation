package ProjectPackages;
import java.util.Scanner;
public class IntendedClass {
    public static String s = "IntendedClassString";
    // This class checks user credentials and gives them their credit card info if credentials are valid
    public void checkCredentials() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter username: ");
        String user = s.nextLine();
        System.out.println("Enter password: ");
        String pass = s.nextLine();
        //String user = "Nelson";
        //String pass = "password";
        if (user.equals("Nelson") && pass.equals("password")) {
            System.out.println(UserInfo.getCreditCard());
        } else {
            System.out.println("Invalid credentials!");
        }
    }
    public void printS() {
        System.out.println(IntendedClass.s);
    }
    public Object returnObjectOfClass() {
        return this;
    } //Hypothetically can return objects of other classes too

}
