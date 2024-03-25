public class MaxProfit {
    int maxProfit(int p[], int w[], int c) {
        int profit = 0;
        QuickSort q = new QuickSort();
        q.quickSort(w, 0, w.length - 1); // Corrected the quickSort call
        for (int i = 0; i < p.length; i++) {
            int wi = w[i];
            int pi = p[i];
            if (c - wi >= 0) {
                c = c - wi;
                profit += pi;
            } else {
                profit = profit + pi / wi * c;
                break;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit mxP = new MaxProfit();
        int[] p = {9, 10, 5, 8, 1};
        int[] w = {4, 1, 2, 8, 8};
        int c = 7;
        int result = mxP.maxProfit(p, w, c);
        System.out.println("Maximum Profit: " + result);
    }
}
