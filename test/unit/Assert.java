package unit;

public final class Assert {
    private Assert() {}

    public static void assertTrue(boolean b, String msg) {
        if (!b) {
            throw new AssertionError(msg);
        }
    }

    public static void assertFalse(boolean b, String msg) {
        assertTrue(!b, msg);
    }

    public static void assertEquals(String left, String right, String msg) {
        if (!left.equals(right)) {
            throw new AssertionError(String.format(
                "\"%s\" != \"%s\": %s", left, right, msg));
        }
    }
}
