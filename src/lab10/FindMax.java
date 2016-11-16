package lab10;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * COMP 3021
 * 
 * This is a class that prints the maximum value of a given array of 90 elements
 * 
 * This is a single threaded version.
 * 
 * Create a multi-thread version with 3 threads:
 * 
 * one thread finds the max among the cells [0,29] another thread the max among
 * the cells [30,59] another thread the max among the cells [60,89]
 * 
 * Compare the results of the three threads and print at console the max value.
 * 
 * 
 * @author valerio
 * 
 */
public class FindMax {
	// this is an array of 90 elements
	// the max value of this array is 9999
	static int[] array = { 1, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2, 3, 4543,
			234, 3, 454, 1, 2, 3, 1, 9999, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3, 1, 34, 5, 6, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3 };
	ArrayList<Integer> valArrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		new FindMax().printMax();
	}

	public void printMax() {
		// this is a single threaded version
		// int max = findMax(0, array.length - 1);

		int max = 0;
		
	/*
		Thread[] threadArr = new Thread[3];

		threadArr[0] = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				valArrayList.add(findMax(0, 29));

				System.out.println("1");
				
				
			}
		});
		threadArr[1] = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				valArrayList.add(findMax(30, 59));

				System.out.println("2");
				
			}
		});
		threadArr[2] = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				valArrayList.add(findMax(60, 89));

				System.out.println("3");
				
			}
		});

		threadArr[0].start();
		threadArr[1].start();
		threadArr[2].start();

		try {
			threadArr[0].join();
			threadArr[1].join(); 
			threadArr[2].join(); 
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
	    executor.execute(new Thread(){
	    	public void run(){
	    		 valArrayList.add(findMax(0,29));
	    		 }
	    });

	    executor.execute(new Thread(){
	    	public void run(){
	    		 valArrayList.add(findMax(30,59));
	    	}
	    });
	    
	    executor.execute(new Thread(){
	    	public void run(){
	    		 valArrayList.add(findMax(60,89));		
	    	}
	    });
	    
	    executor.shutdown();
		
		
		//System.out.println("123");

		//System.out.println("0");
		
		max = valArrayList.get(0);

		if (max < valArrayList.get(1))
			max = valArrayList.get(1);
		if (max < valArrayList.get(2))
			max = valArrayList.get(2);

		System.out.println("the max value is " + max);
		
	}

	/**
	 * returns the max value in the array within a give range [begin,range]
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	private int findMax(int begin, int end) {
		// you should NOT change this function
		int max = array[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}