package gay.ampflower.hachimitsu.utilities;

import gay.ampflower.hachimitsu.utilities.functions.FuncIOOO_O;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static gay.ampflower.hachimitsu.utilities.ParseIntegerTestHarness.ofParseInt;
import static gay.ampflower.hachimitsu.utilities.ParseLongTestHarness.ofParseLong;
import static gay.ampflower.hachimitsu.utilities.StringUtils.*;

/**
 * Tests {@link StringUtils}.
 *
 * @author Ampflower
 * @since ${version}
 **/
public class StringUtilsTest {
	private static final String
		INVALID_EMPTY = "",
		PINEAPPLE = "Pineapple",
		ZERO = "0",
		NEGATIVE_ONE = "-1",
		INT_R02_S_MAX_VALUE = Integer.toString(Integer.MAX_VALUE, 2),
		INT_R02_S_MIN_VALUE = Integer.toString(Integer.MIN_VALUE, 2),
		INT_R02_U_MIN_VALUE = Integer.toUnsignedString(Integer.MIN_VALUE, 2),
		INT_R02_U_NEGATIVE_ONE = Integer.toUnsignedString(-1, 2),
		LONG_R02_S_MAX_VALUE = Long.toString(Long.MAX_VALUE, 2),
		LONG_R02_S_MIN_VALUE = Long.toString(Long.MIN_VALUE, 2),
		LONG_R02_U_MIN_VALUE = Long.toUnsignedString(Long.MIN_VALUE, 2),
		LONG_R02_U_NEGATIVE_ONE = Long.toUnsignedString(-1L, 2),
		INT_R08_S_MAX_VALUE = Integer.toString(Integer.MAX_VALUE, 8),
		INT_R08_S_MIN_VALUE = Integer.toString(Integer.MIN_VALUE, 8),
		INT_R08_U_MIN_VALUE = Integer.toUnsignedString(Integer.MIN_VALUE, 8),
		INT_R08_U_NEGATIVE_ONE = Integer.toUnsignedString(-1, 8),
		LONG_R08_S_MAX_VALUE = Long.toString(Long.MAX_VALUE, 8),
		LONG_R08_S_MIN_VALUE = Long.toString(Long.MIN_VALUE, 8),
		LONG_R08_U_MIN_VALUE = Long.toUnsignedString(Long.MIN_VALUE, 8),
		LONG_R08_U_NEGATIVE_ONE = Long.toUnsignedString(-1L, 8),
		INT_R10_S_MAX_VALUE = Integer.toString(Integer.MAX_VALUE),
		INT_R10_S_MIN_VALUE = Integer.toString(Integer.MIN_VALUE),
		INT_R10_U_MIN_VALUE = Integer.toUnsignedString(Integer.MIN_VALUE),
		INT_R10_U_NEGATIVE_ONE = Integer.toUnsignedString(-1),
		LONG_R10_S_MAX_VALUE = Long.toString(Long.MAX_VALUE),
		LONG_R10_S_MIN_VALUE = Long.toString(Long.MIN_VALUE),
		LONG_R10_U_MIN_VALUE = Long.toUnsignedString(Long.MIN_VALUE),
		LONG_R10_U_NEGATIVE_ONE = Long.toUnsignedString(-1L),
		INT_R16_S_MAX_VALUE = Integer.toString(Integer.MAX_VALUE, 16),
		INT_R16_S_MIN_VALUE = Integer.toString(Integer.MIN_VALUE, 16),
		INT_R16_U_MIN_VALUE = Integer.toUnsignedString(Integer.MIN_VALUE, 16),
		INT_R16_U_NEGATIVE_ONE = Integer.toUnsignedString(-1, 16),
		LONG_R16_S_MAX_VALUE = Long.toString(Long.MAX_VALUE, 16),
		LONG_R16_S_MIN_VALUE = Long.toString(Long.MIN_VALUE, 16),
		LONG_R16_U_MIN_VALUE = Long.toUnsignedString(Long.MIN_VALUE, 16),
		LONG_R16_U_NEGATIVE_ONE = Long.toUnsignedString(-1L, 16),
		INT_R36_S_MAX_VALUE = Integer.toString(Integer.MAX_VALUE, 36),
		INT_R36_S_MIN_VALUE = Integer.toString(Integer.MIN_VALUE, 36),
		INT_R36_U_MIN_VALUE = Integer.toUnsignedString(Integer.MIN_VALUE, 36),
		INT_R36_U_NEGATIVE_ONE = Integer.toUnsignedString(-1, 36),
		LONG_R36_S_MAX_VALUE = Long.toString(Long.MAX_VALUE, 36),
		LONG_R36_S_MIN_VALUE = Long.toString(Long.MIN_VALUE, 36),
		LONG_R36_U_MIN_VALUE = Long.toUnsignedString(Long.MIN_VALUE, 36),
		LONG_R36_U_NEGATIVE_ONE = Long.toUnsignedString(-1L, 36);

	private static final Long
		I32_MAX_VALUE = 0x00000000_7FFFFFFFL,
		I32_MIN_VALUE = 0xFFFFFFFF_80000000L,
		U32_MIN_VALUE = 0x80000000L,
		U32_MAX_VALUE = 0xFFFFFFFFL;


	/**
	 * Tests {@link StringUtils#createCharHashArray(String)} and
	 * {@link StringUtils#createCharHashArray0(String)} with 4 built-ins and an empty string.
	 */
	@TestFactory
	public Iterable<DynamicTest> hashedStrings() {
		return List.of(
			CharHashArrayTestHarness.of("defaultDelimiters", DEFAULT_DELIMITERS, ARRAY_DEFAULT_DELIMITERS),
			CharHashArrayTestHarness.of("quotes", QUOTES, ARRAY_QUOTES),
			CharHashArrayTestHarness.of("quotePaired", QUOTE_PAIRED, ARRAY_QUOTE_PAIRED),
			CharHashArrayTestHarness.of("hexDigits", HEX_DIGITS, ARRAY_HEX_DIGITS),
			CharHashArrayTestHarness.of("empty", "", new char[0])
		);
	}

