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
		ArrayList<Integer> ans = new ArrayList<>(); //값 출력 배열
		Map<Integer, Integer> map = new HashMap<>(); // key=종류, value=갯수
		for(int i = 0; i < k-1; i++) { // 0~k-1-1까지 갯수 새서 배열 생성
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int lt = 0; //왼쪽 포인터
		for(int rt = k-1; rt < n; rt++) { //k-1부터 배열끝까지
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1); //배열 추가하되, 이미 있으면 +1 없으면 0+1
			ans.add(map.size()); //k개 생성됐으므로 size체크해서 list추가
			map.put(arr[lt], map.get(arr[lt])-1); //현재 lt위치 value에서 -1
			if(map.get(arr[lt]) == 0) { //빼고나서 그게 0이라면
				map.remove(arr[lt]); //배열lt 지워
			}
			lt++; //다음 포인터로 이동
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
		int[] arr = new int[n]; // 숫자배열
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int result : T.solution(n, k, arr)) {
			System.out.print(result + " "); // 값출력
		}
		
	}

}
