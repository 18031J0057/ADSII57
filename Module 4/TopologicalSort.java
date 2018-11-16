import java.util.*;
class Graph2
{
    int V;
    List <Integer> adj[];
    public Graph2(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adj[i]=new ArrayList<Integer>();
    }
    public void addEdge(int u,int v)
    {
        adj[u].add(v);
    }   
    public void topologicalSort()
    {
        int indegree[] = new int[V];
         
        for(int i = 1; i < V; i++)
        {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for(int node : temp)
            {
                indegree[node]++;
            }
        }
        
        for(int i = 1; i < V; i++)
        {
            
                System.out.println("deg "+i+" "+indegree[i]);
            
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        int cnt = 0;
        Vector <Integer> topOrder=new Vector<Integer>();
        while(!q.isEmpty())
        {
            int u=q.poll();
            topOrder.add(u);
            for(int node : adj[u])
            {
                if(--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }  
        if(cnt != V)
        {
            System.out.println("There exists a cycle in the graph");
            return ;
        }
        for(int i=1;i<topOrder.size();i++) {
        	System.out.print(topOrder.get(i)+" ");
        }
    }
}
class TopologicalSort
{
    public static void main(String args[])
    {
        Graph2 g=new Graph2(6);
    	g.addEdge(1, 3); 
		g.addEdge(5, 2); 
		g.addEdge(3, 2); 
		g.addEdge(3, 4); 
		g.addEdge(1,5); 
        System.out.println("Following is a Topological Sort");
        g.topologicalSort();

    }
}