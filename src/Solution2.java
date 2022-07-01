import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {

            // init
            String[] line = input.readLine().split("\\s");

            long n = Long.parseLong(line[0]);
            long a = Long.parseLong(line[1]);
            long b = Long.parseLong(line[2]);

            // calculation
            long sum = 0;
            for (int i = 0; i <= n; i++) {
                if (i % a != 0 && i % b != 0) {
                    sum = sum + i;
                }
            }

            // print result
            System.out.println(sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
