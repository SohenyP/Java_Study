/*
4. 피보나치 수열
설명

1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


출력
첫 줄에 피보나치 수열을 출력합니다.

예시 입력 1 
10

예시 출력 1
1 1 2 3 5 8 13 21 34 55
 */

package inflearn.test;

import java.io.*;
//피보나치 수열 : 주어진 두 수 1, 1/ 두 수의 합이 다음 숫자

public class C01_16_re {
	public int[] solution(int n) {
		int[] ans = new int[n];
		ans[0] = 1;
		ans[1] = 1;

		for (int i = 2; i < n; i++) {
			ans[i] = ans[i - 1] + ans[i - 2];
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_16_re t = new C01_16_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int i : t.solution(n)) {
			System.out.print(i + " ");
		}

	}
}
