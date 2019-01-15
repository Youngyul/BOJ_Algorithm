import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
 
/*
4 5
1 2 1
4 2 -2
3 2 -8
3 4 -3
4 1 -88
*/
class AdjVertex1 implements Comparable<AdjVertex1> {
    int adjVertex;
    int weight;
    public AdjVertex1(int adjVertex,int weight) {
        // TODO Auto-generated constructor stub
        this.adjVertex=adjVertex;
        this.weight=weight;
    }
    //우선순위 큐에 삽입될때 정렬할 기준을 가준치로 정해주는 것이다.
    @Override
    public int compareTo(AdjVertex1 o) {
        // TODO Auto-generated method stub
        if(this.weight>o.getWeight()) return 1;
        else if(this.weight==o.getWeight()) return 0;
        else return -1;
    }
    public int getAdjVertex() {
        return adjVertex;
    }
    public void setAdjVertex(int adjVertex) {
        this.adjVertex = adjVertex;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
public class BOJ_1753 {
    static ArrayList<AdjVertex1>[] vertexList;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PriorityQueue<AdjVertex1> pq=new PriorityQueue<AdjVertex1>();
        
        int V=sc.nextInt();
        int E=sc.nextInt();
        int K=sc.nextInt();
        
        vertexList=new ArrayList[V+1];
        distance=new int[V+1];
        //인접리스트 초기화 및 거리 배열 초기화(거리배열은 무한대값 개념으로 초기화해준다.)
        for(int i=1;i<V+1;i++) {
            vertexList[i]=new ArrayList<AdjVertex1>();
            distance[i]=Integer.MAX_VALUE;
        }
        //시작정점의 거리는 0으로 초기화해준다.(자기자신으로 들어가는 거리는 0임으로)
        distance[K]=0;
        for(int i=0;i<E;i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            AdjVertex1 adVertex=new AdjVertex1(v,w);
            vertexList[u].add(adVertex);
        }
        //시작정점 K에서 자기자신 K로 들어가는 거리는 0이다. 라는 객체를 우선순위큐에 삽입
        pq.offer(new AdjVertex1(K,distance[K]));
        while(!pq.isEmpty()) {
            //가중치가 가장 작은 정점과 가중치 쌍을 poll해준다.(기준정점이 삭제된 이후의 큐는 방문하지 않은 정점중 
            //가중치가 가장 작은 정점을 poll한다.)
            AdjVertex1 vertexInfo=pq.poll();
            int index=vertexInfo.getAdjVertex();
            int weight=vertexInfo.getWeight();
            //우선순위 큐에서 삭제한 정점의 인접한 정점들을 구한다.
            Iterator<AdjVertex1> it=vertexList[index].iterator();
            while(it.hasNext()) {
                AdjVertex1 adVertex=it.next();
                int index1=adVertex.getAdjVertex();
                int weight1=adVertex.getWeight();
                //거리가 무한대이거나 OR 이전에 갱신된 거리보다 지금 방문한 거리가 작다면 거리를 다시 갱신해준다.
                if(distance[index1]>distance[index]+weight1) {
				distance[index1]=distance[index]+weight1;
				pq.offer(adVertex);
				}
            }
		}
		for(int i=1;i<V+1;i++) {
			if(distance[i]<Integer.MAX_VALUE) System.out.println(distance[i]);
			else System.out.println("INF");
		}
	}
}