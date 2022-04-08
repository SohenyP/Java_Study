/*
6. 최대 길이 연속부분수열
설명

0과 1로 구성된 길이가 N인 수열이 주어집니다. 
여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 
여러분이 최대 k번의 변경을 통해 
이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.

만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
int[14] / k = 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1

여러분이 만들 수 있는 1이 연속된 연속부분수열은

Image1.jpg

이며 그 길이는 8입니다.


입력
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.

두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.


출력
첫 줄에 최대 길이를 출력하세요.


예시 입력 1 

14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1
예시 출력 1

8
 */

package inflearn.test;

import java.io.*;
import java.util.*;

public class C01_30_01 {

	public int solution(int n, int k, int[] arr) {
		int ans = 0;
		int cnt = 0; //k초과 체크
		int lt = 0;
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt]==0) {
				cnt++; //굳이 arr[rt]를 1로 바꾸지 않고, cnt만 줄여주기
			}
			while(cnt > k) { //cnt가 k초과시
				if(arr[lt] == 0) { //lt번째가 0이 나올때까지 while 반복
					cnt--;  //0일 때 cnt--
				}
				lt++; // lt한 칸씩 늘리면서 0인지 체크
			}
			ans = Math.max(ans, rt-lt+1); //길이 체크
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_30_01 T = new C01_30_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 배열길이
		int k = Integer.parseInt(st.nextToken()); // 변경 횟수
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n]; // 배열만들기
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(T.solution(n, k, arr)); // 값출력
	}

}
