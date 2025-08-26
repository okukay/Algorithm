
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            String n = st.nextToken();
            if (n.equals("push")) {
                int m = Integer.parseInt(st.nextToken());
                stack.push(m);
            } else if (n.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if (n.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (n.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (n.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}