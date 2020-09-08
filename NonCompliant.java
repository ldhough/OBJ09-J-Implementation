import java.lang.ClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;
public class NonCompliant {
    static Object obj;
    static Class c;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class to load: ");
        String className = scanner.nextLine();
        System.out.println("Enter method name: ");
        String methodName = scanner.nextLine();
        loadClassInstance(className, methodName);
        System.out.println("Enter object method to run: ");
        String credMethod = scanner.nextLine(); //checkCredentials
        System.out.println("Run compliant code? (y/n)");
        String yN = scanner.nextLine();
        if (yN.equals("n")) {
            runMethodNonCompliant(NonCompliant.obj.getClass().getName(), credMethod);
        } else {
            
        }
    }
    static void runMethodNonCompliant(String className, String methodName) {
        System.out.println("Running noncompliant code!");
        if (className.equals("ProjectPackages.IntendedClass")) { //trust class with this name
            try {
                Method method = c.getMethod(methodName);
                method.invoke(NonCompliant.obj);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    void runMethodCompliant(String c_1, String c_2) {
    }
    static void loadClassInstance(String className, String methodName) {
        ClassLoader classLoader = NonCompliant.class.getClassLoader();
        try {
            Class aClass = classLoader.loadClass(className);
            System.out.println("Class loaded: " + aClass.getName());
            Constructor constructor = aClass.getConstructor();
            Object classObj = constructor.newInstance();
            NonCompliant.obj = classObj;
            NonCompliant.c = aClass;
            //Method method = aClass.getMethod(methodName);
            //NonCompliant.obj = method.invoke(classObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
