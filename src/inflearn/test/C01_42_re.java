/*
7. 교육과정 설계
설명

현수는 1년 과정의 수업계획을 짜야 합니다.
수업중에는 필수과목이 있습니다. 
이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
만약 총 과목이 A, B, C, D, E, F, G가 있고,
여기서 필수과목이 CBA로 주어지면 
필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, 
A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.


입력
첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.
두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.(수업설계의 길이는 30이하이다)


출력
첫 줄에 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력합니다.

예시 입력 1 
CBA
CBDAGE

예시 출력 1
YES
 */

package inflearn.test;

//QUEUE로 풀기!!! 
/*
	queue.offer(x) : x를 큐에 삽입
	queue.poll() : 큐에서 빼기(값 리턴됨) > First In First Out 
	queue.peek() : poll하면 빠질 값 확인하기
	queue.size() : 큐 길이
	queue.contains(x) : x 있음 T / 없음 F
	queue.isEmpty() : q비었는지 체크
*/
import java.io.*;
import java.util.*;

public class C01_42_re {
	public String solution(String a, String b) {
		String ans = "YES";
		Queue<Character> q = new LinkedList<>(); //q선언
		
		for(char c : a.toCharArray()) {
			q.offer(c); //수업 순서 담기
		}
		
		for(char c : b.toCharArray()) {
			if(q.contains(c)) { //b문자열 중에서 q에 포함된 과목이라면
				if(c != q.poll()) { //순서대로 나와야 하는 법이지, 근데 안맞다는건 순서 오류
					return "NO"; //따라서 no
				}
			}
		}
		if(q.size() != 0) {
			return "NO"; //모든 과목 수강해야하므로 남을 수 없음
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_42_re T = new C01_42_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine(); //필수과목 밑 순서
		String b = br.readLine(); //수강신청서
		System.out.println(T.solution(a, b));
	}
}
