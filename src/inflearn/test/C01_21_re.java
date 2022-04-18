/*
9. 격자판 최대합
설명

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
N*N의 격자판이 주어지면 
각 행의 합, 
각 열의 합, 
두 대각선의 합 중 
가장 큰 합을 출력합니다.

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
최대합을 출력합니다.

예시 입력 1 
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

예시 출력 1
155
 */

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_21_re {

	public int solution(int num, int[][] arr) {
		int ans = 0;
		int col = 0;
		int row = 0;
		int ver1 = 0;
		int ver2 = 0;
		Set<Integer> set = new TreeSet<>();
		
		//행, 열 합
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				col += arr[i][j];
				row += arr[j][i];
			}
			set.add(Math.max(col, row));
			col = 0; row = 0;
		}
		
		//대각선 합 [0][n-1] + [1][n-2] + []
		for(int i = 0; i < arr.length; i++) {
			ver1 += arr[i][i];
			ver2 += arr[i][num-i-1];
			
		}
		set.add(Math.max(ver1, ver2));
		
		ans = Collections.max(set);
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_21_re T = new C01_21_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int[][] arr = new int[num][num];

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < num; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.print(T.solution(num, arr));

	}
}
