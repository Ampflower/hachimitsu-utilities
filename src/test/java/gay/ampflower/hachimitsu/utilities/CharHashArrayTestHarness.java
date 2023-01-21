package gay.ampflower.hachimitsu.utilities;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.Executable;

import static gay.ampflower.hachimitsu.utilities.StringUtils.createCharHashArray;
import static gay.ampflower.hachimitsu.utilities.StringUtils.createCharHashArray0;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing harness for {@link StringUtils#createCharHashArray(String)} to ensure
 * that the expected output is not reference equal, but still content equal.
 */
class CharHashArrayTestHarness implements Executable {
	private final String toHash;
	private final char[] expected;

	CharHashArrayTestHarness(String toHash, char[] expected) {
		this.toHash = toHash;
		this.expected = expected;
	}

	static DynamicTest of(String name, String toHash, char[] expected) {
		return DynamicTest.dynamicTest(name, new CharHashArrayTestHarness(toHash, expected));
	}

	@Override
	public void execute() throws Throwable {
		// Test hashing with common caching.
		var actual1 = test(createCharHashArray(toHash));

		// Test hashing with no caching.
		var actual2 = test(createCharHashArray0(toHash));

		// Ensure no caching is done, and that the arrays are still equal to each other.
		assert actual1 != actual2 : "Caching detected.";
		assertArrayEquals(actual2, actual1);
	}

	private char[] test(char[] actual) {
		assert actual != expected : "Bad direct return.";
		assertArrayEquals(expected, actual);

		if (actual.length == 0) {
			assertTrue(toHash.isEmpty());
		} else {
			{
				char c = actual[0];
				if (c != '\uFFFF') {
					assertTrue(toHash.indexOf(c) >= 0);
				}
			}

			for (int i = 1, l = actual.length; i < l; i++) {
				char c = actual[i];
				if (c != 0) {
					assertTrue(toHash.indexOf(c) >= 0);
				}
			}

			for (int i = 0, l = toHash.length(), m = actual.length - 1; i < l; i++) {
				char c = toHash.charAt(i);
				assertEquals(c, actual[c & m]);
			}
		}

		return actual;
	}
}
