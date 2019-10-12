package dynamic_problem.coin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by neelabhsingh on 12/10/19.
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 So the output should be 5.
 */
public class CoinChange {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int size = Integer.parseInt(br.readLine());
            String []strArray = br.readLine().split(" ");
            int [] array = new int[size];
            for(int i=0; i<size;i++){
                array[i] = Integer.parseInt(strArray[i]);
            }
            int change = Integer.parseInt(br.readLine());
            int result = coinChange(array, change);
            int result1 = coin_change(array, change);
            System.out.println(result);
            System.out.println(result1);

        }
    }

    private static int coinChange(int[] denomination, int amount) {
        int size = denomination.length;
        int [] amountArray = new int[amount + 1];
        Arrays.fill(amountArray, 0);
        amountArray[0] = 1;

        for(int i=0; i<size; i++){
            for(int j=1; j<=amount; j++ ){
                int remainingAmount = j - denomination[i];
                if(remainingAmount >=0){
                    amountArray[j] += amountArray[remainingAmount];
                }
            }
        }
        for(int value: amountArray)
        {
            System.out.print(value +", ");
        }
        System.out.println();
        return amountArray[amount];
    }

    public static int coin_change(int [] coins, int change){
        int n = coins.length;
        int [] total_change = new int[change+1];
        total_change[0] = 1;
        for(int i=1; i<=change; i++){
            total_change[i] = 0;
        }
        for(int j=0; j<n; j++){
            for(int i=1; i<=change; i++){
                int remaining_change = i - coins[j];
                if(remaining_change>=0){
                    total_change[i] += total_change[remaining_change];
                }
            }
        }
        return total_change[change];
    }
}
