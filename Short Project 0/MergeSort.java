import java.io.IOException;
import java.util.*;
public class MergeSort {

	public <T extends Comparable<T>> void merge(T[] a, int low, int mid, int high)
	{

		Object b[]= new Object[high-low+1];
		int i=low;
		int j= mid+1;
		int k=0;

		while(i<=mid && j<=high)
		{
			if (a[i].compareTo(a[j])<=0)
				b[k++] =  a[i++];
			else
				b[k++] = a[j++];
		}	
		while(i<=mid)
		{
			b[k++]= a[i++];
		}
		while(j<=high)
		{
			b[k++]= a[j++];
		}

		System.arraycopy(b, 0, a, low, b.length);

	}

	private <T extends Comparable<T>> void mergeSort(T[] a,int low, int high)
	{
		if(low<high)
		{			
			int mid = (low+high)/2;
			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);
			merge(a,low,mid,high);

		}

	}
	//Print first ten numbers from list of million numbers
	static<T> void firstTen(T[] A) {
		int n = Math.min(A.length, 10);
		for(int i=0; i<n; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) throws IOException
	{
		int n;
		
		if(args.length!=0)
			 n = Integer.parseInt(args[0]);
			
		else
			 n=1000000;
			
		Integer[] A = new Integer[n];
		MergeSort m = new MergeSort();

		for(int i=0; i<n; i++) {
			A[i] = new Integer(n-i);
		}

		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;


		firstTen(A);

		startTime = System.currentTimeMillis();
		m.mergeSort(A,0,A.length-1);
		endTime = System.currentTimeMillis();

		totalTime = endTime - startTime;

		System.out.println("Time="+totalTime);
		firstTen(A);


	}

}
