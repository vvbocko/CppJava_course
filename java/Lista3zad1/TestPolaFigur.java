public class TestPolaFigur 
{
    public static void main(String[] args)
    {
        Figura[] figury = new Figura[args.length];
        int indeks = 0;

        try
        {
            for (int i = 0; i < args.length; )
            {
                String typ = args[i];

                switch (typ)
                {
                    case "o":
                        double r = Double.parseDouble(args[i + 1]);
                        figury[indeks++] = new Kolo(r);
                        i += 2;
                        break;

                    case "c":
                        double b1 = Double.parseDouble(args[i + 1]);
                        double b2 = Double.parseDouble(args[i + 2]);
                        double b3 = Double.parseDouble(args[i + 3]);
                        double b4 = Double.parseDouble(args[i + 4]);
                        double kat = Double.parseDouble(args[i + 5]);

                        if (b1 == b2 && b1 == b3 && b1 == b4)
                        {
                            if (kat == 90)
                            {
                                figury[indeks++] = new Kwadrat(b1, kat);
                            }
                            else
                            {
                                figury[indeks++] = new Romb(b1, kat);
                            }
                        }
                        else if (b1 == b3 && b2 == b4 && kat == 90)
                        {
                            figury[indeks++] = new Prostokat(b1, b2, b3, b4, kat);
                        }
                        else
                        {
                            throw new IllegalArgumentException("Nieznany typ czworokata");
                        }

                        i += 6;
                        break;

                    case "p":
                        double bp = Double.parseDouble(args[i + 1]);
                        figury[indeks++] = new Pieciokat(bp);
                        i += 2;
                        break;

                    case "s":
                        double bs = Double.parseDouble(args[i + 1]);
                        figury[indeks++] = new Szesciokat(bs);
                        i += 2;
                        break;

                    default:
                        throw new IllegalArgumentException("Nieznana figura: " + typ);
                }
            }

            for (int j = 0; j < indeks; j++)
            {
                Figura f = figury[j];
                System.out.printf("%-18s pole = %.2f,    obwod = %.2f%n", f.podajNazwe(), f.obliczPole(), f.obliczObwod());
            }

        }
        catch (Exception e)
        {
            System.out.println("Blad: " + e.getMessage());
        }
    }
}
