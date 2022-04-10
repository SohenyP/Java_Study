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

import java.io.*;
import java.util.*;

//오름차순 : implements Comparable<obj> 초기화 , compareTo<obj> 계산
class Point implements Comparable<Point> {
	public int x;
	public int y;
	//초기화
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//Comparable클래스의 compareTo 메소드 override
	@Override
	public int compareTo(Point obj) {
		if(this.x == obj.x) {
			return this.y-obj.y; //this.y-obj.y
		}
		else {
			return this.x - obj.x; //this.x-obj.x
		}
	}
}
class C01_50_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 행 수
		StringTokenizer st;

		ArrayList<Point> arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Point(x, y)); // x,y값을 Point에 넣어 초기화
		}
		//ArrayList 정렬 : compareTo메소드 출력 값에 의해 정렬
		Collections.sort(arr);
		
		for(Point o : arr) {
			System.out.println(o.x + " "+ o.y);
		}
	}
}
