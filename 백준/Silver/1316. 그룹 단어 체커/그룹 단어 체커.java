
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt = 0;
		for(int t =0; t<T; t++) {
		String alp = sc.next();
        char[] alp_array = alp.toCharArray();
        
        //문자열 길이
        int len = alp.length();
        // 입력받을 문자
        
        int same = 0; 
        for(int i = 0; i < len; i++) {
        	for(int j = i+2; j < len; j++) {
        		// 1번째랑 두번째가 다르고 and 1번째랑 세번째가 같을때
        		if(alp_array[i] != alp_array[j-1] && alp_array[i] == alp_array[j]) {
        			same += 1;
        			break;
        		}
        		}
        	if (same != 0) {
        		break;
        	}
        	}
        if(same == 0) {
        	cnt += 1;
        }
		}
	System.out.println(cnt);
	}
}