	/**
	 * Tests {@link StringUtils#parseInt(String, int, int, int, int)}
	 */
	@TestFactory
	public Iterable<DynamicTest> parseInts() {
		return List.of(
			ofParseInt(2, 0, ZERO, "R2 - R10 Zero"),
			ofParseInt(2, -1, NEGATIVE_ONE, "R2 - R10 Negative One"),
			ofParseInt(2, null, INVALID_EMPTY, "R2 Invalid - Empty"),
			ofParseInt(2, null, PINEAPPLE, "R2 Invalid - 'Pineapple'"),
			ofParseInt(2, Integer.MAX_VALUE, INT_R02_S_MAX_VALUE, "R2 - R2 Max Value"),
			ofParseInt(2, Integer.MIN_VALUE, INT_R02_S_MIN_VALUE, "R2 - R2 Min Value as Signed"),
			ofParseInt(2, null, INT_R02_U_MIN_VALUE, "R2 Invalid - R2 Min Value as Unsigned"),
			ofParseInt(2, null, INT_R02_U_NEGATIVE_ONE, "R2 Invalid - R2 Unsigned Max Value"),
			ofParseInt(2, null, INT_R08_S_MAX_VALUE, "R2 Invalid - R8 Max Value"),
			ofParseInt(2, null, INT_R08_S_MIN_VALUE, "R2 Invalid - R8 Min Value as Signed"),
			ofParseInt(2, null, INT_R08_U_MIN_VALUE, "R2 Invalid - R8 Min Value as Unsigned"),
			ofParseInt(2, null, INT_R08_U_NEGATIVE_ONE, "R2 Invalid - R8 Unsigned Max Value"),
			ofParseInt(2, null, INT_R10_S_MAX_VALUE, "R2 Invalid - R10 Max Value"),
			ofParseInt(2, null, INT_R10_S_MIN_VALUE, "R2 Invalid - R10 Min Value as Signed"),
			ofParseInt(2, null, INT_R10_U_MIN_VALUE, "R2 Invalid - R10 Min Value as Unsigned"),
			ofParseInt(2, null, INT_R10_U_NEGATIVE_ONE, "R2 Invalid - R10 Unsigned Max Value"),
			ofParseInt(2, null, INT_R16_S_MAX_VALUE, "R2 Invalid - R16 Max Value"),
			ofParseInt(2, null, INT_R16_S_MIN_VALUE, "R2 Invalid - R16 Min Value as Signed"),
			ofParseInt(2, null, INT_R16_U_MIN_VALUE, "R2 Invalid - R16 Min Value as Unsigned"),
			ofParseInt(2, null, INT_R16_U_NEGATIVE_ONE, "R2 Invalid - R16 Unsigned Max Value"),
			ofParseInt(2, null, INT_R36_S_MAX_VALUE, "R2 Invalid - R36 Max Value"),
			ofParseInt(2, null, INT_R36_S_MIN_VALUE, "R2 Invalid - R36 Min Value as Signed"),
			ofParseInt(2, null, INT_R36_U_MIN_VALUE, "R2 Invalid - R36 Min Value as Unsigned"),
			ofParseInt(2, null, INT_R36_U_NEGATIVE_ONE, "R2 Invalid - R36 Unsigned Max Value"),

			ofParseInt(10, 0, ZERO, "R10 - R10 Zero"),
			ofParseInt(10, -1, NEGATIVE_ONE, "R10 - R10 Negative One"),
			ofParseInt(10, null, INVALID_EMPTY, "R10 Invalid - Empty"),
			ofParseInt(10, null, PINEAPPLE, "R10 Invalid - 'Pineapple'"),
			ofParseInt(10, null, INT_R02_S_MAX_VALUE, "R10 Invalid - R2 Max Value"),
			ofParseInt(10, null, INT_R02_S_MIN_VALUE, "R10 Invalid - R2 Min Value as Signed"),
			ofParseInt(10, null, INT_R02_U_MIN_VALUE, "R10 Invalid - R2 Min Value as Unsigned"),
			ofParseInt(10, null, INT_R02_U_NEGATIVE_ONE, "R10 Invalid - R2 Unsigned Max Value"),
			ofParseInt(10, null, INT_R08_S_MAX_VALUE, "R10 Invalid - R8 Max Value"),
			ofParseInt(10, null, INT_R08_S_MIN_VALUE, "R10 Invalid - R8 Min Value as Signed"),
			ofParseInt(10, null, INT_R08_U_MIN_VALUE, "R10 Invalid - R8 Min Value as Unsigned"),
			ofParseInt(10, null, INT_R08_U_NEGATIVE_ONE, "R10 Invalid - R8 Unsigned Max Value"),
			ofParseInt(10, Integer.MAX_VALUE, INT_R10_S_MAX_VALUE, "R10 - R10 Max Value"),
			ofParseInt(10, Integer.MIN_VALUE, INT_R10_S_MIN_VALUE, "R10 - R10 Min Value as Signed"),
			ofParseInt(10, null, INT_R10_U_MIN_VALUE, "R10 Invalid - R10 Min Value as Unsigned"),
			ofParseInt(10, null, INT_R10_U_NEGATIVE_ONE, "R10 Invalid - R10 Unsigned Max Value"),
			ofParseInt(10, null, INT_R16_S_MAX_VALUE, "R10 Invalid - R16 Max Value"),
			ofParseInt(10, -80000000, INT_R16_S_MIN_VALUE, "R10 - R16 Min Value as Signed"),
			ofParseInt(10, 80000000, INT_R16_U_MIN_VALUE, "R10 - R16 Min Value as Unsigned"),
			ofParseInt(10, null, INT_R16_U_NEGATIVE_ONE, "R10 Invalid - R16 Unsigned Max Value"),
			ofParseInt(10, null, INT_R36_S_MAX_VALUE, "R10 Invalid - R36 Max Value"),
			ofParseInt(10, null, INT_R36_S_MIN_VALUE, "R10 Invalid - R36 Min Value as Signed"),
			ofParseInt(10, null, INT_R36_U_MIN_VALUE, "R10 Invalid - R36 Min Value as Unsigned"),
			ofParseInt(10, null, INT_R36_U_NEGATIVE_ONE, "R10 Invalid - R36 Unsigned Max Value"),

			ofParseInt(16, 0, ZERO, "R16 - R10 Zero"),
			ofParseInt(16, -1, NEGATIVE_ONE, "R16 - R10 Negative One"),
			ofParseInt(16, null, INVALID_EMPTY, "R16 Invalid - Empty"),
			ofParseInt(16, null, PINEAPPLE, "R16 Invalid - 'Pineapple'"),
			ofParseInt(16, null, INT_R02_S_MAX_VALUE, "R16 Invalid - R2 Max Value"),
			ofParseInt(16, null, INT_R02_S_MIN_VALUE, "R16 Invalid - R2 Min Value as Signed"),
			ofParseInt(16, null, INT_R02_U_MIN_VALUE, "R16 Invalid - R2 Min Value as Unsigned"),
			ofParseInt(16, null, INT_R02_U_NEGATIVE_ONE, "R16 Invalid - R2 Unsigned Max Value"),
			ofParseInt(16, null, INT_R08_S_MAX_VALUE, "R16 Invalid - R8 Max Value"),
			ofParseInt(16, null, INT_R08_S_MIN_VALUE, "R16 Invalid - R8 Min Value as Signed"),
			ofParseInt(16, null, INT_R08_U_MIN_VALUE, "R16 Invalid - R8 Min Value as Unsigned"),
			ofParseInt(16, null, INT_R08_U_NEGATIVE_ONE, "R16 Invalid - R8 Unsigned Max Value"),
			ofParseInt(16, null, INT_R10_S_MAX_VALUE, "R16 Invalid - R10 Max Value"),
			ofParseInt(16, null, INT_R10_S_MIN_VALUE, "R16 Invalid - R10 Min Value as Signed"),
			ofParseInt(16, null, INT_R10_U_MIN_VALUE, "R16 Invalid - R10 Min Value as Unsigned"),
			ofParseInt(16, null, INT_R10_U_NEGATIVE_ONE, "R16 Invalid - R10 Unsigned Max Value"),
			ofParseInt(16, Integer.MAX_VALUE, INT_R16_S_MAX_VALUE, "R16 - R16 Max Value"),
			ofParseInt(16, Integer.MIN_VALUE, INT_R16_S_MIN_VALUE, "R16 - R16 Min Value as Signed"),
			ofParseInt(16, null, INT_R16_U_MIN_VALUE, "R16 Invalid - R16 Min Value as Unsigned"),
			ofParseInt(16, null, INT_R16_U_NEGATIVE_ONE, "R16 Invalid - R16 Unsigned Max Value"),
			ofParseInt(16, null, INT_R36_S_MAX_VALUE, "R16 Invalid - R36 Max Value"),
			ofParseInt(16, null, INT_R36_S_MIN_VALUE, "R16 Invalid - R36 Min Value as Signed"),
			ofParseInt(16, null, INT_R36_U_MIN_VALUE, "R16 Invalid - R36 Min Value as Unsigned"),
			ofParseInt(16, null, INT_R36_U_NEGATIVE_ONE, "R16 Invalid - R36 Unsigned Max Value"),


			ofParseInt(36, 0, ZERO, "R36 - R10 Zero"),
			ofParseInt(36, -1, NEGATIVE_ONE, "R36 - R10 Negative One"),
			ofParseInt(36, null, INVALID_EMPTY, "R36 Invalid - Empty"),
			ofParseInt(36, null, PINEAPPLE, "R36 Invalid - 'Pineapple'"),
			ofParseInt(36, null, INT_R02_S_MAX_VALUE, "R36 Invalid - R2 Max Value"),
			ofParseInt(36, null, INT_R02_S_MIN_VALUE, "R36 Invalid - R2 Min Value as Signed"),
			ofParseInt(36, null, INT_R02_U_MIN_VALUE, "R36 Invalid - R2 Min Value as Unsigned"),
			ofParseInt(36, null, INT_R02_U_NEGATIVE_ONE, "R36 Invalid - R2 Unsigned Max Value"),
			ofParseInt(36, null, INT_R08_S_MAX_VALUE, "R36 Invalid - R8 Max Value"),
			ofParseInt(36, null, INT_R08_S_MIN_VALUE, "R36 Invalid - R8 Min Value as Signed"),
			ofParseInt(36, null, INT_R08_U_MIN_VALUE, "R36 Invalid - R8 Min Value as Unsigned"),
			ofParseInt(36, null, INT_R08_U_NEGATIVE_ONE, "R36 Invalid - R8 Unsigned Max Value"),
			ofParseInt(36, null, INT_R10_S_MAX_VALUE, "R36 Invalid - R10 Max Value"),
			ofParseInt(36, null, INT_R10_S_MIN_VALUE, "R36 Invalid - R10 Min Value as Signed"),
			ofParseInt(36, null, INT_R10_U_MIN_VALUE, "R36 Invalid - R10 Min Value as Unsigned"),
			ofParseInt(36, null, INT_R10_U_NEGATIVE_ONE, "R36 Invalid - R10 Unsigned Max Value"),
			ofParseInt(36, null, INT_R16_S_MAX_VALUE, "R36 Invalid - R16 Max Value"),
			ofParseInt(36, null, INT_R16_S_MIN_VALUE, "R36 Invalid - R16 Min Value as Signed"),
			ofParseInt(36, null, INT_R16_U_MIN_VALUE, "R36 Invalid - R16 Min Value as Unsigned"),
			ofParseInt(36, null, INT_R16_U_NEGATIVE_ONE, "R36 Invalid - R16 Unsigned Max Value"),
			ofParseInt(36, Integer.MAX_VALUE, INT_R36_S_MAX_VALUE, "R36 - R36 Max Value"),
			ofParseInt(36, Integer.MIN_VALUE, INT_R36_S_MIN_VALUE, "R36 - R36 Min Value as Signed"),
			ofParseInt(36, null, INT_R36_U_MIN_VALUE, "R36 Invalid - R36 Min Value as Unsigned"),
			ofParseInt(36, null, INT_R36_U_NEGATIVE_ONE, "R36 Invalid - R36 Unsigned Max Value")
		);
	}

