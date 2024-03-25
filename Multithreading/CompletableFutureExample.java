import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

  public static void main(String[] args) {
    int [] numList = {1,2,3,4};
    CompletableFuture<Integer> sum = CompletableFuture.supplyAsync(() -> calcSum(numList));
    CompletableFuture<Integer> sumSq = sum.thenApplyAsync(result->result*result);
    CompletableFuture<Void> printresult = sumSq.thenAcceptAsync(result-> System.out.println("res="+result));

    System.out.println("ttttttt");
    printresult.join();
  }

  public static int calcSum(int [] numList){
    try{
      Thread.sleep(100);
    }
    catch(Exception ee){ee.printStackTrace();}
    // int sum = 0;
    return Arrays.stream(numList).sum();
  }
}