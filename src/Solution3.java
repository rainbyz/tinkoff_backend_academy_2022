import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution3 {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            // init
            int n = Integer.parseInt(input.readLine());

            String[] str_arr = new String[n - 1];
            String main_str = input.readLine();
            for (int i = 0; i < str_arr.length; i++) {
                str_arr[i] = input.readLine();
            }

            // calc
            ArrayList<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < main_str.length(); i++) {
                int max_index = i;
                for (String s : str_arr) {
                    int index = s.indexOf(main_str.charAt(i));
                    if (index > max_index) max_index = index;
                    else if (index == i) max_index += s.length();
                }
                indexes.add(max_index);
            }

            // print result
            int min = Integer.MAX_VALUE;
            for (Integer el:indexes
                 ) {
                if (el < min) {
                    min = el;
                }
            }
            System.out.println(min);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
