/*4. 단어 뒤집기
설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


예시 입력 1 

3
good
Time
Big
예시 출력 1

doog
emiT
giB
*/
package inflearn.test;

import java.io.*;
import java.util.*;

public class C01_04 {
	public String solution(int N, String str) {
		String ans = "";
		
		// 방법1. StringBuilder or StringBuffer
		/*
		for (int i = 0; i < N; i++) {
			// StringBuilder or StringBuffer로 str생성해 reverse로 역전 후 toString()
			String rev = new StringBuilder(str).reverse().toString();
			ans = rev;
		}
		*/

		// 방법2. char배열로 직접 뒤집기
		// 인덱스 양끝 0, N-1
		int ls = 0;
		int rs = N - 1;

		for (int i = 0; i < N; i++) {
			// 단어를 char배열화
			char[] s = str.toCharArray();

			// ls가 rs보다 커야만 위치 교체 가능
			while (ls < rs) {
				char temp = s[ls];
				s[ls] = s[rs];
				s[rs] = temp;
				// 왼쪽은 ++, 오른쪽은 --로 만날 수 있도록!
				ls++;
				rs--;
			}
			// ans = s.toString() : 주소값으로 나옴
			// ans = new String(s);
			// valueOf() : static으로 선언된 클래스! 따라서 String.valueOf()
			ans = String.valueOf(s);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_04 T = new C01_04();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N개의 단어
		int N = Integer.parseInt(br.readLine());
		// 단어 담을 배열
		String[] arr = new String[N];

		// 배열에 주어진 단어 주입
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		// 각 값 전달해 출력
		for (String str : arr) {
			System.out.println(T.solution(N, str));
		}
	}

}
