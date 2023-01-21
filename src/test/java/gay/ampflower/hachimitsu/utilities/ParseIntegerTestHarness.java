package gay.ampflower.hachimitsu.utilities;

import gay.ampflower.hachimitsu.utilities.functions.FuncOIIII_I;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ampflower
 * @since ${version}
 **/
class ParseIntegerTestHarness implements Executable {
	private static final int[] patterns = {
		0,
		Integer.MIN_VALUE,
		Integer.MAX_VALUE,
		-1,
		0xFFFF0000,
		0xFF00FF00,
		0xF0F0F0F0,
		0xCCCCCCCC,
		0xAAAAAAAA,
		0x55555555,
		0x33333333,
		0x0F0F0F0F,
		0x00FF00FF,
		0x0000FFFF
	};
	private final String input;
	private final int radix;
	@Nullable
	private final Integer expected;
	@NotNull
	private final FuncOIIII_I<String> func;

	ParseIntegerTestHarness(String input, int radix, @Nullable Integer expected, @NotNull FuncOIIII_I<String> func) {
		this.input = input;
		this.radix = radix;
		this.expected = expected;
		this.func = func;
	}

	static DynamicTest of(String name, String input, int radix, @Nullable Integer expected, @NotNull FuncOIIII_I<String> func) {
		return DynamicTest.dynamicTest(name, new ParseIntegerTestHarness(input, radix, expected, func));
	}

	static DynamicTest ofParseInt(int radix, @Nullable Integer expected, String input, String name) {
		return of(name, input, radix, expected, StringUtils::parseInt);
	}


	@Override
	public void execute() throws Throwable {
		if (expected == null) {
			for (int i : patterns) {
				assertEquals(i, func.invoke(input, 0, input.length(), i, radix));
			}
			// assertThrows(Throwable.class, () -> func.invoke(input, 0, input.length(), def, radix));
		} else {
			// Implicit cast
			int expected = this.expected;
			for (int i : patterns) {
				assertEquals(expected, func.invoke(input, 0, input.length(), i, radix));
			}
		}
	}
}
