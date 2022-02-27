package task_04_Strategy;

public class Utility {
    public static String convertStringToBits(String string) {
        byte[] bytes = string.getBytes();
        StringBuilder result = new StringBuilder();

        for (byte b : bytes) {
            int temp = b;
            for (int i = 0; i < 8; i++) {
                result.append((temp & 128) == 0 ? 0 : 1);
                temp = temp << 1;
            }

        }
        return result.toString();
    }

    public static String bitsToString(String bits) {
        byte[] bytes = new byte[8];

        for (int j = 0; j < 8; j++) {
            bytes[j] = 0;
        }

        for (int i = 0; i < bits.length(); i += 8) {
            for (int j = 0; j < 8; j++) {
                char ch = bits.charAt(i + j);
                if (ch == '1') {
                    bytes[i / 8] += (byte) Math.pow(2, 7 - j);
                } else if (ch != '0') {
                    System.out.println("Wrong input bits");

                }
            }
        }

        return new String(bytes);
    }
}