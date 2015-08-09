package com.learn.algorithm.dynamic;

public class CutRodMemoized {
	private static int[] profit = {1,5,8,9,10,17,17,20,24,30};
	

	public static void main(String[] args) {
		int thisProfit = -1;
		int father = 4;
		thisProfit = cutRodMethod(profit,father);
		System.out.println("the best result is: " + thisProfit);
	}


	private static int cutRodMethod(int[] profit, int father) {
		int[] revenue = new int[father + 1];
		for(int i = 0; i < revenue.length; i ++){
			revenue[i] = Integer.MIN_VALUE;
		}
		
		int result = cutRodMethodAux(profit,father,revenue);
		for(int i = 0; i <= father; i ++)
			System.out.println("revenue[" + i + "] = " + revenue[i]);
		return result;
	}

	private static int cutRodMethodAux(int[] profit, int father, int[] revenue) {
		/*
		 * 分三种情况讨论：
		 */
		//当这个值之前已经计算过得话，直接返回
		if(revenue[father] >= 0)
			return revenue[father];
		//如果之前没有计算过，则按照动态规划的思想，依照最优子结构计算
		int q = -1;
		//如果数量为0，直接返回————这是作为控制递归结束的标志
		if(father == 0)
			q = 0;
		else{ 
			q = Integer.MIN_VALUE;
			for(int i = 1; i <= father; i ++){
				q = max(q,profit[i - 1] + cutRodMethodAux(profit, father - i, revenue));
			}
		}
		
		revenue[father] = q;
		return q;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
