import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution5 {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {

            // init
            String[] line = input.readLine().split("\\s");

            int n = Integer.parseInt(line[0]) + 1;
            int m = Integer.parseInt(line[1]) + 1;
            int q = Integer.parseInt(line[2]);

            int[][] twoDimArray = new int[n][m];

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    twoDimArray[i][j] = 0;
                }
            }

            // solution
            ArrayList<Integer> output = new ArrayList<>();
            int i = 0;
            while (i < q) {
                String[] request = input.readLine().split("\\s");
                switch (Integer.parseInt(request[0])) {
                    case (1):
                        for (int j = 1; j < n; j++) {
                            for (int k = Integer.parseInt(request[1]); k < Integer.parseInt(request[2]) + 1; k++) {
                                twoDimArray[j][k] += Integer.parseInt(request[3]);
                            }
                        }
                        break;
                    case(2):
                        for (int j = 1; j < n; j++) {
                            for (int k = 1; k < m; k++) {
                                if (j == Integer.parseInt(request[1])) {
                                    twoDimArray[j][k] = Integer.parseInt(request[2]);
                                }
                            }
                        }
                        break;
                    case(3):
                        for (int j = 1; j < n; j++) {
                            for (int k = 1; k < m; k++) {
                                if (j == Integer.parseInt(request[1]) && k == Integer.parseInt(request[2])) {
                                    output.add(twoDimArray[j][k]);
                                }
                            }
                        }
                        break;
                    default:
                        break;
                }
                i++;
            }

            // result
            for (Integer integer : output) {
                System.out.println(integer);
            }

            /* for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    System.out.printf("%5d ", twoDimArray[j][k]);
                }
                System.out.println();
            } */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
