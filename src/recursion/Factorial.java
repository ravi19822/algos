package recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println("Inside Fcatorial Program *******************");
        int n=5;
        int result=factorial(n);
        System.out.println("Result is **************"+result);
    }

    private static int factorial(int n) {
        if(n==1)
            return 1;
        else
            return n*factorial(n-1);

    }
}
