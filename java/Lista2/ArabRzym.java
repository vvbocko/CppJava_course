//Przekształca liczby 
// z rzymskiego na arabski -- 
// z arabskiego na rzymski -- if integer try catch exeption - else then rzymski is true
// try catch exeptions: ujemna, nie-integer (nie naturalna)

class ArabRzymException extends Exception
{
    public ArabRzymException(String message)
    {
        super(message); 
    }
}

public class ArabRzym
{
    private static final String[] liczby = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    private static final int[] wartosci = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

    public static int rzym2arab(String rzym) throws ArabRzymException
    {
        int wynik = 0;
        int i = liczby.length - 1;
        int index = 0;

        while (index < rzym.length() && i >= 0)
        {
            if (rzym.startsWith(liczby[i], index))
            {
                wynik += wartosci[i];
                index += liczby[i].length();
            } 
            else
            {
                i--;
            }
        }

        if (arab2rzym(wynik).equals(rzym))
        {
            return wynik;
        } 
        else
        {
            throw new ArabRzymException("Niepoprawny format liczby rzymskiej: " + rzym);
        }
    }

    public static String arab2rzym(int arab) throws ArabRzymException
    {
        if (arab < 1 || arab > 3999)
        {
            throw new ArabRzymException("Liczba arabska poza zakresem (1-3999): " + arab);
        }

        StringBuilder wynik = new StringBuilder(); //
        int i = liczby.length - 1;  //zaczynamy od M - 1000

        while (arab > 0)
        {
            if (arab >= wartosci[i])
            {
                wynik.append(liczby[i]);
                arab -= wartosci[i];
            } else
            {
                i--;
            }
        }

        return wynik.toString();
    }
}
