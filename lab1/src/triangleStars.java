import java.util.Scanner;
public class triangleStars {
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("n = ");
	    int n = input.nextInt();
	    
	    for (int i=1;i<=n;i++)
	    {
	    	for (int k=n;k>i;k--)
	    	{
	    		System.out.printf(" ");
	    		
	    	}
	    	for (int j=1;j<=2*i-1;j++)
	    	{
	    		System.out.printf("*"); 		
	    	}
	    	System.out.println("");	
	    }
	}
}
