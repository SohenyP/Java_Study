/*
8. 이분검색
설명

임의의 N개의 숫자가 입력으로 주어집니다. 
N개의 수를 오름차순으로 정렬한 다음 
N개의 수 중 한 개의 수인 M이 주어지면
이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 
단 중복값은 존재하지 않습니다.

입력
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.

출력
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.

예시 입력 1 
8 32
23 87 65 12 57 32 99 81

예시 출력 1
3
 */

package inflearn.test;
//이분검색 : 정렬 후에만 가능

//정렬없는 검색 : 순차검색

//이분검색 : 포인터, 중간지점 필요
import java.io.*;
import java.util.*;

class C01_51_01 {

	public int solution(int n, int m, int[] arr) {
		int ans = 0;
		
		int lt = 0;
		int rt = arr.length;
		int mid = 0;
		while(ans <= 0) {
			//이분검색 조건2. 투포인터 합/2
			mid = (lt+rt)/2;
			//mid위치가 지정값일 때
			if(arr[mid] == m) {
				//인덱스는 0부터니까 mid+1
				ans = mid+1;
			}
			//아닐 때
			else {
				//mid번째가 지정보다 크면 rt로 좁히기
				if(arr[mid] > m) {
					rt = mid-1;
				}
				//mid번째가 지정보다 작으면 lt로 좁히기
				else {
					lt = mid+1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_51_01 T = new C01_51_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 배열 길이
		int m = Integer.parseInt(st.nextToken()); // 찾을 숫자

		int[] arr = new int[n]; // 숫자배열

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//이분검색 조건1. : sort
		Arrays.sort(arr);

		System.out.print(T.solution(n, m, arr));

	}
}
