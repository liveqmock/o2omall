package com.hbird.common.utils.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 关于异常的工具类.
 * 
 * @author ljz
 */
public class Exceptions {

    /**
     * 将CheckedException转换为UncheckedException.
     * 
     * @param e
     *            the e
     * @return the runtime exception
     */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }

    /**
     * 将ErrorStack转化为String.
     * 
     * @param e
     *            the e
     * @return the stack trace as string
     */
    public static String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

}
