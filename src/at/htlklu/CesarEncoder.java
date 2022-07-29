package at.htlklu;

public class CesarEncoder {

    public static void main(String[] args) {

        String s = "Hello POS!";
        int key = 15;
        String encoded = CesarEncoder.encode(s, 15);
        System.out.printf("Verschlüsselt: %s \n", encoded);
        String decoded = CesarEncoder.decode(encoded, key);
        System.out.printf("Entschlüsselt: %s \n", decoded);
    }

    public static String encode(String input, int key) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char z = (char) ((input.charAt(i) + key + 256) % 256);
            sb.append(z);
        }
        return sb.toString();
    }


    public static String decode(String input, int key) {
        return encode(input, key * (-1));
    }
}
