/*
5. 소수(에라토스테네스 체)
설명

자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


출력
첫 줄에 소수의 개수를 출력합니다.


예시 입력 1 

20
예시 출력 1

8
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
//소수(에라토스테네스 체) : 나보다 큰 숫자로 나누면 나머지 0 이상

public class C01_17_re {
	
	public int solution(int n) {
		int ans = 0;
		
		int[] arr = new int[n];
		
		for(int i = 2; i < n; i++) {
			if(arr[i] == 0) { //0이면 소수
				ans++;
				for(int j = i; j < n; j = j+i) { //배수는 모두 1처리해서 소수 계산 안되도록
					arr[j] = 1;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		C01_17_re t = new C01_17_re();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(t.solution(n));
	}
}
