import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class QuickFindUF{
	public QuickFindUF(int N){
		count = N;
		id = new int[N];
		for (int i = 0; i != N; i++)
		{
			id[i] = i;
		}
	}
	public void union(int p, int q){
		int pID = find(p);
		int qID = find(q);
		if (pID == qID)
			return ;
		for (int i = 0; i < id.length; i++)
		{
			if (id[i] == pID) 
				id[i] = qID;			
		}
		count--;
	}
	public int find(int p){
		return id[p];
	}
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	public int count(){
		return count;
	}
	private int[] id;
	private int count;

	public static void main(String[] arg) throws IOException{
		Scanner sc = new Scanner(System.in);
		int numline = sc.nextInt();
		System.out.println(numline);
		QuickFindUF uf = new QuickFindUF(numline);
		while(sc.hasNext())
		{
			int p = sc.nextInt();
			int q = sc.nextInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			//System.out.println(p + " " + q);
		}
		System.out.println(uf.count() + " components");
	}
}
