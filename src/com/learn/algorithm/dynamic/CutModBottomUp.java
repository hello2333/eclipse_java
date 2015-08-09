package com.learn.algorithm.dynamic;

public class CutModBottomUp {
	private static int[] profit = {1,5,8,9,10,17,17,20,24,30};

	public static void main(String[] args) {
		int thisProfit = -1;
		int father = 4;
		thisProfit = bottomUpCutRod(profit,father);
		System.out.println("the best result is: " + thisProfit);
	}

	private static int bottomUpCutRod(int[] profit, int father) {
		int[] revenue = new int[father + 1];
		revenue[0] = 0;
		for(int i = 1; i < revenue.length; i ++){
			revenue[i] = Integer.MIN_VALUE;
		}
		
		for(int i = 1; i <= father; i ++)
			for(int j = 1; j <= i; j ++){
				revenue[i] = max(revenue[i],revenue[i - j] + profit[j - 1]);
				System.out.println("revenue[" + i + "] = " + revenue[i]);
			}
		return revenue[father];
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
