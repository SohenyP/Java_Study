/*
4. Least Recently Used
설명

캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 
CPU가 처리할 작업을 저장해 놓았다가 필요할 바로 사용해서 처리속도를 높이는 장치이다. 
워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.

철수의 컴퓨터는 캐시메모리 사용규칙이 LRU 알고리즘을 따른다.
LRU 알고리즘은 Least Recently Used 의 약자로 
직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.

캐시의 크기가 주어지고, 
캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.

출력
마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.


예시 입력 1 
5 9
1 2 3 2 6 2 3 5 7

예시 출력 1
7 5 3 2 6
 */

package inflearn.test;

//삽입정렬

import java.io.*;
import java.util.*;

public class C01_47_01 {
	public int[] solution(int s, int n, int[] arr) {
		int[] ans = new int[s];

		for (int i : arr) { // arr값 돌아가면서 miss/hit 파악
			int idx = -1; // 인덱스 번호 : 위치 (hit = 인덱스넘버 저장 / miss = -1)
			
			for (int j = 0; j < s; j++) { // 맨처음부터 끝까지 hit/miss체크
				if (i == arr[j]) { // hit라면
					idx = j; // 해당 인덱스 저장 없으면 -1유지
				}
			}
			
			if (idx == -1) { // miss : 없는 작업 처리 idx == -1
				//인덱스 맨 뒤부터 1까지
				for (int k = s - 1; k >= 1; k--) { // 맨 끝부터 1인덱스 까지
					ans[k] = ans[k - 1]; //뒷값에 앞값 복사
				}
				//ans[0] = i; //맨 앞에 작업 할당
			} 
			else { //hit : 이미 있는 작업 처리 idx > -1
				for (int l = idx; l >= 1; l--) { //hit는 hit위치부터 1까지
					ans[l] = ans[l-1]; //뒷값에 앞값 복사
				}
				//ans[0] = i; //맨 앞에 작업 할당
			}
			ans[0] = i; //무조건 들어가니까 if~elseif 뒤에 삽입
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_47_01 T = new C01_47_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken()); // 캐시크기
		int n = Integer.parseInt(st.nextToken()); // 작업 수

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n]; // 작업순서
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int a : T.solution(s, n, arr)) {
			System.out.print(a + " ");
		}
	}
}
