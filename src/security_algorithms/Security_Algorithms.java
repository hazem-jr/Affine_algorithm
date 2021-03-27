package security_algorithms;

public class Security_Algorithms {

    public static void main(String[] args) {
//        Affine_Cipher ac1 = new Affine_Cipher("WARLAST", 10, 7, 26);
//        System.out.println(ac1.findCipher());
        Affine_Cipher ac2 = new Affine_Cipher("IKZJKGN", 10, 7, 26);
        System.out.println(ac2.findPlain());
           
    }


}
