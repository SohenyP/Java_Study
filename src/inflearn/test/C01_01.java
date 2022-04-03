package inflearn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C01_01 {

	public int solution(String word, String c) {
		// 체크된 갯수
		int answer = 0;

		// 방법1. word길이만큼 for문 수행
		/*for (int i = 0; i < word.length(); i++) {
			// word의 i번째 글자와 c의 0번째 글자가 같으면 cnt++
			if (word.charAt(i) == c.charAt(0)) {
				answer++;
			}
		}*/
		
		//방법2. word 배열로 만들어 체크하기
		for (char w : word.toCharArray()) {
			if(w == c.charAt(0)) {
				answer++;
			}
		}
				
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// 출력 객체 생성
		C01_01 T = new C01_01();
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 주어진 단어 - 소문자 치환
		String word = br.readLine().toLowerCase();
		// 체크 대상 - 소문자 치환
		String c = br.readLine().toLowerCase();

		System.out.print(T.solution(word, c));
	}
}
