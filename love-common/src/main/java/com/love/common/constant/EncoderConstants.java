package com.love.common.constant;

import java.util.Arrays;

public final class EncoderConstants {
	/**
	 * !$*-.=?@_
	 */
	public static final char[] CHAR_PASSWORD_SPECIALS = { '!', '$', '*', '-', '.', '=', '?', '@', '_' };

	/**
	 * a-b
	 */
	public static final char[] CHAR_LOWERS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * A-Z
	 */
	public static final char[] CHAR_UPPERS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	/**
	 * 0-9
	 */
	public static final char[] CHAR_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * !$*+-.=?@^_|~
	 */
	public static final char[] CHAR_SPECIALS = { '!', '$', '*', '+', '-', '.', '=', '?', '@', '^', '_', '|', '~' };

	/**
	 * CHAR_LOWERS union CHAR_UPPERS
	 */
	public static final char[] CHAR_LETTERS = union(CHAR_LOWERS, CHAR_UPPERS);

	/**
	 * CHAR_LETTERS union CHAR_DIGITS
	 */
	public static final char[] CHAR_ALPHANUMERICS = union(CHAR_LETTERS, CHAR_DIGITS);

	/**
	 * Password character set, is alphanumerics (without l, i, I, o, O, and 0)
	 * selected specials like + (bad for URL encoding, | is like i and 1,
	 * etc...)
	 */
	public static final char[] CHAR_PASSWORD_LOWERS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * 
	 */
	public static final char[] CHAR_PASSWORD_UPPERS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * 2-9
	 */
	public static final char[] CHAR_PASSWORD_DIGITS = { '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * CHAR_PASSWORD_LOWERS union CHAR_PASSWORD_UPPERS
	 */
	public static final char[] CHAR_PASSWORD_LETTERS = union(CHAR_PASSWORD_LOWERS, CHAR_PASSWORD_UPPERS);

	private EncoderConstants() {
	}

	/**
	 * Union multiple character arrays.
	 * 
	 * @param list
	 *            the char[]s to union
	 * @return the union of the char[]s
	 */
	private static char[] union(char[]... list) {
		StringBuilder sb = new StringBuilder();

		for (char[] characters : list) {
			for (char c : characters) {
				if (!contains(sb, c))
					sb.append(c);
			}
		}

		char[] toReturn = new char[sb.length()];
		sb.getChars(0, sb.length(), toReturn, 0);
		Arrays.sort(toReturn);
		return toReturn;
	}

	/**
	 * Returns true if the character is contained in the provided StringBuilder.
	 * 
	 * @param input
	 *            The input
	 * @param c
	 *            The character to check for to see if {@code input} contains.
	 * @return True if the specified character is contained; false otherwise.
	 */
	private static boolean contains(StringBuilder input, char c) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == c)
				return true;
		}
		return false;
	}
}
