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

public class C01_28_01 {

	public long solution(int n, int k, int[] arr) {
		int ans = 0;
		int sum = 0;
		//인덱스0 ~ 9
		for (int i = 0; i < n; i++) {
			//첫 값을 sum으로 잡기
			sum = arr[i];
			if (sum == k) { // 첫 값이 k면 ans++후 sum = 0처리
				ans++;
				sum = 0;
			} else if (sum > k) { // 첫 값이 k면 sum = 0 처리
				sum = 0;
			} else { //첫 값이 k보다 작으면 ==k 될 때까지 합하기
				for (int j = i + 1; j < n; j++) {
					sum += arr[j];
					if (sum >= k) { 
						if (sum > k) { //k 보다 크면 해당 i 빠져나가기
							break;
						} else { //k면 ans++후 종료
							ans++;
							break;
						}
					}
				}
				sum = 0;
			}

		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_28_01 T = new C01_28_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 숫자열 갯수
		int k = Integer.parseInt(st.nextToken()); // 특정숫자

		st = new StringTokenizer(br.readLine(), " "); // 주어진 수 배열화
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.print(T.solution(n, k, arr)); // 값출력
	}

}
