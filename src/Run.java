import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		CaesarCipher cc;
		String key;
		Scanner s = new Scanner(System.in);
		String rep;

		do {
			System.out.println("Vuoi generare casualmente la chiave? (y/n)");
			String ans;
			do {
				ans = s.nextLine();
			} while (!ans.equals("y") && !ans.equals("n"));

			if (ans.equals("y")) {
				cc = new CaesarCipher();
			} else {
				System.out.println("Inserisci la chiave:");
				key = s.nextLine();
				cc = new CaesarCipher(key);
			}

			System.out.println("Inserisci il plain text: ");
			String plainText = s.nextLine();
			String cipherText = cc.Enc(plainText);
			String decodedText = cc.Dec(cipherText);
			key = cc.getKey();

			System.out.println("PlainText: " + plainText + '\n' + "Key: " + key + '\n' + "CipherText: " + cipherText
					+ '\n' + "Decoded Text: " + decodedText);
			System.out.println("Ripetere l'operazione? (y/n)");
			rep = s.nextLine();
		} while (rep.equals("y"));

		s.close();
	}

}