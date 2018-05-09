package com.report.common.util;



import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 * 日志
 */
public class LOG {

    private static final Logger LOG = Logger.getRootLogger();

    public static void info(Object message) {
        LOG.info(message);
    }

    public static void info(Object message, Throwable t) {
        LOG.info(message, t);
    }

    public static void debug(Object message) {
        LOG.debug(message);
    }

    public static void debug(Object message, Throwable t) {
        LOG.debug(message, t);
    }

    public static void error(Object message) {
        LOG.error(message);
    }

    public static void error(Object message, Throwable t) {
        LOG.error(message, t);
    }

    public static void warn(Object message) {
        LOG.warn(message);
    }

    public static void warn(Object message, Throwable t) {
        LOG.warn(message, t);
    }

    public static void custom(Priority priority,Object message){
        LOG.log(priority,message);
    }

}
