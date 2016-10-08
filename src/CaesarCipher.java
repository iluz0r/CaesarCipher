import java.util.Random;

public class CaesarCipher implements ClassicCipher {

	private String key;
	private Random rg;

	public CaesarCipher() {
		rg = new Random();
		key = genKey();
	}

	public CaesarCipher(String key) {
		this.key = key;
		rg = new Random();
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String genKey() {
		return String.valueOf((rg.nextInt(25) + 1));
	}

	@Override
	public String Enc(String plainText) {
		int k = Integer.valueOf(key);
		char[] buffer = plainText.toCharArray();

		for (int i = 0; i < plainText.length(); i++) {
			int asciiCode = (int) buffer[i];

			if (asciiCode >= 97 && asciiCode <= 122)
				buffer[i] = (char) (((asciiCode - 97 + k) % 26) + 97);
		}

		return String.valueOf(buffer);
	}

	@Override
	public String Dec(String cipherText) {
		int k = Integer.valueOf(key);
		char[] buffer = cipherText.toCharArray();

		for (int i = 0; i < cipherText.length(); i++) {
			int asciiCode = (int) buffer[i];

			if (asciiCode >= 97 && asciiCode <= 122) {
				int x = (asciiCode - 97 - k) % 26;

				if (x < 0)
					x += 26;

				buffer[i] = (char) (x + 97);
			}
		}

		return String.valueOf(buffer);
	}

}
