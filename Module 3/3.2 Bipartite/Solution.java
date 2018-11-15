import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution
{
    private int numberOfVertices;
    private Queue<Integer> queue;
 
    public static final int NO_COLOR = 0;
    public static final int RED = 1;
    public static final int BLUE = 2;
 
    public Solution(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        queue = new LinkedList<Integer>();
    }
 
    public boolean isBipartite(int adjacencyMatrix[][], int source)
    {
        int[] colored = new int[numberOfVertices +  1];
        for (int vertex = 1; vertex <= numberOfVertices; vertex++)
        {
            colored[vertex] = NO_COLOR;
        }
        colored[source] = RED;
        queue.add(source);
 
        int element, neighbour;
        while (!queue.isEmpty())
        {
            element = queue.remove();
            neighbour = 1;
            while (neighbour <= numberOfVertices)
            { 
                if (adjacencyMatrix[element][neighbour] == 1 && colored[element]== colored[neighbour])
                {
                    return false;
                }
                if (adjacencyMatrix[element][neighbour] == 1 && colored[neighbour]== NO_COLOR)
                {
                    colored[neighbour] = (colored[element] == RED ) ? BLUE :RED;
                    queue.add(neighbour);
                }
                neighbour++;
            }
        }
        return true;
    }
 
    public static void main(String... arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
        try 
        {
           System.out.println("Enter the number of nodes in the graph");
           scanner = new Scanner(System.in);
           number_of_nodes = Integer.parseInt(scanner.nextLine());
           int e=number_of_nodes = Integer.parseInt(scanner.nextLine());
           
           int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
           System.out.println("Enter the adjacency matrix");
           for (int i = 1; i <= e; i++)
           {
               	String temp[]=scanner.nextLine().split(" ");
               	int v=Integer.parseInt(temp[0]);
              	int v1=Integer.parseInt(temp[1]);
                   adjacency_matrix[v][v1] = 1;
               
           }
 
           for (int i = 1; i <= number_of_nodes; i++)
           {
               for (int j = 1; j <= number_of_nodes; j++)
               {	
                   if(adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                   {
                       adjacency_matrix[j][i] = 1;
                   }
               }
           }
 
           Solution bipartiteBfs = new Solution(number_of_nodes);
           if (bipartiteBfs.isBipartite(adjacency_matrix, 1)) 
           {
               System.out.println("The given graph is bipartite");
           } else
           {
               System.out.println("The given graph is not bipartite");
           }
       } catch (InputMismatchException inputMismatch) 
       {
           System.out.println("Wrong Input format");
       }
       scanner.close();
    }
}