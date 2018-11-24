//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//class ShortestPath 
//{
//    static final int V=29; 
//    int minDistance(int dist[], Boolean sptSet[]) 
//    { 
//        int min = Integer.MAX_VALUE, min_index=-1; 
//          for (int v = 0; v < V; v++) 
//            if (sptSet[v] == false && dist[v] <= min) 
//            { 
//                min = dist[v]; 
//                min_index = v; 
//            }
//        return min_index; 
//    }
//    void printSolution(int dist[], int n,HashMap hp,String src,String[] s1) 
//    { 
//        System.out.println("Distance from Azores to all cities"); 
//        for (int i = 0; i < V; i++) 
//            System.out.println(s1[(int)hp.get(src)]+" to "+s1[i]+" distance is "+dist[i]); 
//    } 
//    void dijkstra(int graph[][], String src, HashMap hp, String[] s1) 
//    { 
//        int dist[] = new int[V]; 
//        Boolean sptSet[] = new Boolean[V];
//        for (int i = 0; i < V; i++) 
//        { 
//            dist[i] = Integer.MAX_VALUE; 
//            sptSet[i] = false; 
//        } 
//        int src1=(int)hp.get(src);
//        dist[src1] =0;
//        for (int count = 0; count < V-1; count++) 
//        {  
//            int u = minDistance(dist, sptSet); 
//            sptSet[u] = true;
//            for (int v = 0; v < V; v++)
//                if (!sptSet[v] && graph[u][v]!=0 && 
//                        dist[u] != Integer.MAX_VALUE && 
//                        dist[u]+graph[u][v] < dist[v]) 
//                    dist[v] = dist[u] + graph[u][v]; 
//        }  
//        printSolution(dist, V,hp,src,s1); 
//    } 
//}
//public class Solution1 
//{
//	public static void main(String[] args) throws NumberFormatException, IOException
//	{
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter source");
//		String src=sc.nextLine();
//		File file1 = new File("I:\\1)MSIT Tasks\\ADS\\Tasks\\ADSII57\\ADSII57\\Module 9\\Tests\\Tests\\ha29_name.txt"); 
//		  BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
//		  String[] s1 = new String[29];
//		  String st1; 
//		  int i=0;
//		  while ((st1 = br1.readLine()) != null)
//		  {
//			 s1[i++]=st1;
//		  }
//		  File file2 = new File("I:\\1)MSIT Tasks\\ADS\\Tasks\\ADSII57\\ADSII57\\Module 9\\Tests\\Tests\\ha29_code.txt"); 
//		  HashMap<String,Integer> hp = new HashMap<>();
//		  BufferedReader br2 = new BufferedReader(new FileReader(file2)); 
//		  String[] s2 = new String[29];
//		  String st2; 
//		   int j=0;
//		  while ((st2 = br2.readLine()) != null)
//		  {
//			  hp.put(st2, j);
//			  s2[j++]=st2;
//		  }
//		  File file3 = new File("I:\\1)MSIT Tasks\\ADS\\Tasks\\ADSII57\\ADSII57\\Module 9\\Tests\\Tests\\distance.txt"); 
//		  BufferedReader br3 = new BufferedReader(new FileReader(file3)); 
//		  int[][] s3 = new int[29][29];
//		  String st3; 
//		   int k=0,x=0,b=0;
//		  while ((st3 = br3.readLine()) != null)
//		  {
//			  String[] a=st3.split("  ");
//				  for(int y=0;y<a.length;y++)
//				  {
//					  s3[x][y]=Integer.parseInt(a[y]);
//				  }
//				  x++;
//		  }
//          ShortestPath t = new ShortestPath(); 
//          t.dijkstra(s3,src,hp,s1); 
//	}
//}
