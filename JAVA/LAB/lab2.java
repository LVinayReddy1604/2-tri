import java.util.Arrays;

public class lab2 {
    public static void main(String[] args) {
        String text = "\n We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative";

        // charAt()
        char firstChar = text.charAt(0);
        System.out.println("\n charAt(0): " + firstChar);

        // compareTo()
        String anotherText = "Comparing text";
        int comparisonResult = text.compareTo(anotherText);
        System.out.println("\n compareTo(anotherText): " + comparisonResult);

        // concat()
        String concatenatedText = text.concat(". Concatinating text.");
        System.out.println("\n concat(): " + concatenatedText);

        // contains()
        boolean containsResult = text.contains("thriving");
        System.out.println("\n contains('thriving'): " + containsResult);

        // endsWith()
        boolean endsWithResult = text.endsWith("alternative");
        System.out.println("\n endsWith('alternative'): " + endsWithResult);

        // equals()
        boolean equalsResult = text.equals(anotherText);
        System.out.println("\n equals(anotherText): " + equalsResult);

        // equalsIgnoreCase()
        boolean equalsIgnoreCaseResult = text.equalsIgnoreCase(anotherText);
        System.out.println("\n equalsIgnoreCase(anotherText): " + equalsIgnoreCaseResult);

        // format()
        String formattedText = String.format("Formatted text: %s, %d", "Hello", 123);
        System.out.println("\n format(): " + formattedText);

        // getBytes()
        byte[] bytes = text.getBytes();
        System.out.println("\n getBytes(): " + bytes.length + " bytes");

        // getChars()
        char[] charArray = new char[20];
        text.getChars(5, 25, charArray, 0);
        System.out.println("\n getChars(): " + new String(charArray));

        // indexOf()
        int indexOfThriving = text.indexOf("thriving");
        System.out.println("\n indexOf('thriving'): " + indexOfThriving);

        // intern()
        String internedText = text.intern();
        System.out.println("\n intern(): " + (text == internedText));

        // isEmpty()
        boolean isEmptyResult = text.isEmpty();
        System.out.println("\n isEmpty(): " + isEmptyResult);

        // join()
        String joinedText = String.join(" ", "Join", "this", "text");
        System.out.println("\n join(): " + joinedText);

        // lastIndexOf()
        int lastIndexOfTh = text.lastIndexOf("th");
        System.out.println("\n lastIndexOf('th'): " + lastIndexOfTh);

        // length()
        int textLength = text.length();
        System.out.println("\n length(): " + textLength);

        // replace()
        String replacedText = text.replace("thriving", "flourishing");
        System.out.println("\n replace('thriving', 'flourishing'): " + replacedText);

        // replaceAll()
        String replacedAllText = text.replaceAll("\\b\\w{4}\\b", "****");
        System.out.println("\n replaceAll('\\b\\w{4}\\b', '****'): " + replacedAllText);

        // split()
        String[] splitText = text.split("\\s+");
        System.out.println("\n split('\\s+'): " + Arrays.toString(splitText));

        // startsWith()
        boolean startsWithResult = text.startsWith("We");
        System.out.println("\n startsWith('We'): " + startsWithResult);

        // substring()
        String substringText = text.substring(10, 30);
        System.out.println("\n substring(10, 30): " + substringText);

        // toCharArray()
        char[] charArrayText = text.toCharArray();
        System.out.println("\n toCharArray(): " + Arrays.toString(charArrayText));

        // toLowerCase()
        String lowercaseText = text.toLowerCase();
        System.out.println("\n toLowerCase(): " + lowercaseText);

        // toUpperCase()
        String uppercaseText = text.toUpperCase();
        System.out.println("\n toUpperCase(): " + uppercaseText);

        // trim()
        String trimmedText = "   Trimmed Text   ".trim();
        System.out.println("\n trim(): '" + trimmedText + "'");

        // valueOf()
        int number = 42;
        String valueOfString = String.valueOf(number);
        System.out.println("\n valueOf(42): " + valueOfString);
    }
}