	/**
	 * Tests {@link StringUtils#parseLong(String, int, int, long, int)}
	 */
	@TestFactory
	public Iterable<DynamicTest> parseLongs() {
		return TestUtils.concat(
			knownPassingUnsignedLongs(ParseLongTestHarness::ofParseLong),
			knownPassingSignedLongs(ParseLongTestHarness::ofParseLong),
			List.of(
				ofParseLong(2, null, INVALID_EMPTY, "Int R2 Invalid - Empty"),
				ofParseLong(2, null, PINEAPPLE, "Int R2 Invalid - 'Pineapple'"),
				ofParseLong(2, null, INT_R08_S_MAX_VALUE, "Int R2 Invalid - R8 Max Value"),
				ofParseLong(2, null, INT_R08_S_MIN_VALUE, "Int R2 Invalid - R8 Min Value as Signed"),
				ofParseLong(2, null, INT_R08_U_MIN_VALUE, "Int R2 Invalid - R8 Min Value as Unsigned"),
				ofParseLong(2, null, INT_R08_U_NEGATIVE_ONE, "Int R2 Invalid - R8 Unsigned Max Value"),
				ofParseLong(2, null, INT_R10_S_MAX_VALUE, "Int R2 Invalid - R10 Max Value"),
				ofParseLong(2, null, INT_R10_S_MIN_VALUE, "Int R2 Invalid - R10 Min Value as Signed"),
				ofParseLong(2, null, INT_R10_U_MIN_VALUE, "Int R2 Invalid - R10 Min Value as Unsigned"),
				ofParseLong(2, null, INT_R10_U_NEGATIVE_ONE, "Int R2 Invalid - R10 Unsigned Max Value"),
				ofParseLong(2, null, INT_R16_S_MAX_VALUE, "Int R2 Invalid - R16 Max Value"),
				ofParseLong(2, null, INT_R16_S_MIN_VALUE, "Int R2 Invalid - R16 Min Value as Signed"),
				ofParseLong(2, null, INT_R16_U_MIN_VALUE, "Int R2 Invalid - R16 Min Value as Unsigned"),
				ofParseLong(2, null, INT_R16_U_NEGATIVE_ONE, "Int R2 Invalid - R16 Unsigned Max Value"),
				ofParseLong(2, null, INT_R36_S_MAX_VALUE, "Int R2 Invalid - R36 Max Value"),
				ofParseLong(2, null, INT_R36_S_MIN_VALUE, "Int R2 Invalid - R36 Min Value as Signed"),
				ofParseLong(2, null, INT_R36_U_MIN_VALUE, "Int R2 Invalid - R36 Min Value as Unsigned"),
				ofParseLong(2, null, INT_R36_U_NEGATIVE_ONE, "Int R2 Invalid - R36 Unsigned Max Value"),

				ofParseLong(10, null, INVALID_EMPTY, "Int R10 Invalid - Empty"),
				ofParseLong(10, null, PINEAPPLE, "Int R10 Invalid - 'Pineapple'"),
				ofParseLong(10, null, INT_R02_S_MAX_VALUE, "Int R10 Invalid - R2 Max Value"),
				ofParseLong(10, null, INT_R02_S_MIN_VALUE, "Int R10 Invalid - R2 Min Value as Signed"),
				ofParseLong(10, null, INT_R02_U_MIN_VALUE, "Int R10 Invalid - R2 Min Value as Unsigned"),
				ofParseLong(10, null, INT_R02_U_NEGATIVE_ONE, "Int R10 Invalid - R2 Unsigned Max Value"),
				ofParseLong(10, null, INT_R16_S_MAX_VALUE, "Int R10 Invalid - R16 Max Value"),
				ofParseLong(10, null, INT_R16_U_NEGATIVE_ONE, "Int R10 Invalid - R16 Unsigned Max Value"),
				ofParseLong(10, null, INT_R36_S_MAX_VALUE, "Int R10 Invalid - R36 Max Value"),
				ofParseLong(10, null, INT_R36_S_MIN_VALUE, "Int R10 Invalid - R36 Min Value as Signed"),
				ofParseLong(10, null, INT_R36_U_MIN_VALUE, "Int R10 Invalid - R36 Min Value as Unsigned"),
				ofParseLong(10, null, INT_R36_U_NEGATIVE_ONE, "Int R10 Invalid - R36 Unsigned Max Value"),

				ofParseLong(16, null, INVALID_EMPTY, "Int R16 Invalid - Empty"),
				ofParseLong(16, null, PINEAPPLE, "Int R16 Invalid - 'Pineapple'"),
				ofParseLong(16, null, INT_R02_S_MAX_VALUE, "Int R16 Invalid - R2 Max Value"),
				ofParseLong(16, null, INT_R02_S_MIN_VALUE, "Int R16 Invalid - R2 Min Value as Signed"),
				ofParseLong(16, null, INT_R02_U_MIN_VALUE, "Int R16 Invalid - R2 Min Value as Unsigned"),
				ofParseLong(16, null, INT_R02_U_NEGATIVE_ONE, "Int R16 Invalid - R2 Unsigned Max Value"),
				ofParseLong(16, null, INT_R36_S_MAX_VALUE, "Int R16 Invalid - R36 Max Value"),
				ofParseLong(16, null, INT_R36_S_MIN_VALUE, "Int R16 Invalid - R36 Min Value as Signed"),
				ofParseLong(16, null, INT_R36_U_MIN_VALUE, "Int R16 Invalid - R36 Min Value as Unsigned"),
				ofParseLong(16, null, INT_R36_U_NEGATIVE_ONE, "Int R16 Invalid - R36 Unsigned Max Value"),


				ofParseLong(36, null, INVALID_EMPTY, "Int R36 Invalid - Empty"),
				ofParseLong(36, null, INT_R02_S_MAX_VALUE, "Int R36 Invalid - R2 Max Value"),
				ofParseLong(36, null, INT_R02_S_MIN_VALUE, "Int R36 Invalid - R2 Min Value as Signed"),
				ofParseLong(36, null, INT_R02_U_MIN_VALUE, "Int R36 Invalid - R2 Min Value as Unsigned"),
				ofParseLong(36, null, INT_R02_U_NEGATIVE_ONE, "Int R36 Invalid - R2 Unsigned Max Value"),

				ofParseLong(2, null, INVALID_EMPTY, "Long R2 Invalid - Empty"),
				ofParseLong(2, null, PINEAPPLE, "Long R2 Invalid - 'Pineapple'"),
				ofParseLong(2, null, LONG_R02_U_MIN_VALUE, "Long R2 Invalid - R2 Min Value as Unsigned"),
				ofParseLong(2, null, LONG_R02_U_NEGATIVE_ONE, "Long R2 Invalid - R2 Unsigned Max Value"),
				ofParseLong(2, null, LONG_R08_S_MAX_VALUE, "Long R2 Invalid - R8 Max Value"),
				ofParseLong(2, null, LONG_R08_U_NEGATIVE_ONE, "Long R2 Invalid - R8 Unsigned Max Value"),
				ofParseLong(2, null, LONG_R10_S_MAX_VALUE, "Long R2 Invalid - R10 Max Value"),
				ofParseLong(2, null, LONG_R10_S_MIN_VALUE, "Long R2 Invalid - R10 Min Value as Signed"),
				ofParseLong(2, null, LONG_R10_U_MIN_VALUE, "Long R2 Invalid - R10 Min Value as Unsigned"),
				ofParseLong(2, null, LONG_R10_U_NEGATIVE_ONE, "Long R2 Invalid - R10 Unsigned Max Value"),
				ofParseLong(2, null, LONG_R16_S_MAX_VALUE, "Long R2 Invalid - R16 Max Value"),
				ofParseLong(2, null, LONG_R16_S_MIN_VALUE, "Long R2 Invalid - R16 Min Value as Signed"),
				ofParseLong(2, null, LONG_R16_U_MIN_VALUE, "Long R2 Invalid - R16 Min Value as Unsigned"),
				ofParseLong(2, null, LONG_R16_U_NEGATIVE_ONE, "Long R2 Invalid - R16 Unsigned Max Value"),
				ofParseLong(2, null, LONG_R36_S_MAX_VALUE, "Long R2 Invalid - R36 Max Value"),
				ofParseLong(2, null, LONG_R36_S_MIN_VALUE, "Long R2 Invalid - R36 Min Value as Signed"),
				ofParseLong(2, null, LONG_R36_U_MIN_VALUE, "Long R2 Invalid - R36 Min Value as Unsigned"),
				ofParseLong(2, null, LONG_R36_U_NEGATIVE_ONE, "Long R2 Invalid - R36 Unsigned Max Value"),

				ofParseLong(10, null, INVALID_EMPTY, "Long R10 Invalid - Empty"),
				ofParseLong(10, null, PINEAPPLE, "Long R10 Invalid - 'Pineapple'"),
				ofParseLong(10, null, LONG_R02_S_MAX_VALUE, "Long R10 Invalid - R2 Max Value"),
				ofParseLong(10, null, LONG_R02_S_MIN_VALUE, "Long R10 Invalid - R2 Min Value as Signed"),
				ofParseLong(10, null, LONG_R02_U_MIN_VALUE, "Long R10 Invalid - R2 Min Value as Unsigned"),
				ofParseLong(10, null, LONG_R02_U_NEGATIVE_ONE, "Long R10 Invalid - R2 Unsigned Max Value"),
				ofParseLong(10, null, LONG_R08_S_MAX_VALUE, "Long R10 Invalid - R8 Max Value"),
				ofParseLong(10, null, LONG_R08_S_MIN_VALUE, "Long R10 Invalid - R8 Min Value as Signed"),
				ofParseLong(10, null, LONG_R08_U_MIN_VALUE, "Long R10 Invalid - R8 Min Value as Unsigned"),
				ofParseLong(10, null, LONG_R08_U_NEGATIVE_ONE, "Long R10 Invalid - R8 Unsigned Max Value"),
				ofParseLong(10, null, LONG_R10_U_MIN_VALUE, "Long R10 Invalid - R10 Min Value as Unsigned"),
				ofParseLong(10, null, LONG_R10_U_NEGATIVE_ONE, "Long R10 Invalid - R10 Unsigned Max Value"),
				ofParseLong(10, null, LONG_R16_S_MAX_VALUE, "Long R10 Invalid - R16 Max Value"),
				ofParseLong(10, null, LONG_R16_U_NEGATIVE_ONE, "Long R10 Invalid - R16 Unsigned Max Value"),
				ofParseLong(10, null, LONG_R36_S_MAX_VALUE, "Long R10 Invalid - R36 Max Value"),
				ofParseLong(10, null, LONG_R36_S_MIN_VALUE, "Long R10 Invalid - R36 Min Value as Signed"),
				ofParseLong(10, null, LONG_R36_U_MIN_VALUE, "Long R10 Invalid - R36 Min Value as Unsigned"),
				ofParseLong(10, null, LONG_R36_U_NEGATIVE_ONE, "Long R10 Invalid - R36 Unsigned Max Value"),

				ofParseLong(16, null, INVALID_EMPTY, "Long R16 Invalid - Empty"),
				ofParseLong(16, null, PINEAPPLE, "Long R16 Invalid - 'Pineapple'"),
				ofParseLong(16, null, LONG_R02_S_MAX_VALUE, "Long R16 Invalid - R2 Max Value"),
				ofParseLong(16, null, LONG_R02_S_MIN_VALUE, "Long R16 Invalid - R2 Min Value as Signed"),
				ofParseLong(16, null, LONG_R02_U_MIN_VALUE, "Long R16 Invalid - R2 Min Value as Unsigned"),
				ofParseLong(16, null, LONG_R02_U_NEGATIVE_ONE, "Long R16 Invalid - R2 Unsigned Max Value"),
				ofParseLong(16, null, LONG_R08_S_MAX_VALUE, "Long R16 Invalid - R8 Max Value"),
				ofParseLong(16, null, LONG_R08_S_MIN_VALUE, "Long R16 Invalid - R8 Min Value as Signed"),
				ofParseLong(16, null, LONG_R08_U_MIN_VALUE, "Long R16 Invalid - R8 Min Value as Unsigned"),
				ofParseLong(16, null, LONG_R08_U_NEGATIVE_ONE, "Long R16 Invalid - R8 Unsigned Max Value"),
				ofParseLong(16, null, LONG_R10_S_MAX_VALUE, "Long R16 Invalid - R10 Max Value"),
				ofParseLong(16, null, LONG_R10_S_MIN_VALUE, "Long R16 Invalid - R10 Min Value as Signed"),
				ofParseLong(16, null, LONG_R10_U_MIN_VALUE, "Long R16 Invalid - R10 Min Value as Unsigned"),
				ofParseLong(16, null, LONG_R10_U_NEGATIVE_ONE, "Long R16 Invalid - R10 Unsigned Max Value"),
				ofParseLong(16, null, LONG_R16_U_MIN_VALUE, "Long R16 Invalid - R16 Min Value as Unsigned"),
				ofParseLong(16, null, LONG_R16_U_NEGATIVE_ONE, "Long R16 Invalid - R16 Unsigned Max Value"),
				ofParseLong(16, null, LONG_R36_S_MAX_VALUE, "Long R16 Invalid - R36 Max Value"),
				ofParseLong(16, null, LONG_R36_S_MIN_VALUE, "Long R16 Invalid - R36 Min Value as Signed"),
				ofParseLong(16, null, LONG_R36_U_MIN_VALUE, "Long R16 Invalid - R36 Min Value as Unsigned"),
				ofParseLong(16, null, LONG_R36_U_NEGATIVE_ONE, "Long R16 Invalid - R36 Unsigned Max Value"),


				ofParseLong(36, null, INVALID_EMPTY, "Long R36 Invalid - Empty"),
				ofParseLong(36, null, LONG_R02_S_MAX_VALUE, "Long R36 Invalid - R2 Max Value"),
				ofParseLong(36, null, LONG_R02_S_MIN_VALUE, "Long R36 Invalid - R2 Min Value as Signed"),
				ofParseLong(36, null, LONG_R02_U_MIN_VALUE, "Long R36 Invalid - R2 Min Value as Unsigned"),
				ofParseLong(36, null, LONG_R02_U_NEGATIVE_ONE, "Long R36 Invalid - R2 Unsigned Max Value"),
				ofParseLong(36, null, LONG_R08_S_MAX_VALUE, "Long R36 Invalid - R8 Max Value"),
				ofParseLong(36, null, LONG_R08_S_MIN_VALUE, "Long R36 Invalid - R8 Min Value as Signed"),
				ofParseLong(36, null, LONG_R08_U_MIN_VALUE, "Long R36 Invalid - R8 Min Value as Unsigned"),
				ofParseLong(36, null, LONG_R08_U_NEGATIVE_ONE, "Long R36 Invalid - R8 Unsigned Max Value"),
				ofParseLong(36, null, LONG_R10_S_MAX_VALUE, "Long R36 Invalid - R10 Max Value"),
				ofParseLong(36, null, LONG_R10_S_MIN_VALUE, "Long R36 Invalid - R10 Min Value as Signed"),
				ofParseLong(36, null, LONG_R10_U_MIN_VALUE, "Long R36 Invalid - R10 Min Value as Unsigned"),
				ofParseLong(36, null, LONG_R10_U_NEGATIVE_ONE, "Long R36 Invalid - R10 Unsigned Max Value"),
				ofParseLong(36, null, LONG_R16_S_MAX_VALUE, "Long R36 Invalid - R16 Max Value"),
				ofParseLong(36, null, LONG_R16_S_MIN_VALUE, "Long R36 Invalid - R16 Min Value as Signed"),
				ofParseLong(36, null, LONG_R16_U_MIN_VALUE, "Long R36 Invalid - R16 Min Value as Unsigned"),
				ofParseLong(36, null, LONG_R16_U_NEGATIVE_ONE, "Long R36 Invalid - R16 Unsigned Max Value"),
				ofParseLong(36, null, LONG_R36_U_MIN_VALUE, "Long R36 Invalid - R36 Min Value as Unsigned"),
				ofParseLong(36, null, LONG_R36_U_NEGATIVE_ONE, "Long R36 Invalid - R36 Unsigned Max Value")
			)
		);
	}

