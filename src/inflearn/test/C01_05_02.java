package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_05_02 {

	public String solution(String str) {
		String ans = "";

		//입력받은 단어 char배열화
		char[] c = str.toCharArray();
		
		int lt = 0;
		int rt = str.length()-1;
		
		while(lt < rt) {
			//Character.isAlphabetic() : 한글, 영대소문인지 체크
			//Character.isLetter() : 한글, 영대소문인지 체크
			//앞쪽이 글자 아니면 다음 글자 이동
			if(!Character.isAlphabetic(c[lt])) {
				lt++;
			}
			//뒷쪽이 글자 아니면 앞글자로 이동
			else if(!Character.isAlphabetic(c[rt])) {
				rt--;
			}
			//둘 다 글자면 바꾸기
			else {
				char temp = c[lt];
				c[lt] = c[rt];
				c[rt] = temp;
				lt++;
				rt--;
			}
		}
		ans = String.valueOf(c);
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		// 출력 객제 호출
		C01_05_02 T = new C01_05_02();

		// 단어 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		// 입력 단어 보내기
		System.out.print(T.solution(str));

	}

}
