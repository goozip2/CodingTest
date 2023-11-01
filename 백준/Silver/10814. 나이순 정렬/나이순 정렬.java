import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person {
	int age;
	String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

public class Main {

	static StringTokenizer st;
	
	//(이름, )나이, 가입순
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Person[] arr = new Person[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr[i] = new Person(age, name);
		}
		
		Arrays.sort(arr, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				// 양의 정수일 경우, 서로 위치 변경 (오름차순)
				return p1.age - p2.age;
			}
		});
		
		for(Person p: arr) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		System.out.print(sb);
		
	}

}
