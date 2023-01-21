package gay.ampflower.hachimitsu.utilities;

import gay.ampflower.hachimitsu.utilities.functions.FuncOIILI_L;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ampflower
 * @since ${version}
 **/
class ParseLongTestHarness implements Executable {
	private static final long[] patterns = {
		0L,
		Long.MIN_VALUE,
		Long.MAX_VALUE,
		-1L,
		0xFFFFFFFF00000000L,
		0xFFFF0000FFFF0000L,
		0xFF00FF00FF00FF00L,
		0xF0F0F0F0F0F0F0F0L,
		0xCCCCCCCCCCCCCCCCL,
		0xAAAAAAAAAAAAAAAAL,
		0x5555555555555555L,
		0x3333333333333333L,
		0x0F0F0F0F0F0F0F0FL,
		0x00FF00FF00FF00FFL,
		0x0000FFFF0000FFFFL,
		0x00000000FFFFFFFFL
	};
	private final String input;
	private final int radix;
	@Nullable
	private final Long expected;
	@NotNull
	private final FuncOIILI_L<String> func;

	ParseLongTestHarness(String input, int radix, @Nullable Long expected, @NotNull FuncOIILI_L<String> func) {
		this.input = input;
		this.radix = radix;
		this.expected = expected;
		this.func = func;
	}

	static DynamicTest of(String name, String input, int radix, @Nullable Long expected, @NotNull FuncOIILI_L<String> func) {
		return DynamicTest.dynamicTest(name, new ParseLongTestHarness(input, radix, expected, func));
	}

	static DynamicTest ofParseLong(int radix, @Nullable Long expected, String input, String name) {
		return of(name, input, radix, expected, StringUtils::parseLong);
	}

	static DynamicTest ofTryParseLong(int radix, @Nullable Long expected, String input, String name) {
		return of(name, input, radix, expected, StringUtils::tryParseLong);
	}

	static DynamicTest ofTryParseUnsignedLong(int radix, @Nullable Long expected, String input, String name) {
		return of(name, input, radix, expected, StringUtils::tryParseUnsignedLong);
	}

	static DynamicTest ofParseLong(int radix, int expected, String input, String name) {
		return of(name, input, radix, (long) expected, StringUtils::parseLong);
	}

	@Override
	public void execute() throws Throwable {
		if (expected == null) {
			for (long i : patterns) {
				assertEquals(i, func.invoke(input, 0, input.length(), i, radix));
			}
		} else {
			// Implicit cast
			long expected = this.expected;
			for (long i : patterns) {
				assertEquals(expected, func.invoke(input, 0, input.length(), i, radix));
			}
		}
	}
}
