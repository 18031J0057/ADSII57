import java.io.*; 
import java.util.*; 

//This class represents a directed graph using adjacency list 
//representation 
class Solution
{ 
 public  int V;   // No. of vertices 
public static int check;
 // Array  of lists for Adjacency List Representation 
  LinkedList<Integer> adj[]; 

 // Constructor 
 Solution(int v) 
 { 
     V = v; 
     adj = new LinkedList[v]; 
     for (int i=0; i<v; ++i) 
         adj[i] = new LinkedList(); 
 } 

 //Function to add an edge into the graph 
 void addEdge(int v, int w) 
 { 
     adj[v-1].add(w-1);// Add w to v's list. 
     //adj[w].add(v);
 } 

 // A function used by DFS 
 void DFSUtil(int v,boolean visited[]) 
 { 
     // Mark the current node as visited and print it 
     visited[v] = true; 
     check=v;
     //System.out.print(v+" "); 
     

     // Recur for all the vertices adjacent to this vertex 
     Iterator<Integer> i = adj[v].listIterator(); 
     while (i.hasNext()) 
     { 
         int n = i.next(); 
         if (!visited[n]) 
             DFSUtil(n, visited); 
     } 
 } 

 // The function to do DFS traversal. It uses recursive DFSUtil() 
 void DFS(int v) 
 { 
     // Mark all the vertices as not visited(set as 
     // false by default in java) 
     boolean visited[] = new boolean[V]; 

     // Call the recursive helper function to print DFS traversal 
     DFSUtil(v, visited); 
 } 

 public static void main(String args[]) 
 { 
	 Scanner sc=new Scanner(System.in);
	 int V=Integer.parseInt(sc.nextLine());
     Solution g = new Solution(V); 
     while(sc.hasNext())
     {
    	 String s=sc.nextLine();
    	 String[] t=s.split(" ");
    	 g.addEdge(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
     }


    // System.out.println("Following is Depth First Traversal "+ 
                        //"(starting from vertex 2)"); 

     g.DFS(0); 
     //System.out.println("end");
     if(check==V-1)
     {
    	 System.out.println("true");
    	
     }
     else 
     {
    	 System.out.println("false");
     }
     
 } 
} 