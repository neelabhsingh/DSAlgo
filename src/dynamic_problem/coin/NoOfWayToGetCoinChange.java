package dynamic_problem.coin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static dynamic_problem.coin.CoinChange.coin_change;

/**
 * Created by neelabhsingh on 12/10/19.
 */
public class NoOfWayToGetCoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int size = Integer.parseInt(br.readLine());
            String []strArray = br.readLine().split(" ");
            int [] denomination = new int[size];
            for(int i=0; i<size;i++){
                denomination[i] = Integer.parseInt(strArray[i]);
            }
            int change = Integer.parseInt(br.readLine());
            int result = getNoOfWayToGetCoinChange(denomination,denomination.length, change);
            System.out.println(result);
        }
    }


    private static int getNoOfWayToGetCoinChange(int[] denomination, int size, int change) {
        if(change == 0)
            return 1;
        if(size<= 0 && change >0 || change < 0)
            return 0;
        return getNoOfWayToGetCoinChange(denomination, size -1, change) + getNoOfWayToGetCoinChange(denomination, size - 1, change - denomination[size -1]);
    }
}
