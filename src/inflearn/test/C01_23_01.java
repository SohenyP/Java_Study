/*
11. 임시반장 정하기
설명

김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
김갑동 선생님은 우선 임시로 반장을 정하고 
학생들이 서로 친숙해진 후에 
정식으로 선거를 통해 반장을 선출하려고 한다.

그는 자기반 학생 중에서 
1학년부터 5학년까지 지내오면서 
한번이라도 같은 반이었던 사람이 가장 많은 학생
임시 반장으로 정하려 한다.

그래서 김갑동 선생님은 
각 학생들이 1학년부터 5학년까지 
몇 반에 속했었는지를 나타내는 표를 만들었다.

예를 들어 학생 수가 5명일 때의 표를 살펴보자.

위 경우에 4번 학생을 보면 
3번 학생과 2학년 때 같은 반이었고, 
3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 

그러므로 이 학급에서 4번 학생과 한번이라도 같은 반이었던 사람은 
2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.

이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.

각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 
임시 반장을 정하는 프로그램을 작성하시오.


입력
첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 
학생 수는 3 이상 1000 이하이다.
둘째 줄부터는 1번 학생부터 차례대로 
각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
주어지는 정수는 모두 1 이상 9 이하의 정수이다.


출력
첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 
그 중 가장 작은 번호만 출력한다.


예시 입력 1 
9
1 2 3 4 5
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 1
7 8 9 1 2
8 9 1 2 3
9 1 2 3 4

5
2 3 1 7 3 
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

01342

5
9 8 7 6 5
5 6 7 8 9
1 2 3 7 8
4 5 3 4 2
6 2 8 4 2

11233

3
5 4 4 2 1
1 2 3 4 5
1 2 3 7 8

033

예시 출력 1
4
3 > 4아님?
2
 */

package inflearn.test;

/*
i행 숫자 중 j열 숫자랑 공통된 횟수 구하기
int Math.max
ArrayList Collections.max
int[] Arrays.sort() > int[0]

[0][0] [0][1] [0][2]
[1][0] [1][1]
...
[3][0]
[4][0]
*/
//방법1.
import java.util.*;
import java.io.*;

public class C01_23_01 {
	public int solution(int num, int[][] arr) {
		int ans = 0;
		int[] ar = new int[num];

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < num; k++) {
					if (i != k && arr[i][j] == arr[k][j]) {
						ar[i]++;
					}
				}
			}
		}

		// 배열 내 최대값 찾기 : 여기선 인덱스 번호 도출임!!
		int max = ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > max) {
				max = ar[i];
				ans = i+1;
			}
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_23_01 T = new C01_23_01();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		// 5학년까지기 때문에 이미 j열은 최대 값이 정해져 있음!!!
		// i는 학생 수 이므로 가변적!!! = num
		int[][] arr = new int[num][5];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.print(T.solution(num, arr));

	}
}
