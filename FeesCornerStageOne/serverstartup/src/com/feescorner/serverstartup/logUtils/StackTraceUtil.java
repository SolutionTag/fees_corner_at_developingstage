package com.feescorner.serverstartup.logUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
* Simple utilities to return the stack trace of an
* exception as a String.
*/
public final class StackTraceUtil {

  public static String getStackTrace(Throwable aThrowable) {
    final Writer result = new StringWriter();
    new PrintWriter(result);
    return result.toString();
  }

  /**
  * Defines a custom format for the stack trace as String.
  */
  public static String getCustomStackTrace(Throwable aThrowable) {
    //add the class name and any message passed to constructor
    final StringBuilder result = new StringBuilder( "--->" );
    result.append(aThrowable.toString());
    final String NEW_LINE = System.getProperty("line.separator");
    result.append(NEW_LINE);

    //add each element of the stack trace
    for (StackTraceElement element : aThrowable.getStackTrace() ){
      result.append( element );
      result.append( NEW_LINE );
    }
    return result.toString();
  }
/*
  *//** Demonstrate output.  *//*
  public static void main (String... aArguments){
    final Throwable throwable = new IllegalArgumentException("Blah");
    System.out.println( getStackTrace(throwable) );
    System.out.println( getCustomStackTrace(throwable) );
  }*/
} 
