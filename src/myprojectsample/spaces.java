package myprojectsample;

public class spaces {

	// 1. Write code to get rid of multiple spaces from a string(without using
	// StringBuffer/String class)?

	public static void main(String[] args) {

		removeSpaces("E   asy   Pay F inance");

	}

	public static void removeSpaces(String str) {

		String remove = "";
		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			if (ch[i] != ' ') {

				remove += str.charAt(i);
			}

		}

		System.out.println(remove);

	}

}
