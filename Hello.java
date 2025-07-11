import java.util.*;

class Hello{
	public static void main(String[] args)
	{

		// Positive, Negative, Zero
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Number: ");
		int num = sc.nextInt();

		if (num>0){
			System.out.print("Positive\n\n");

		}else if(num==0){
			System.out.print("Zero\n\n");

		}else{
			System.out.print("Negative\n\n");

		}
		
		// Loops in java
		for (int i=1; i<=10; i++){
			System.out.println(i);
		}
		
		System.out.print("\nEnter Number: ");
		int a = sc.nextInt();
		int count = 0;
		
		// Prime number
		if (a>0){
			for (int i = 1; i<=a; i++){
				if (a%i==0){
					count++;
				}
			}
			if (count == 2){
				System.out.println("It is a prime number\n");

			}else{
				System.out.println("It is not a prime number\n");

			}
		}else{
			System.out.println("Not a positive number!\n");

		}

		System.out.print("Enter Number for factorial: ");
		int n = sc.nextInt();
		int f = 1;

		for (int i=1; i<=n; i++){
			f = f*i;
		}
		System.out.println("The factorial of the given number is " + f + "\n");

		System.out.print("Enter n: ");
		n = sc.nextInt();
		System.out.print("Enter r: ");
		int r = sc.nextInt();

		long p = factorial.calculate(n)/factorial.calculate(n-r);
		long c = (factorial.calculate(n))/(factorial.calculate(n-r)*factorial.calculate(r));
		System.out.println("\nPermutation : " + p);
		System.out.println("Combination : "+ c + "\n");
		


	}
}
