/**
 * Serves as the line of interaction for the user in the ASCII Art Generator.
 * 
 * @author Jeremiah Milbauer 
 * @version 1/9/16
 */
public class ASCIIArtGenerator
{
    private static final String PROMPT = "Please enter a URL to convert.";
    private static String contrastChars = "%8W#hm0}?++::^^..  ";

    public static void main(String[] args)
    {
        String input = args[0];
        PPicture pic = new PPicture(input);
        Generator gen = new Generator(pic);
        String output = gen.toASCIIString(contrastChars);
        System.out.println(output);
    }
}
