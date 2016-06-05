import java.util.Scanner;

public class WeightedQuickUnionUF
{
	public WeightedQuickUnionUF(int N)
	{
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	public int count()
	{ return count; }
	public int find(int p)
	{
		while (p != id[p]) 
			p = id[p];
		return p;
	}
	public boolean connected(int p, int q)
	{ return find(p) == find(q); }
	public void union(int p, int q)
	{
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) 
			return ;
		if (sz[pRoot] < sz[qRoot]){
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
		count--;
	}
	private int[] id;
	private int[] sz;
	private int count;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int nline = in.nextInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(nline);
		while (in.hasNext())
		{
			int p = in.nextInt();
			int q = in.nextInt();
			if (uf.connected(p, q)) 
				continue;
			uf.union(p, q);
		} 
		System.out.println(uf.count + " conponents");
	}
}