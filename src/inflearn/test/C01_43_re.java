/*
8. 응급실
설명

메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
응급실은 환자가 도착한 순서대로 진료를 합니다. 
하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.

• 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.

• 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 
대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.

즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.

현재 N명의 환자가 대기목록에 있습니다.
N명의 대기목록 순서의 환자 위험도가 주어지면, 
대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.

입력
첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어집니다.
두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
위험도는 값이 높을 수록 더 위험하다는 뜻입니다. 같은 값의 위험도가 존재할 수 있습니다.

출력
M번째 환자는 몇 번째로 진료받는지 출력하세요.

예시 입력 1 
5 2
60 50 70 80 90

출력 1
3
----------------
예시 입력 2 
6 3
70 60 90 60 60 60

출력 2
4
 */

package inflearn.test;

import java.io.*;
import java.util.*;

class Inform {
	int id;
	int priority;
	
	public Inform(int id, int priority) { //초기화
		this.id = id;
		this.priority = priority;
	}
}
public class C01_43_re {
	public int solution(int n, int m, int[] arr) {
		int ans = 0;
		Queue<Inform> q = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++) {
			q.offer(new Inform(i, arr[i])); //큐에 환자번호, 위증도 넣기
		}
		
		while(!q.isEmpty()) {
			Inform tmp = q.poll(); //맨 처음 환자 정보
			for(Inform p : q) {
				if(p.priority > tmp.priority) { //첫 환자 위증도보다 다른 환자 위증도 높으면
					q.offer(tmp); //tmp환자 맨 끝에 넣기
					tmp = null; //다른 환자 담기 위해 null 초기화
					break;
				}
			}
			if(tmp != null) { //만약 모든 환자중 위증도 제일 높다면
				ans++; //진료 시작 = 회차 증가
				if(tmp.id == m) { //tmp환자 id가 m이랑 같다면, 즉 찾는 환자라면
					return ans; //해당 순서 출력
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_43_re T = new C01_43_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(T.solution(n, m, arr));
	}
}
