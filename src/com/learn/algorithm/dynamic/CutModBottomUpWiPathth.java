package com.learn.algorithm.dynamic;

public class CutModBottomUpWiPathth {
	private static int[] profit = {1,5,8,9,10,17,17,20,24,30};

	public static void main(String[] args) {
		int thisProfit = -1;
		int father = 7;
		int[] path = new int[father + 1];
		thisProfit = bottomUpCutRod(profit,father,path);
		System.out.println("the best result is: " + thisProfit);
		for(int i = father; i > 0;){
			System.out.println(path[i]);
			i = i - path[i];
		}
	}

	private static int bottomUpCutRod(int[] profit, int father,int[] path) {
		int[] revenue = new int[father + 1];
		revenue[0] = 0;
		path[0] = 0;
		for(int i = 1; i < revenue.length; i ++){
			revenue[i] = Integer.MIN_VALUE;
		}
		
		for(int i = 1; i <= father; i ++)
			for(int j = 1; j <= i; j ++){
				if(revenue[i] < revenue[i - j] + profit[j - 1]){
					revenue[i] = revenue[i - j] + profit[j - 1];
					path[i] = j;
				}
			}
		return revenue[father];
	}

}
