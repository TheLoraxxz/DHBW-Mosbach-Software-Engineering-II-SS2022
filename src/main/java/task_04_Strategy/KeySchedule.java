package task_04_Strategy;
import java.util.Arrays;

public class KeySchedule {
    private final int[][] permutedChoiceMatrix01 = {
            {57, 49, 41, 33, 25, 17, 9, 1},
            {58, 50, 42, 34, 26, 18, 10, 2},
            {59, 51, 43, 35, 27, 19, 11, 3},
            {60, 52, 44, 36, 63, 55, 47, 39},
            {31, 23, 15, 7, 62, 54, 46, 38},
            {30, 22, 14, 6, 61, 53, 45, 37},
            {29, 21, 13, 5, 28, 20, 12, 4}};

    private final int[][] permutedChoiceMatrix02 = {
            {14, 17, 11, 24, 1, 5, 3, 28},
            {15, 6, 21, 10, 23, 19, 12, 4},
            {26, 8, 16, 7, 27, 20, 13, 2},
            {41, 52, 31, 37, 47, 55, 30, 40},
            {51, 45, 33, 48, 44, 49, 39, 56},
            {34, 53, 46, 42, 50, 36, 29, 32}};

    public String permutedChoice01(String string) {
        char[] result = new char[56];

        for (int index = 0; index < 56; index++) {
            result[index] = string.charAt(permutedChoiceMatrix01[index / 8][index % 8] - 1);
        }
        return new String(result);
    }

    public String permutedChoice02(String string) {
        char[] result = new char[48];

        for (int index = 0; index < 48; index++) {
            result[index] = string.charAt(permutedChoiceMatrix02[index / 8][index % 8] - 1);
        }
        return new String(result);
    }

    public String[] generateSubKeysForEncryption(String string) {
        String[] result = new String[16];
        String temp = permutedChoice01(string);

        String c = temp.substring(0, 28);
        String d = temp.substring(28);

        for (int round = 1; round <= 16; round++) {
            if (round == 1 || round == 2 || round == 9 || round == 16) {
                c = c.substring(1) + c.charAt(0);
                d = d.substring(0, 27) + d.charAt(0);
            } else {
                c = d.substring(2) + c.substring(0, 2);
                d = d.substring(2) + d.substring(0, 2);
            }

            result[round - 1] = permutedChoice02(c + d);
        }
        return result;
    }

    public String[] generateSubKeysForDecryption(String string) {
        String[] result = new String[16];
        String temp = permutedChoice01(string);

        String c = temp.substring(0, 28);
        String d = temp.substring(28);

        for (int round = 1; round <= 16; round++) {
            if (round == 1) {
            } else if (round == 2 || round == 9 || round == 16) {
                c = c.charAt(27) + c.substring(0, 27);
                d = d.charAt(27) + d.substring(0, 27);
            } else {
                c = c.substring(26, 28) + c.substring(0, 26);
                d = d.substring(26, 28) + d.substring(0, 26);
            }

            result[round - 1] = permutedChoice02(c + d);
        }

        return result;
    }
}