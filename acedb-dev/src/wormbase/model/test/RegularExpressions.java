package wormbase.model.test;

import java.util.regex.*;

public final class RegularExpressions {

  /**
  * The pattern is matched to the first argument.
  */
  public static void main (String[] aArguments) {
    matchParts(aArguments[0]);
    matchAll(aArguments[0]);
  }

  /**
  * The Matcher.find method attempts to match *parts* of the input
  * to the given pattern.
  */
  private static void matchParts( String aText ){
    System.out.println(fNEW_LINE + "Match PARTS:");
    //(note the necessity of the comments flag, since our regular
    //expression contains comments:)
    Pattern pattern = Pattern.compile( fREGEXP, Pattern.COMMENTS );
    Matcher matcher = pattern.matcher( aText );
    while ( matcher.find() ) {
      System.out.println("Num groups: " + matcher.groupCount());
      System.out.println("Package: " + matcher.group(1));
      System.out.println("Class: " + matcher.group(2));
    }
  }

  /**
  * The Matcher.matches method attempts to match the *entire*
  * input to the given pattern all at once.
  */
  private static void matchAll( String aText ){
    System.out.println(fNEW_LINE + "Match ALL:");
    Pattern pattern = Pattern.compile( fREGEXP, Pattern.COMMENTS );
    Matcher matcher = pattern.matcher( aText );
    if( matcher.matches() ) {
      System.out.println("Num groups: " + matcher.groupCount());
      System.out.println("Package: " + matcher.group(1));
      System.out.println("Class: " + matcher.group(2));
    }
    else {
      System.err.println("Input does not match pattern.");
    }
  }

  //PRIVATE //

  private static final String fNEW_LINE = System.getProperty("line.separator");

  /**
  * A commented regular expression for fully-qualified type names which
  * follow the common naming conventions, for example, "com.myappBlah.Thing".
  *
  * Thus, the "dot + capital letter" is sufficient to define where the
  * package names end.
  *
  * This regular expression uses two groups, one for the package, and one
  * for the class. Groups are defined by parentheses. Note that ?: will
  * define a group as "non-contributing"; that is, it will not contribute
  * to the return values of the <code>group</code> method.
  */
  private static final String fREGEXP =
      "#Group1 - Package prefix without last dot: " + fNEW_LINE +
      "( (?:\\w|\\.)+ ) \\." + fNEW_LINE +
      "#Group2 - Class name starts with uppercase: " + fNEW_LINE +
      "( [A-Z](?:\\w)+ )";
} 
