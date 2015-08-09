package com.learn.algorithm.dynamic;

public class LongestCommSub {
	private static char[] str1 = new String("xyxxzxyzxy").toCharArray();
	private static char[] str2 = new String("zxzyyzxxyxxzy").toCharArray();
	private static int[][] table = new int[str2.length + 1][str1.length + 1];
	//private static char[] result = new char[max(str1.length,str2.length)]; 
	//private static int k = 0;

	/* L[i][j] = 
	 * 1.0							(if i = 0 && j = 0)
	 * 2.L[i-1,j-1] + 1				(if i > 0 && j > 0 && ai = bj)
	 * 3.max(L[i-1,j],L[i,j-1])		(if i > 0 && j > 0 && ai != bj)
	 */
	public static void main(String[] args) {
		int length = getLongestCommSub(str1,str2);
		System.out.println("the length is: " + length);
		/*for(int i = k - 1; i >= 0; i --)
			System.out.println(result[i] + "  ");*/
	}

	public static int getLongestCommSub(char[] str1, char[] str2) {
		int i = 0, j = 0;
		for(i = 0; i < str1.length + 1; i ++)
			table[j][i] = 0;
		for(j = 0, i = 0; j < str2.length + 1; j ++)
			table[j][i] = 0;
		
		for(i = 1; i <= str1.length; i ++)
			for(j = 1; j <= str2.length; j ++){
				if(str1[i - 1] == str2[j - 1]){
					table[j][i] = table[j - 1][i - 1] + 1;
					/*result[k] = str1[i -1];
					System.out.print(result[k ++] + "   ");*/
				}
				else
					table[j][i] = max(table[j][i - 1],table[j - 1][i]);
			}
		//return table[str2.length - 1][str1.length - 1];
		return table[str2.length][str1.length];
	}

	private static int max(int i, int j) {
		return i > j? i : j;
	}
	
	

}
