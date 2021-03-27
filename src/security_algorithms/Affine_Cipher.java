package security_algorithms;

public class Affine_Cipher {
    private String Text;
    private int key, m, n;       // m is constant , n is the number of letters 

    public Affine_Cipher(String Text, int key, int m, int n) {
        this.Text = Text;
        this.key = key;
        this.m = m;
        this.n = n;
    }

//  Find Gcd between n , m
    private int findGCD(int n , int m) {
        if (m != 0) {
            return findGCD(m, n % m);
        }
        return n;
    }
    
// check if gcd = 1 or not 
    private int checkGCD() {
        if (findGCD(n, m) == 1) {
            return 1;
        }
        return 0;
    }

// find ciher text 
    public String findCipher() {
        if (checkGCD() == 1) {

            String cipherText = "";
            int letterNum;
            char letterChar;

            for (int i = 0; i < Text.length(); i++) {
                //initialize variables 
                letterNum = 0;
                letterChar = ' ';

                letterNum = (m * ((int) Text.charAt(i) - 65) + key) % n;//calculate number of the cipher text 
//                System.out.println(letterNum);
                letterNum = letterNum + 65;   //  back to the ascii 
                letterChar = (char) letterNum;
                cipherText = cipherText + letterChar;  // append cipher text 

            }
            return cipherText;
        }
        return "Failed";
    }

// for decryption 
    static int moduloInverse(int n1, int m1) {
        for (int i = 1; i < n1; i++) {
            if ((m1 * i) % n1 == 1) {
                return i;
            }

        }
        return 0;
    }

    public String findPlain() {
        if (checkGCD() == 1) {
            if (moduloInverse(n, m) != 0) {
                int inv_m = moduloInverse(n, m);
                String plainText = "";
                int letterNum;
                char letterChar;

                for (int i = 0; i < Text.length(); i++) {
                    //initialize variables 
                    letterNum = 0;
                    letterChar = ' ';
                    
                    letterNum = (inv_m * (((int) Text.charAt(i) - 65) - key)) % n;//calculate number of the plain text 
                    letterNum = (letterNum < 0 )? letterNum + 26 : letterNum ; // if negative numbers 

//                System.out.println(letterNum);
                    letterNum = letterNum + 65;   //  back to the ascii 
                    letterChar = (char) letterNum;
                    plainText = plainText + letterChar;  // append plain text 

                }
                return plainText;

            }
           
        }
         return "Failed";
    }
}
