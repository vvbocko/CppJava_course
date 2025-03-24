public class ArabRzymTest
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 1)
            {
                System.out.println("Użycie: java Main <liczba_arabska_lub_rzymska>");
                return;
            }

            String input = args[0];

            try
            {
                int arab = Integer.parseInt(input);
                System.out.println("Rzymska: " + ArabRzym.arab2rzym(arab));
            } 
            catch (NumberFormatException e)
            {
                System.out.println("Arabska: " + ArabRzym.rzym2arab(input));
            }
        } 
        catch (ArabRzymException e)
        {
            System.err.println("Błąd: " + e.getMessage());
        }
    }
}
