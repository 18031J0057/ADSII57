import java.util.Scanner;

public class Solution 
 {

    // given an n-by-n matrix of open sites, return an n-by-n matrix
    // of sites reachable from the top
    public static boolean[][] flow(boolean[][] isOpen) 
     {
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
        for (int j = 0; j < n; j++) 
          {
            flow(isOpen, isFull, 0, j);
          }
        return isFull;
     }

    // determine set of full sites using depth first search
    public static void flow(boolean[][] isOpen, boolean[][] isFull, int i, int j) 
      {
        int n = isOpen.length;

        // base cases
        if (i < 0 || i >= n) return;    // invalid row
        if (j < 0 || j >= n) return;    // invalid column
        if (!isOpen[i][j]) return;      // not an open site
        if (isFull[i][j]) return;       // already marked as full
         // mark i-j as full
        isFull[i][j] = true;
        flow(isOpen, isFull, i+1, j);   // down
        flow(isOpen, isFull, i, j+1);   // right
        flow(isOpen, isFull, i, j-1);   // left
        flow(isOpen, isFull, i-1, j);   // up
    }
    public static boolean percolates(boolean[][] isOpen) {
        int n = isOpen.length;
        boolean[][] isFull = flow(isOpen);
        for (int j = 0; j < n; j++) {
            if (isFull[n-1][j]) return true;
        }
        return false;
    }

   
  
    public static void main(String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	int n=Integer.parseInt(sc.nextLine());
    	
        boolean[][] isOpen = new boolean[n][n];
        try 
        {
          while(sc.hasNext()) 
           {
        	String temp[]=sc.nextLine().split(" ");
        	int i=Integer.parseInt(temp[0]);
        	int j=Integer.parseInt(temp[1]);
        	isOpen[i-1][j-1]=true;
           }
        }
        catch(Exception e) 
        {
        	System.out.println("index out of bound"+e.getMessage());
        }
        
        System.out.println(percolates(isOpen));
     }

}
