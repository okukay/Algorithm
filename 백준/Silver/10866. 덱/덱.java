
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String cmd[] = line.split(" ");

            String order = cmd[0];

            if (order.equals("push_front")) {
                push_front(Integer.parseInt(cmd[1]));
            } else if (order.equals("push_back")) {
                push_back(Integer.parseInt(cmd[1]));
            } else if (order.equals("pop_front")) {
                pop_front();
            } else if (order.equals("pop_back")) {
                pop_back();
            } else if (order.equals("size")) {
                size();
            } else if (order.equals("empty")) {
                empty();
            } else if (order.equals("front")) {
                front();
            } else if (order.equals("back")) {
                back();
            }

        }
    }

    public static void push_front(int x) {
        dq.addFirst(x);
    }

    public static void push_back(int x) {
        dq.addLast(x);
    }

    public static void pop_front() {
        if (!dq.isEmpty()) {
            System.out.println(dq.pollFirst());
        } else {
            System.out.println("-1");
        }
    }

    public static void pop_back() {
        if (!dq.isEmpty()) {
            System.out.println(dq.pollLast());
        } else {
            System.out.println(-1);
        }
    }

    public static void size() {
        System.out.println(dq.size());
    }

    public static void empty() {
        if (!dq.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }

    public static void front() {
        if (!dq.isEmpty()) {
            System.out.println(dq.peekFirst());
        } else {
            System.out.println(-1);
        }
    }

    public static void back() {
        if (!dq.isEmpty()) {
            System.out.println(dq.peekLast());
        } else {
            System.out.println(-1);
        }
    }

}