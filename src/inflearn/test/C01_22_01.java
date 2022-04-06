/*
10. 봉우리
설명

지도 정보가 N*N 격자판에 주어집니다. 
각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 
자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 

봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
(가장자리보다는 무조건 크다!)

만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 
각 자연수는 100을 넘지 않는다.


출력
봉우리의 개수를 출력하세요.


예시 입력 1 

5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
예시 출력 1

10
 */

package inflearn.test;

import java.util.*;
import java.io.*;

//
//방법1. 
public class C01_22_01 {

	public int solution(int num, int[][] arr) {
		int ans = 0;
		//상하좌우 차이값 미리 만들기
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		/*
		[2][2]
		상 [2-1][2]
		하 [2+1][2]
		좌 [2][2-1]
		우 [2][2+1]		
		*/
		//i좌료를 위한 for문
		for (int i = 0; i < num; i++) {
			//j좌표를 위한 for문
			for (int j = 0; j < num; j++) {
				//flag 값 false시 break걸기 위함
				boolean flag = true;
				//상하좌우 차이 배열만큼 돌려서 i,j 조합하기
				for (int k = 0; k < dx.length; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					//x, y값 조건 설정 후, 해당하는 x,y만 arr만들어서 값 체크
					//x,y를 먼저 체크 후에 arr값을 체크해야함!
					if(x >= 0 && y >= 0 && x < num && y < num && arr[i][j] <= arr[x][y]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					ans++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_22_01 T = new C01_22_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[num][num];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < num; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.print(T.solution(num, arr));

	}
}
