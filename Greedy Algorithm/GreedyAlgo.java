import java.util.ArrayList;

public class GreedyAlgo {
    ArrayList<Integer> findMinCoin(int deno[], int value) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = deno.length - 1; i >= 0; i--) {
            while (deno[i] <= value) {
                list.add(deno[i]);
                value = value - deno[i];
            }
            if (value == 0)
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        GreedyAlgo greedyAlgo = new GreedyAlgo();
        
        // Example usage:
        int[] deno = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int value = 88;

        ArrayList<Integer> result = greedyAlgo.findMinCoin(deno, value);

        System.out.println("Minimum coins needed to make " + value + ": " + result);
    }
}
