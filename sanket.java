
import java.util.Scanner;
public class pro1
{
	public static void main(String[] args) {
	    int h, w, n;  //for Input Height, Width, and number
	    
	    //take input using Scanner class
		System.out.println("Input Height and Width: ");
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		System.out.println("Input Matrix with number form 0 to 9 :");
		int[][] arr = new int[w][h];
		for(int i=0;i<w;i++)
		{
		    for(int j=0;j<h;j++)
		    {
		        arr[i][j] = sc.nextInt();
		    }
		}
		
		System.out.println("Input maximum width of square submatrix:");
		n = sc.nextInt();
		
		
		//area to work
		int newh = h-n; //new Height
		int neww = w-n; //new width
		
		
		//new array init
		int anewh = newh+1;
		int aneww = neww+1;
		int[][] temparr = new int[aneww][anewh];
		
		//formulate the outer boundry
		int limit = n*n;
		int sublimit = n-2;
		sublimit = sublimit*sublimit;
		int newlimit = limit-sublimit;
		int l = n-1, l1 = l*2, l2 = l*3, l3 = l*4;
		
		//Fill the temp array
		
		for(int i=0; i<=neww; i++)
		{
		    for(int j=0; j<=newh; j++)
		    {
		        int temp,sum=0,y=i,u=j;
		        for(int k=0;k<newlimit;k++)
        		{
        		    temp = arr[y][u];
        		    sum=sum+temp;
        		    if(k<l)
        		    {
        		        u++;
        		    }
        		    else if(k<l1)
        		    {
        		        y++;
        		    }
        		    else if(k<l2)
        		    {
        		        u--;
        		    }
        		    else if(k<l3)
        		    {
        		        y--;
        		    }
        		}
        		temparr[i][j] = sum;
		    }
		}
		
		//find the maximum value in the array
		int largestval = 0;
		int largestI = 0;
		int largestJ = 0;
		for(int i=0;i<=neww;i++)
		{
		    for(int j=0;j<=newh;j++)
		    {
		        if(temparr[i][j]>largestval)
		        {
		            largestval = temparr[i][j];
		            largestI = i;
		            largestJ = j;
		        }
		    }
		}
		
		//print the result
		System.out.println("\n");
		
		int plimiti = largestI+n;
		int plimitj = largestJ+n;
		
		for(int i = largestI; i < plimiti; i++)
		{
		    for(int j = largestJ; j < plimitj; j++)
		    {
		        System.out.print(arr[i][j]+"\t");
		    }
		    System.out.print("\n");
		}
	}
}
