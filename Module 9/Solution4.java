import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

class FlyodWarshall2 
{ 
    final static int INF = 99999, V = 29; 
  
    ArrayList[][] floydWarshall2(int s3[][], int src, int des, String[] s1) 
    { 
        int dist[][] = new int[V][V]; 
        int i, j, k,p=-1;
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = s3[i][j];
        ArrayList[][] h=new ArrayList[29][29];
    	for(int l=0;l<29;l++)
    	{
    		for(int m=0;m<29;m++)
    		{
    		h[l][m]=new ArrayList();
    		}
    	}
        for (k = 0; k < V; k++) 
        {  
            for (i = 0; i < V; i++) 
            {  
                for (j = 0; j < V; j++) 
                { 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                    {
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                        h[i][j].add(k);
                    }
                } 
            } 
        }
        
        printSolution(dist,src,des,s1,h); 
        return h;
    } 
  
    void printSolution(int dist[][], int src, int des, String s1[],ArrayList[][] h) 
    { 
    	System.out.println(dist[src][des]);
    	Iterator d=h[src][des].iterator();
    	System.out.print("["+s1[src]+",");
    	while(d.hasNext())
    	{
    		
    		System.out.print(s1[(int)d.next()]+",");
    	}
    	System.out.print(s1[des]+"]");
    }
}

public class Solution4
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		File file1 = new File("I:\\1)MSIT Tasks\\ADS\\Tasks\\ADSII57\\ADSII57\\Module 9\\Tests\\Tests\\ha29_name.txt"); 
		  BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
		  String[] s1 = new String[29];
		  String st1; 
		  int i=0;
		  while ((st1 = br1.readLine()) != null)
		  {
			 s1[i++]=st1;
		  }
		  File file2 = new File("I:\\1)MSIT Tasks\\ADS\\Tasks\\ADSII57\\ADSII57\\Module 9\\Tests\\Tests\\ha29_code.txt"); 
		  HashMap<String,Integer> hp = new HashMap<>();
		  BufferedReader br2 = new BufferedReader(new FileReader(file2)); 
		  String[] s2 = new String[29];
		  String st2; 
		   int j=0;
		  while ((st2 = br2.readLine()) != null)
		  {
			  hp.put(st2, j);
			  s2[j++]=st2;
		  }
		  File file3 = new File("I:\\1)MSIT Tasks\\ADS\\Tasks\\ADSII57\\ADSII57\\Module 9\\Tests\\Tests\\distance.txt"); 
		  BufferedReader br3 = new BufferedReader(new FileReader(file3)); 
		  int[][] s3 = new int[29][29];
		  String st3; 
		   int k=0,x=0,b=0;
		  while ((st3 = br3.readLine()) != null)
		  {
			  String[] a=st3.split("  ");
				  for(int y=0;y<a.length;y++)
				  {
					  s3[x][y]=Integer.parseInt(a[y]);
				  }
				  x++;
		  }
		  System.out.println("Enter Source and Destination with comma");
		  while(sc.hasNext())
		  {
			  
			  String[] p=sc.nextLine().split(",");
			  for( i=0;i<29;i++)
			  {
				  if(s2[i].equals(p[0]))
				  {
					  break;
				  }
			  }
			  for( j=0;j<29;j++)
			  {
				  if(s2[j].equals(p[1]))
				  {
					  break;
				  }
			  }
			  FlyodWarshall2 a = new FlyodWarshall2();
			  a.floydWarshall2(s3,i,j,s1); 
		  }
	}
}