	/**
	 * Tests {@link StringUtils#tryParseLong(String, int, int, long, int)}
	 */
	@TestFactory
	public Iterable<DynamicTest> tryParseLongs() {
		return TestUtils.concat(
			knownPassingUnsignedLongs(ParseLongTestHarness::ofTryParseLong),
			knownPassingSignedLongs(ParseLongTestHarness::ofTryParseLong),
			List.of(
				ParseLongTestHarness.of("Zero", "0", 10, 0L, StringUtils::tryParseLong),
				ParseLongTestHarness.of("Max Value", Long.toString(Long.MAX_VALUE), 10, Long.MAX_VALUE, StringUtils::tryParseLong),
				ParseLongTestHarness.of("Min Value as Signed", Long.toString(Long.MIN_VALUE), 10, Long.MIN_VALUE, StringUtils::tryParseLong),
				ParseLongTestHarness.of("Min Value as Unsigned", Long.toUnsignedString(Long.MIN_VALUE), 10, 9223372036854775800L, StringUtils::tryParseLong),
				ParseLongTestHarness.of("Negative One", "-1", 10, -1L, StringUtils::tryParseLong),
				ParseLongTestHarness.of("Unsigned Max Value", Long.toUnsignedString(-1L), 10, 1844674407370955161L, StringUtils::tryParseLong),
				ParseLongTestHarness.of("Invalid - Empty", "", 10, null, StringUtils::tryParseLong),
				ParseLongTestHarness.of("Invalid - 'Pineapple'", "Pineapple", 10, null, StringUtils::tryParseLong)
			)
		);
	}

