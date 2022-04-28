/*
7. 좌표 정렬
설명

N개의 평면상의 좌표(x, y)가 주어지면 
모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, 
x값이 같을 경우 y값에 의해 정렬합니다.


입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.

예시 입력 1 
5
2 7
1 3
1 2
2 5
3 6

예시 출력 1
1 2
1 3
2 5
2 7
3 6
 */

package inflearn.test;
//오름차순 : Comparable<obj> 초기화, compareTo 계산
import java.io.*;
import java.util.*;
class PointRe implements Comparable<PointRe> {
	public int x;
	public int y;
	
	PointRe(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	 @Override
	public int compareTo(PointRe o) {
		 if(this.x == o.x) {
			 return this.y - o.y;
		 }
		 else {
			 return this.x - o.x;
		 }
	}
}
public class C01_50_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 행 수
		StringTokenizer st;
		
		ArrayList<PointRe> arr = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x  = Integer.parseInt(st.nextToken());
			int y  = Integer.parseInt(st.nextToken());
			arr.add(new PointRe(x, y)); //x,y값 차례로 PointRe에서 초기화
		}
		
		Collections.sort(arr); //comparTo메소드 출력값대로 정렬
		
		for(PointRe o : arr) {
			System.out.println(o.x + " " + o.y);
		}
		
		
	}
}
