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
    //�켱���� ť�� ���Եɶ� ������ ������ ����ġ�� �����ִ� ���̴�.
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
        //��������Ʈ �ʱ�ȭ �� �Ÿ� �迭 �ʱ�ȭ(�Ÿ��迭�� ���Ѵ밪 �������� �ʱ�ȭ���ش�.)
        for(int i=1;i<V+1;i++) {
            vertexList[i]=new ArrayList<AdjVertex1>();
            distance[i]=Integer.MAX_VALUE;
        }
        //���������� �Ÿ��� 0���� �ʱ�ȭ���ش�.(�ڱ��ڽ����� ���� �Ÿ��� 0������)
        distance[K]=0;
        for(int i=0;i<E;i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            AdjVertex1 adVertex=new AdjVertex1(v,w);
            vertexList[u].add(adVertex);
        }
        //�������� K���� �ڱ��ڽ� K�� ���� �Ÿ��� 0�̴�. ��� ��ü�� �켱����ť�� ����
        pq.offer(new AdjVertex1(K,distance[K]));
        while(!pq.isEmpty()) {
            //����ġ�� ���� ���� ������ ����ġ ���� poll���ش�.(���������� ������ ������ ť�� �湮���� ���� ������ 
            //����ġ�� ���� ���� ������ poll�Ѵ�.)
            AdjVertex1 vertexInfo=pq.poll();
            int index=vertexInfo.getAdjVertex();
            int weight=vertexInfo.getWeight();
            //�켱���� ť���� ������ ������ ������ �������� ���Ѵ�.
            Iterator<AdjVertex1> it=vertexList[index].iterator();
            while(it.hasNext()) {
                AdjVertex1 adVertex=it.next();
                int index1=adVertex.getAdjVertex();
                int weight1=adVertex.getWeight();
                //�Ÿ��� ���Ѵ��̰ų� OR ������ ���ŵ� �Ÿ����� ���� �湮�� �Ÿ��� �۴ٸ� �Ÿ��� �ٽ� �������ش�.
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