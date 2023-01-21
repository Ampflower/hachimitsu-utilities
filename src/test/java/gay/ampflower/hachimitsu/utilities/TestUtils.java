package gay.ampflower.hachimitsu.utilities;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Ampflower
 * @since ${version}
 **/
class TestUtils {
	@SafeVarargs
	static <T> Collection<T> concat(Collection<T>... iterables) {
		var ret = new ArrayList<T>();
		for (var itr : iterables) {
			ret.addAll(itr);
		}
		return ret;
	}
}
