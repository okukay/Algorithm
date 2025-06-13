import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int bag;
	static int middle, N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		bag = 0;

		while (true) {
			if (N % 5 == 0) {
				bag += (N / 5);
				N = N % 5;
			
			} else if (N % 5 != 0) {
				N = N-3;
				bag += 1;		
			}
			
			if (N < 0) {
				System.out.println("-1");
				break;
			}
			if(N == 0) {
				System.out.println(bag);
				break;
			}
		}
		
	}
}
