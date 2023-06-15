package mit6031;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lesson17 {
public static void main(String[] args) {
	String s = "2020-03-18";
	Pattern regex = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
	Matcher m = regex.matcher(s);
	if (m.matches()) {
	    String year = m.group("year");
	    String month = m.group("month");
	    String day = m.group("day");
	    // Matcher.group(name) returns the part of s that matched (?<name>...)
	    System.out.println(year);
	    System.out.println(month);
	    System.out.println(day);
	}
}
}
