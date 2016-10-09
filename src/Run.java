import java.util.Scanner;

public class Run {
	
	private static ClassicCipher c;
	private static Scanner s;

	public static void main(String[] args) {
	    c = new CaesarCipher();
		s = new Scanner(System.in);
		String ans, plainText, cipherText, decodedText;

		do {
			chooseKey();
			System.out.println("Inserisci il plain text: ");
			plainText = s.nextLine();
			cipherText = c.Enc(plainText);
			decodedText = c.Dec(cipherText);

			System.out.println("PlainText: " + plainText + '\n' + "Key: " + c.getKey() + '\n' + "CipherText: " + cipherText
					+ '\n' + "Decoded Text: " + decodedText);
			
			System.out.println("Ripetere l'operazione? (y/n)");
			ans = s.nextLine();
		} while (ans.equals("y"));

		s.close();
	}
	
	private static void chooseKey() {
		String ans, key;

		System.out.println("Vuoi generare casualmente la chiave? (y/n)");
		do {
			ans = s.nextLine();
		} while (!ans.equals("y") && !ans.equals("n"));

		if (ans.equals("y")) {
			c.setKey(c.genKey());
		} else {
			System.out.println("Inserisci la chiave:");
			do {
				key = s.nextLine();
			} while (!((CaesarCipher) c).checkKey(key));
			c.setKey(key);
		}
	}

}