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

//114ms
//방법2. 리팩토링 및 Math.max(값1, 값2)
public class C01_21_02 {

	public int solution(int num, int[][] arr) {
		int ans = 0;
		int sum1 = 0;
		int sum2 = 0;

		// 각 행(가로)의 합 ([0][0]+[0][1]+...+[0][num-1])
		// 각 열(세로)의 합([0][0]+[1][0]+...+[num-1][0])
		for (int i = 0; i < num; i++) {
			sum1=sum2 = 0;
			for (int j = 0; j < num; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			ans = Math.max(Math.max(sum1, sum2), ans);
		}

		// 두 대각선 합 ([0][0]+[2][2]+[3][3]+..+[num-1][num-1])
		// /([0][num-1]+[1][num-2]+...+[3][num-4]+[4][num-5])
		sum1=sum2 = 0;
		for (int i = 0; i < num; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][num - (i + 1)];
		}

		ans = Math.max(Math.max(sum1, sum2), ans);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_21_02 T = new C01_21_02();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
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
