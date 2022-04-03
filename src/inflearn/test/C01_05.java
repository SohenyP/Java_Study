package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_05 {

	public String solution(String str) {
		String ans = "";

		//입력받은 단어 char배열화
		char[] c = str.toCharArray();
		//문자열만 뽑아서 넣을 ArrayList
		ArrayList<Character> a = new ArrayList<Character>();

		for (int i = 0; i < str.length(); i++) {
			// 소문자 : 65 ~ 90
			// 대문자 : 97 ~ 122
			// 문자만 뽑아서 배열 만들기
			if (c[i] >= 65 && c[i] <= 122) {
				a.add(c[i]);
				//뽑힌 자리는 ' '
				// char는 ''빈 문자열 사용 불가
				c[i] = ' ';
			}
		}
		// ArrayList 뒤집기
		Collections.reverse(a);

		// ArrayList to char[]
		char[] ctoa = new char[a.size()];

		for (int k = 0; k < a.size(); k++) {
			ctoa[k] = a.get(k);
		}

		//' '인 위치에 배열 ctoa 순서대로 집어넣기
		int n = 0;

		for (int j = 0; j < str.length(); j++) {
			if (c[j] == ' ') {
				c[j] = ctoa[n];
				n++;
			}
		}
		ans = String.valueOf(c);

		return ans;
	}

	public static void main(String[] args) throws IOException {
		//출력 객제 호출
		C01_05 T = new C01_05();

		//단어 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//입력 단어 보내기
		System.out.println(T.solution(str));

	}

}
