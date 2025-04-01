public class ArabRzymTest
{
    public static void main(String[] args)
    {    
        if (args.length == 0)
        {
            System.out.println("Brak argumentow");
            return;
        }

        for (String input : args)
        {
            try
            {
                try
                {
                    int arab = Integer.parseInt(input);
                    System.out.println(input + " -> " + ArabRzym.arab2rzym(arab));
                }
                catch (NumberFormatException e)
                {
                    System.out.println(input + " -> " + ArabRzym.rzym2arab(input));
                }
            }
            catch (ArabRzymException e)
            {
                System.err.println("Blad: " + e.getMessage());
            }
        }
    }
}
