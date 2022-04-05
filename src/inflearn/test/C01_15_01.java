/*
3. 가위 바위 보
설명

A, B 두 사람이 가위바위보 게임을 합니다. 
총 N번의 게임을 하여 
A가 이기면 A를 출력하고, 
B가 이기면 B를 출력합니다. 
비길 경우에는 D를 출력합니다.

가위, 바위, 보의 정보는 
1:가위, 2:바위, 3:보로 정하겠습니다.

예를 들어 N=5이면
 
Image1.jpg

두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.

세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


예시 입력 1 

5
2 3 3 1 3
1 1 2 2 3
예시 출력 1

A
B
A
B
D
 */

//아스키
//특 : 32 ~ 47
//숫 : 48 ~ 57
//특 : 58 ~ 63
//대 : 65 ~ 90
//소 : 97 ~ 122

package inflearn.test;

import java.util.*;
import java.io.*;

//방법1. 
public class C01_15_01 {
//1:가위, 2:바위, 3:보

	/*
	 * 짐
	 * 1 2
	 * 2 3
	 * 3 1
	 * 이김
	 * 1 3
	 * 2 1
	 * 3 2
	 * 비김
	 * 1 1 0
	 * 2 2 0
	 * 3 3 0
	 */
	public String solution(int arrA, int arrB) {
		String ans = "";

		if (arrA == arrB) {
			ans = "D";
		} else if ((arrA == 1 && arrB == 3) || (arrA == 2 && arrB == 1)	|| (arrA == 3 && arrB == 2)) {
			ans = "A";
		} else {
			ans = "B";
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_15_01 T = new C01_15_01();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
		StringTokenizer stB = new StringTokenizer(br.readLine(), " ");
		int[] arrA = new int[num];
		int[] arrB = new int[num];

		// String to int[]
		for (int i = 0; i < arrA.length; i++) {
			// Integer.parseInt(String)
			arrA[i] = Integer.parseInt(stA.nextToken());
		}
		for (int i = 0; i < arrB.length; i++) {
			// Integer.parseInt(String)
			arrB[i] = Integer.parseInt(stB.nextToken());
		}
		for (int i = 0; i < num; i++) {
			System.out.println(T.solution(arrA[i], arrB[i]));
		}
	}
}
