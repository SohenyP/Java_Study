/*
6. 뒤집은 소수
설명

N개의 자연수가 입력되면 
각 자연수를 뒤집은 후 
그 뒤집은 수가 소수이면 
그 소수를 출력

예를 들어 32를 뒤집으면 
23이고, 23은 소수이다. 
그러면 23을 출력한다. 
단 910를 뒤집으면 19로 

첫 자리부터의 연속된 0은 무시한다.


입력
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.


출력
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.


예시 입력 1 
9
32 55 62 20 250 370 200 30 100

예시 출력 1
23 2 73 2 3
 */

//아스키
//특 : 32 ~ 47
//숫 : 48 ~ 57
//특 : 58 ~ 63
//대 : 65 ~ 90
//소 : 97 ~ 122

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_18_re {

	public boolean isPrime(int n) {
		if (n == 1) { // 1은 소수 아님 ex)10, 100
			return false;
		}
		for (int i = n - 1; i > 1; i--) { // 왜 --는 안될까?
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public String solution(int[] arr) {
		String ans = "";

		for (int n : arr) {
			int reverse = 0;
			
			while (n > 0) {
				int dig = n % 10;
				reverse = reverse * 10 + dig;
				n /= 10;
			}
			if (isPrime(reverse)) {
				ans += reverse + " ";
			}
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_18_re t = new C01_18_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.print(t.solution(arr));
	}
}
