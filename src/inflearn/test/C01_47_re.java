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

//어렵삼.. 이해필요
/*
 hit : 해야할 작업이 현재 캐시에 있는 상태
 miss : 해야할 작업이 현재 캐시에 없는 상태
 */

import java.io.*;
import java.util.*;

public class C01_47_re {
	public int[] solution(int s, int n, int[] arr) {
		int[] ans = new int[s];
		
		for(int work : arr) {
			int idx = -1; //hit : 해당 인덱스 넣기, miss : -1
			
			for(int j = 0; j < arr.length; j++) {
				if(work == arr[j]) { //메모리 내 작업있다면,
					idx = j; //idx에 그 인덱스 번호 추가
				}
			}
			
			if(idx == -1) { //메모리 내 작업 없다면
				for(int k = s-1; k >= 1; k--) {
					ans[k] = ans[k-1]; //k자리에 k-1값 넣기 = 한 칸씩 밀기
				}
			}
			else {//메모리내 작업 있다면
				for(int l = idx; l >= 1; l++) { //해당 작업 위치 인덱스 번호~1까지
					ans[l] = ans[l-1];  //l자리에 l-1값 넣기 = 인덱스 위치부터 1까지 한 칸씩 밀기
				}
			}
			ans[0] = work; //어차피 지정된 work는 무조건 맨 처음에 들어가야 하므로 맨 마지막에 ans[0] = work;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_47_re T = new C01_47_re();

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