	/**
	 * Tests {@link StringUtils#tryParseUnsignedLong(String, int, int, long, int)}
	 */
	@TestFactory
	public Iterable<DynamicTest> tryParseUnsignedLongs() {
		return TestUtils.concat(
			knownPassingUnsignedLongs(ParseLongTestHarness::ofTryParseUnsignedLong),
			List.of(
				ParseLongTestHarness.of("Min Value as Signed", Long.toString(Long.MIN_VALUE), 10, Long.MIN_VALUE, StringUtils::tryParseUnsignedLong),
				ParseLongTestHarness.of("Min Value as Unsigned", Long.toUnsignedString(Long.MIN_VALUE), 10, Long.MIN_VALUE, StringUtils::tryParseUnsignedLong),
				ParseLongTestHarness.of("Negative One", "-1", 10, 1L, StringUtils::tryParseUnsignedLong),
				ParseLongTestHarness.of("Unsigned Max Value", Long.toUnsignedString(-1L), 10, -1L, StringUtils::tryParseUnsignedLong)
			)
		);
	}

	private static Collection<DynamicTest> knownPassingSignedLongs(FuncIOOO_O<Long, String, String, DynamicTest> func) {
		return List.of(
			func.invoke(2, -1L, NEGATIVE_ONE, "Int R2 - R10 Negative One"),
			func.invoke(2, I32_MIN_VALUE, INT_R02_S_MIN_VALUE, "Int R2 - R2 Min Value as Signed"),

			func.invoke(10, -1L, NEGATIVE_ONE, "Int R10 - R10 Negative One"),
			func.invoke(10, -20000000000L, INT_R08_S_MIN_VALUE, "Int R10 - R8 Min Value as Signed"),
			func.invoke(10, I32_MIN_VALUE, INT_R10_S_MIN_VALUE, "Int R10 - R10 Min Value as Signed"),
			func.invoke(10, -80000000L, INT_R16_S_MIN_VALUE, "Int R10 - R16 Min Value as Signed"),

			func.invoke(16, -1L, NEGATIVE_ONE, "Int R16 - R10 Negative One"),
			func.invoke(16, -2199023255552L, INT_R08_S_MIN_VALUE, "Int R16 - R8 Min Value as Signed"),
			func.invoke(16, -142929835592L, INT_R10_S_MIN_VALUE, "Int R16 - R10 Min Value as Signed"),
			func.invoke(16, I32_MIN_VALUE, INT_R16_S_MIN_VALUE, "Int R16 - R16 Min Value as Signed"),

			func.invoke(36, -1L, NEGATIVE_ONE, "Int R36 - R10 Negative One"),
			func.invoke(36, -7312316880125952L, INT_R08_S_MIN_VALUE, "Int R36 - R8 Min Value as Signed"),
			func.invoke(36, -206269972826552L, INT_R10_S_MIN_VALUE, "Int R36 - R10 Min Value as Signed"),
			func.invoke(36, -626913312768L, INT_R16_S_MIN_VALUE, "Int R36 - R16 Min Value as Signed"),
			func.invoke(36, I32_MIN_VALUE, INT_R36_S_MIN_VALUE, "Int R36 - R36 Min Value as Signed"),

			func.invoke(2, -1L, NEGATIVE_ONE, "Long R2 - R10 Negative One"),
			func.invoke(2, -2097152L, LONG_R08_S_MIN_VALUE, "Long R2 - R8 Min Value as Signed"),

			func.invoke(10, -1L, NEGATIVE_ONE, "Long R10 - R10 Negative One"),
			func.invoke(10, -8000000000000000L, LONG_R16_S_MIN_VALUE, "Long R10 - R16 Min Value as Signed"),

			func.invoke(16, -1L, NEGATIVE_ONE, "Long R16 - R10 Negative One"),

			func.invoke(36, -1L, NEGATIVE_ONE, "Long R36 - R10 Negative One")
		);
	}

