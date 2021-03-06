package rmit.p1.Lottery;

import rmit.p1.Customer.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotteryDrawing implements Lottery {
    // create a array with 6 numbers
    private int[] result = new int[6];

    @Override
    public int[] lottery() {
        int num;
        for (int i = 0; i < result.length; i++) {
            num = (int) (Math.random()*46); // generate a random number
            for (int x = 0; x < i; x++) {
                if (num == result[x]) { // if the number are repeated
                    num = (int) (Math.random()*46); // re-generate it
                }
            }
            result[i] = num; // add the number to array
        }
        return result;
    }
}
