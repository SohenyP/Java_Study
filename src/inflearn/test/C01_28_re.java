/*
4. 연속 부분수열
설명

N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.

예시 입력 1 
8 6
1 2 1 3 1 1 1 2

예시 출력 1
3
 */

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_28_re {

	public int solution(int n, int m, int[] arr) {
		int ans = 0;
		int sum = 0;
		
		int lt = 0;
		for(int rt = 0; rt < n; rt++) {
			sum += arr[rt]; //arr[0]부터 차례로 더하기
			while(sum > m) {
				sum -= arr[lt++]; //m보다 크면 앞 값을 빼가기
			}
			if(sum == m) { //m이랑 같아지면 ans++
				ans++;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) throws IOException {
		C01_28_re T = new C01_28_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 숫자열 갯수
		int m = Integer.parseInt(st.nextToken()); // 특정숫자

		st = new StringTokenizer(br.readLine(), " "); // 주어진 수 배열화
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.print(T.solution(n, m, arr)); // 값출력
	}

}