	private static Collection<DynamicTest> knownPassingUnsignedLongs(FuncIOOO_O<Long, String, String, DynamicTest> func) {
		return List.of(
			func.invoke(2, 0L, ZERO, "Int R2 - R10 Zero"),
			func.invoke(2, I32_MAX_VALUE, INT_R02_S_MAX_VALUE, "Int R2 - R2 Max Value"),
			func.invoke(2, U32_MIN_VALUE, INT_R02_U_MIN_VALUE, "Int R2 - R2 Min Value as Unsigned"),
			func.invoke(2, U32_MAX_VALUE, INT_R02_U_NEGATIVE_ONE, "Int R2 - R2 Unsigned Max Value"),

			func.invoke(10, 0L, ZERO, "Int R10 - R10 Zero"),
			func.invoke(10, 17777777777L, INT_R08_S_MAX_VALUE, "Int R10 - R8 Max Value"),
			func.invoke(10, 20000000000L, INT_R08_U_MIN_VALUE, "Int R10 - R8 Min Value as Unsigned"),
			func.invoke(10, 37777777777L, INT_R08_U_NEGATIVE_ONE, "Int R10 - R8 Unsigned Max Value"),
			func.invoke(10, I32_MAX_VALUE, INT_R10_S_MAX_VALUE, "Int R10 - R10 Max Value"),
			func.invoke(10, U32_MIN_VALUE, INT_R10_U_MIN_VALUE, "Int R10 - R10 Min Value as Unsigned"),
			func.invoke(10, U32_MAX_VALUE, INT_R10_U_NEGATIVE_ONE, "Int R10 - R10 Unsigned Max Value"),
			func.invoke(10, 80000000L, INT_R16_U_MIN_VALUE, "Int R10 - R16 Min Value as Unsigned"),

			func.invoke(16, 0L, ZERO, "Int R16 - R10 Zero"),
			func.invoke(16, 1612617054071L, INT_R08_S_MAX_VALUE, "Int R16 - R8 Max Value"),
			func.invoke(16, 2199023255552L, INT_R08_U_MIN_VALUE, "Int R16 - R8 Min Value as Unsigned"),
			func.invoke(16, 3811640309623L, INT_R08_U_NEGATIVE_ONE, "Int R16 - R8 Unsigned Max Value"),
			func.invoke(16, 142929835591L, INT_R10_S_MAX_VALUE, "Int R16 - R10 Max Value"),
			func.invoke(16, 142929835592L, INT_R10_U_MIN_VALUE, "Int R16 - R10 Min Value as Unsigned"),
			func.invoke(16, 285960729237L, INT_R10_U_NEGATIVE_ONE, "Int R16 - R10 Unsigned Max Value"),
			func.invoke(16, I32_MAX_VALUE, INT_R16_S_MAX_VALUE, "Int R16 - R16 Max Value"),
			func.invoke(16, U32_MIN_VALUE, INT_R16_U_MIN_VALUE, "Int R16 - R16 Min Value as Unsigned"),
			func.invoke(16, U32_MAX_VALUE, INT_R16_U_NEGATIVE_ONE, "Int R16 - R16 Unsigned Max Value"),


			func.invoke(36, 0L, ZERO, "Int R36 - R10 Zero"),
			func.invoke(36, 71989233156050L, PINEAPPLE, "Int R36 - 'Pineapple'"),
			func.invoke(36, 4387390128075571L, INT_R08_S_MAX_VALUE, "Int R36 - R8 Max Value"),
			func.invoke(36, 7312316880125952L, INT_R08_U_MIN_VALUE, "Int R36 - R8 Min Value as Unsigned"),
			func.invoke(36, 11699707008201523L, INT_R08_U_NEGATIVE_ONE, "Int R36 - R8 Unsigned Max Value"),
			func.invoke(36, 206269972826551L, INT_R10_S_MAX_VALUE, "Int R36 - R10 Max Value"),
			func.invoke(36, 206269972826552L, INT_R10_U_MIN_VALUE, "Int R36 - R10 Min Value as Unsigned"),
			func.invoke(36, 412596585697577L, INT_R10_U_NEGATIVE_ONE, "Int R36 - R10 Unsigned Max Value"),
			func.invoke(36, 582133790427L, INT_R16_S_MAX_VALUE, "Int R36 - R16 Max Value"),
			func.invoke(36, 626913312768L, INT_R16_U_MIN_VALUE, "Int R36 - R16 Min Value as Unsigned"),
			func.invoke(36, 1209047103195L, INT_R16_U_NEGATIVE_ONE, "Int R36 - R16 Unsigned Max Value"),
			func.invoke(36, I32_MAX_VALUE, INT_R36_S_MAX_VALUE, "Int R36 - R36 Max Value"),
			func.invoke(36, U32_MIN_VALUE, INT_R36_U_MIN_VALUE, "Int R36 - R36 Min Value as Unsigned"),
			func.invoke(36, U32_MAX_VALUE, INT_R36_U_NEGATIVE_ONE, "Int R36 - R36 Unsigned Max Value"),

			func.invoke(2, 0L, ZERO, "Long R2 - R10 Zero"),
			func.invoke(2, Long.MAX_VALUE, LONG_R02_S_MAX_VALUE, "Long R2 - R2 Max Value"),
			func.invoke(2, Long.MIN_VALUE, LONG_R02_S_MIN_VALUE, "Long R2 - R2 Min Value as Signed"),
			func.invoke(2, 2097152L, LONG_R08_U_MIN_VALUE, "Long R2 - R8 Min Value as Unsigned"),

			func.invoke(10, 0L, ZERO, "Long R10 - R10 Zero"),
			func.invoke(10, Long.MAX_VALUE, LONG_R10_S_MAX_VALUE, "Long R10 - R10 Max Value"),
			func.invoke(10, Long.MIN_VALUE, LONG_R10_S_MIN_VALUE, "Long R10 - R10 Min Value as Signed"),
			func.invoke(10, 8000000000000000L, LONG_R16_U_MIN_VALUE, "Long R10 - R16 Min Value as Unsigned"),

			func.invoke(16, 0L, ZERO, "Long R16 - R10 Zero"),
			func.invoke(16, Long.MAX_VALUE, LONG_R16_S_MAX_VALUE, "Long R16 - R16 Max Value"),
			func.invoke(16, Long.MIN_VALUE, LONG_R16_S_MIN_VALUE, "Long R16 - R16 Min Value as Signed"),

			func.invoke(36, 0L, ZERO, "Long R36 - R10 Zero"),
			func.invoke(36, 71989233156050L, PINEAPPLE, "Long R36 - 'Pineapple'"),
			func.invoke(36, Long.MAX_VALUE, LONG_R36_S_MAX_VALUE, "Long R36 - R36 Max Value"),
			func.invoke(36, Long.MIN_VALUE, LONG_R36_S_MIN_VALUE, "Long R36 - R36 Min Value as Signed")
		);
	}
}
