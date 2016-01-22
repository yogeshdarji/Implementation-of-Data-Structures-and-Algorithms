import java.io.IOException;
import java.util.*;

public class HeapPriorityQueue
{

	static<T> void firstTen(PriorityQueue<T> A) {
		int n = Math.min(A.size(), 10);
		for(int i=0; i<n; i++) {
			System.out.print(A.peek() + " ");
			A.remove();
		}
		System.out.println();
	}

	public static void main(String args[]) throws IOException
	{

		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;
		int n;
		
		if(args.length!=0)
			n = Integer.parseInt(args[0]);
		
		else
			n=1000000;

		ArrayList<Integer> A = new ArrayList<Integer>(n);

		for(int i=0; i<n; i++) {
			A.add(n-i); 
		}


		for(int i=0;i<10;i++)
		{
			System.out.print(A.get(i)+" ");
		}

		System.out.println();

		startTime = System.currentTimeMillis();

		PriorityQueue p =new PriorityQueue(A);

		endTime = System.currentTimeMillis();

		totalTime = endTime - startTime;

		System.out.println("Time="+totalTime);

		firstTen(p);


		while(!p.isEmpty())
		{
			p.remove(); 
		}

	}
}
