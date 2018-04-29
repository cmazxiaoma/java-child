
public class SearchKeyword {
	public static void main(String[] args) {
		String msg = "Look for a keyword in msg";
		String keyword = "key";
		boolean foundIt = false;
		int max = msg.length() - keyword.length();
		test: for (int i = 0; i <= max; i++) {
			int n = keyword.length();
			int j = i;
			int k = 0;
			while (n-- != 0) {
				if (msg.charAt(j++) != keyword.charAt(k++)) {
					continue test;
				}

			}
			foundIt = true;
			break;
		}
		System.out.println(foundIt ? "found it" : "Did not find it");

	}

}
