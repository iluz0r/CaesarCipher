import java.util.Random;

public class CaesarCipher implements ClassicCipher {

	private String key;
	private Random rg;

	public CaesarCipher() {
		rg = new Random();
	}

	@Override
	public void setKey(String key) throws Exception {
		if (checkKey(key))
			this.key = key;
		else
			throw new Exception();
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
		StringBuffer buffer = new StringBuffer();

		for (char c : plainText.toCharArray()) {
			int asciiCode = (int) c;

			if (asciiCode >= 97 && asciiCode <= 122)
				buffer.append((char) (((asciiCode - 97 + k) % 26) + 97));
			else
				buffer.append(c);
		}

		return buffer.toString();
	}

	@Override
	public String Dec(String cipherText) {
		int k = Integer.valueOf(key);
		StringBuffer buffer = new StringBuffer();

		for (char c : cipherText.toCharArray()) {
			int asciiCode = (int) c;

			if (asciiCode >= 97 && asciiCode <= 122) {
				int x = (asciiCode - 97 - k) % 26;

				if (x < 0)
					x += 26;

				buffer.append((char) (x + 97));
			} else
				buffer.append(c);
		}

		return buffer.toString();
	}

	private boolean checkKey(String key) {
		return (Integer.valueOf(key) > 0 && Integer.valueOf(key) < 26);
	}

}
