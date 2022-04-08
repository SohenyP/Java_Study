/*
3. 매출액의 종류
설명

현수의 아빠는 제과점을 운영합니다. 
현수아빠는 현수에게 N일 동안의 매출기록을 주고 
연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.

만약 N=7이고 7일 간의 매출기록이 아래와 같고, 
이때 K=4이면
20 12 20 10 23 17 10

각 연속 4일간의 구간의 매출종류는

첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.

N일간의 매출기록과 연속구간의 길이 K가 주어지면 
첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.


입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 
각 숫자는 500이하의 음이 아닌 정수입니다.


출력
첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.


예시 입력 1 

7 4
20 12 20 10 23 17 10
예시 출력 1

3 4 4 3
 */

package inflearn.test;
//Hash로 풀기!!! 
import java.io.*;
import java.util.*;

public class C01_33_01 {
	public ArrayList<Integer> solution(int n, int k, int[] arr) {
		ArrayList<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int lt = 0;
		for(int rt = k-1; rt < n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			ans.add(map.size());
			map.put(arr[lt], map.get(arr[lt])-1);
			if(map.get(arr[lt]) == 0) {
				map.remove(arr[lt]);
			}
			lt++;
		}
		
	
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_33_01 T = new C01_33_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 일 수
		int k = Integer.parseInt(st.nextToken()); // 연속 수
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[k]; // 숫자배열
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(T.solution(n, k, arr)); // 값출력
	}

}
