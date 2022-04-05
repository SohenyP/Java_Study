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

//뒤집은 소수
//
//방법1. 
public class C01_18_01 {
	
	public boolean isPrime(int num) {
		if(num ==1) {
			return false;
		}
		for (int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int solution(int num) {
		int ans = 0;
		int rev = 0;
		//자릿수 뒤집기
		while(num != 0) {
			int dig = num % 10; //32 % 10 = 2 // 3 % 10 = 3
			rev = rev * 10 + dig; //  0 * 10 + 2 = 2 // 2*10+3 = 23
			num /= 10; // 32/10 = 3 // 3/10 = 0
		}
		
		if(isPrime(rev)) {
			ans = rev;
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_18_01 T = new C01_18_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int n : arr) {
			if(T.solution(n) != 0) {
				sb.append(T.solution(n) + " ");
			}
		}
		System.out.println(sb);

	}
}
