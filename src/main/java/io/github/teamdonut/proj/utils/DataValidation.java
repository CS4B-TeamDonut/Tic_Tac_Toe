package io.github.teamdonut.proj.utils;

public final class DataValidation {
    /**
     * Constructor
     */
    private DataValidation() {}

    /**
     *
     * @param propertyName used for error output
     * @param value String to check
     * @throws NullPointerException string is null
     */
    public static void ensureNonEmptyString(String propertyName, String value) throws NullPointerException {
        if (value == null || value.trim().equals(""))
            throw new NullPointerException(String.format("%s cannot be null or empty", propertyName));
    }

    /**
     *
     * @param propertyName used for error output
     * @param obj Object to check
     * @throws NullPointerException object is null
     */
    public static void ensureObjectNotNull(String propertyName, Object obj) throws NullPointerException {
        if (obj == null)
            throw new NullPointerException(String.format("%s cannot be null", propertyName));
    }
}