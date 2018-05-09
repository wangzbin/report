package com.report.common.util;



import org.apache.log4j.Level;

/**
 * 自定义LOG等级
 * 
 */
public class LOGCustomer extends Level {

    private static final long serialVersionUID = 1L;

    protected LOGCustomer(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }

    /**
     * 定义log的权重为介于OFF和FATAL之间，便于打印LIFE级别的log
     */
    public static final int LEVEL_INT = OFF_INT - 10;

    public static final Level CUSTOMER_LOG = new LOGCustomer(LEVEL_INT, "customer_log", 10);

    public static Level toLevel(String logArgument) {
        if (logArgument != null && logArgument.toUpperCase().equals("CUSTOMER_LOG")) {
            return CUSTOMER_LOG;
        }
        return (Level) toLevel(logArgument);
    }

    public static Level toLevel(int val) {
        if (val == LEVEL_INT) {
            return CUSTOMER_LOG;
        }
        return (Level) toLevel(val, Level.DEBUG);
    }

    public static Level toLevel(int val, Level defaultLevel) {
        if (val == LEVEL_INT) {
            return CUSTOMER_LOG;
        }
        return Level.toLevel(val, defaultLevel);
    }

    public static Level toLevel(String logArgument, Level defaultLevel) {
        if (logArgument != null && logArgument.toUpperCase().equals("CUSTOMER_LOG")) {
            return CUSTOMER_LOG;
        }
        return Level.toLevel(logArgument, defaultLevel);
    }
}
