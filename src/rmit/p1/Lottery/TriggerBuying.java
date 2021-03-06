package rmit.p1.Lottery;

import java.util.Arrays;

public class TriggerBuying {
    private static int[] result = new int[6];

    // check if 2 array have the same elements (even different position)
    private static boolean isEqual(int[] a, int[] b){
        int count =0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i]==b[j])
                    count++;
            }
        }
        if (count == 6) return true;
        return false;
    }
    // reuse from lottery drawing
    public static int[] randomNums() {
        int num;
        for (int i = 0; i < 6; i++) {
            num = (int) (Math.random()*46);
            for (int x = 0; x < i; x++) {
                if (num == result[x]) {
                    num = (int) (Math.random()*46);
                }
            }
            result[i] = num;
        }
        return result;
    }
    public static int countingTimes(){
        Lottery lottery = new LotteryDrawing();
        int[] drawingResult = lottery.lottery(); // the lottery numbers
        int count = 1; // count from the first try, even if they are matched
        boolean match = false;
        while (!match) { // if not match
            int[] num1 = drawingResult; //NOT re-generate the numbers
            int[] num2 = randomNums(); // re-generate when loop

            if (isEqual(num1,num2)) { // if all the elements are the equal
                match = true; // end the loop
                System.out.println("The LOTTERY numbers are : " + Arrays.toString(num1));
                System.out.println("The RANDOM numbers are : " + Arrays.toString(num2));
                System.out.println("They are matched after " + count + " times");
            }
            else {
                count++; //add to the counter
            }
        }
        return count;
    }
    // run the trigger 5 times and calculate average
    public static double average(){
        int sum =0;
        for (int i = 0; i < 5; i++) {
            int n = countingTimes();
            sum += n;
        }
        return sum/5;
    }
}
