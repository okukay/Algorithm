
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int b, a;
	static int N;
	static int[] numbers;
	
	// 조합
	private static void dice4(int cnt, int start) {
		if(cnt == b) {
			for(int i = 0; i<numbers.length; i++) {
				System.out.print(numbers[i]+ " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<=a; i++) {
			numbers[cnt] = i;
			dice4(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
	// NandM 은 중복순열
	// NandM2 는 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		
		numbers = new int[b];
		dice4(0,1);
	}

}
