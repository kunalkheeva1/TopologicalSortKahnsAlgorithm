import java.util.*;

public class TopologicalSortKahnsAlgorithm {



    static int [] topologicalSortAlgorithm(ArrayList<ArrayList<Integer>> adj, int v){
        int []ans = new int[v];
        int index =0;
        int [] inDegree = new int[v];
        for(int i=0; i<v; i++){
            inDegree[i]=0;
        }


        for(int i=0; i<v; i++){
            for(int j=0; j<adj.get(i).size(); i++){
                int connection = adj.get(i).get(j);
                inDegree[connection] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.remove();
            ans[index] = current;
            index++;
            for(int i=0; i<adj.get(current).size(); i++){
                int connection = adj.get(current).get(i);
                inDegree[connection] --;

                if(inDegree[connection]==0){
                    q.add(connection);
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {

    }
}
