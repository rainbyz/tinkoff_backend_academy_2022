import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {

            // init
            String[] line = input.readLine().split("\\s");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            int[] tastesArr = new int[n];
            line = input.readLine().split("\\s");
            for (int i = 0; i < tastesArr.length; i++) {
                tastesArr[i] = Integer.parseInt(line[i]);
            }

            line = input.readLine().split("\\s");
            ArrayList<Integer> unavailableList = new ArrayList<>(k);
            for (String number:line
                 ) {
                unavailableList.add(Integer.parseInt(number));
            }

            // calc: find dishes with max taste
            int max = Integer.MIN_VALUE;
            for (Integer number: tastesArr
                 ) {
                if (number > max) {
                    max = number;
                }
            }

            ArrayList<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < tastesArr.length; i++) {
                if (tastesArr[i] == max) {
                    indexes.add(i + 1);
                }
            }

            indexes.removeAll(unavailableList);

            // print result
            if (indexes.isEmpty()) {
                System.out.println("No");
            } else System.out.println("Yes");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
