/*
5. 연속된 자연수의 합
설명

N입력으로 양의 정수 N이 입력되면 
2개 이상의 연속된 자연수의 합으로 
정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

만약 N=15이면

7+8=15

4+5+6=15

1+2+3+4+5=15

와 같이 총 3가지의 경우가 존재한다.


입력
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.


출력
첫 줄에 총 경우수를 출력합니다.


예시 입력 1 

15
예시 출력 1

3
 */

package inflearn.test;

import java.io.*;

public class C01_29_01 {

	public long solution(int n) {
		int ans = 0;
		int sum = 0;
		int p1 = 1;
		//연속된 합이 n/2이후로는 불가능함
		for(int p2 = 1; p2 <= (n/2)+1; p2++) {
			sum += p2; //p2를 sum에 계속 합하기
			while(sum > n) { //sum이 n초과시에만
				sum -= p1++; // sum에서 p1빼주고 p1++하기
			}
			if(sum == n) { //만약 sum이 n이랑 같으면 
				ans++; //그 때 ans ++
			}
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_29_01 T = new C01_29_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 숫자


		System.out.print(T.solution(n)); // 값출력
	}

}
