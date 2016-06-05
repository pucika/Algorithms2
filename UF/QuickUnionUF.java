import java.util.Scanner;

public class QuickUnionUF{
	public QuickUnionUF(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		count = N;
	}
	public void union(int p, int q)
	{
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return ;
		id[pRoot] = id[qRoot];
		count--; 
	}
	public int find(int p)
	{
		while (id[p] != p)
			p = id[p];
		return p;
	}
	public boolean connected(int p, int q){
		return find(p) == find (q);			
	}
	public int count()
	{
		return count;
	}
	
	private int[] id;
	private int count;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numline = in.nextInt();
		System.out.println(numline);
		QuickUnionUF uf = new QuickUnionUF(numline);
		while (in.hasNext())
		{
			int p = in.nextInt();
			int q = in.nextInt();
			if (uf.connected(p, q)) continue;
			uf.union(p,q);
			//System.out.println(p + " " + q);
		}
		System.out.println(uf.count() + " components");

	}
}