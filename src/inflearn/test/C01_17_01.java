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
//1. 2부터 n까지 나열
//2. 2는 소수로 추가. 
//   2의 배수 1처리 (이중포문 j=j+i)
//128ms
//방법1. 에라토스테네스 체
public class C01_17_01 {
	public int solution(int num) {
		int ans = 0;
		int[] arr = new int[num+1]; //2부터 20까지 배열 : 초기값 전부 0
	
		for (int i = 2; i <= num; i++) { // 2부터 주어진 수까지 포함해서 for문 돌리기
			if(arr[i] == 0) { //시작이 2, 2는 소수
				ans++;//갯수 추가
				for (int j = i; j <= num; j=j+i) { //각 배수 제거(j=j+i) : i는 이미 카운팅 됐으므로 1처리해서 중복 처리 방지
					arr[j] = 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_17_01 T = new C01_17_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(T.solution(num));
	}
}
