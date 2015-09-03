package org.pipelinemc.Pipeline;

import java.util.Date;

@SuppressWarnings("deprecation")
public class Logger {
	static String ANSI_RESET = "\u001B[0m";
	static String ANSI_RED = "\u001B[31m";
	static String ANSI_YELLOW = "\u001B[33m";
	static String ANSI_BLUE = "\u001B[34m";
	public static void log(Object obj){
		Date date = new Date();
		String prefix = String.format("[%s:%s:%s] %s[INFO]%s ", date.getHours(),date.getMinutes(),date.getSeconds(),ANSI_BLUE,ANSI_RESET);
		System.out.println(prefix + obj);
	}
	public static void critical(Object obj){
		Date date = new Date();
		String datePrefix = String.format("[%s:%s:%s] ",  date.getHours(),date.getMinutes(),date.getSeconds());
		String prefix = String.format(datePrefix + "%s[CRITICAL] [CRITICAL] [CRITICAL] [CRITICAL] [CRITICAL] [CRITICAL] %s",ANSI_RED,ANSI_RESET);
		System.out.println(prefix);
		System.out.println(datePrefix  + obj);
		System.out.println(prefix);
	}
	public static void warn(Object obj){
		Date date = new Date();
		String prefix = String.format("[%s:%s:%s] %s[WARN]%s ", date.getHours(),date.getMinutes(),date.getSeconds(),ANSI_YELLOW,ANSI_RESET);
		System.out.println(prefix + "");
	}

	public static void err(String string, Exception e){
		Date date = new Date();
		String datePrefix = String.format("[%s:%s:%s] ",  date.getHours(),date.getMinutes(),date.getSeconds());
		String prefix = String.format(datePrefix + "%s [Error] "+string+"%s",ANSI_RED,ANSI_RESET);
		System.out.println(prefix);
		System.out.println(datePrefix  + e);
		System.out.println(prefix);
	}

}
