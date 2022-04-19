/*
3. 최대 매출
설명

현수의 아빠는 제과점을 운영합니다. 
현수 아빠는 현수에게 N일 동안의 매출기록을 주고 
연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 
이때 K=3이면
12 15 11 20 25 10 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
여러분이 현수를 도와주세요.


입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 최대 매출액을 출력합니다.

예시 입력 1 
10 3
12 15 11 20 25 10 20 19 13 15

예시 출력 1
56
 */

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_27_re {

	public int solution(int n, int k, int[] arr) {
		int ans = 0;
		int lt = 0;
		int rt = k;
		int sum = 0;
		int max = 0;
		
		for(int i = 0; i < k; i++) { //첫 날 매출 합
			sum += arr[i];
		}
		
		while (lt < n-k && rt < n) {
			max =  sum > max ? sum : max;
			sum = sum - arr[lt] + arr[rt];
			lt++;
			rt++; 
		}
		ans = max;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_27_re T = new C01_27_re();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 숫자열 갯수
		int k = Integer.parseInt(st.nextToken()); // 계산일수

		st = new StringTokenizer(br.readLine(), " "); // 주어진 매출 배열화
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(T.solution(n, k, arr));

	}

}
