public class TestFiguryEnum
{
    public static void main(String[] args)
    {
        try {
            for (int i = 0; i < args.length;)
            {
                String typ = args[i];

                switch (typ)
                {
                    case "o":
                        double r = Double.parseDouble(args[i + 1]);
                        var kolo = FiguryEnum.Jednoparametrowe.KOLO;
                        wypisz(kolo.podajNazwe(), kolo.obliczPole(r), kolo.obliczObwod(r));
                        i += 2;
                        break;
                    case "c":
                        double a = Double.parseDouble(args[i + 1]);
                        double b = Double.parseDouble(args[i + 2]);
                        double c = Double.parseDouble(args[i + 3]);
                        double d = Double.parseDouble(args[i + 4]);
                        double kat = Double.parseDouble(args[i + 5]);

                        if (a == b && a == c && a == d)
                        {
                            var romb = FiguryEnum.Dwuparametrowe.ROMB;
                            wypisz(romb.podajNazwe(), romb.obliczPole(a, kat), romb.obliczObwod(a, kat));
                        }
                        else if (a == c && b == d && kat == 90)
                        {
                            var prostokat = FiguryEnum.Dwuparametrowe.PROSTOKAT;
                            wypisz(prostokat.podajNazwe(), prostokat.obliczPole(a, b), prostokat.obliczObwod(a, b));
                        }
                        else
                        {
                            throw new IllegalArgumentException("Nieznany czworokat");
                        }
                        i += 6;
                        break;
                    case "p":
                        double bokP = Double.parseDouble(args[i + 1]);
                        var p = FiguryEnum.Jednoparametrowe.PIECIOKAT;
                        wypisz(p.podajNazwe(), p.obliczPole(bokP), p.obliczObwod(bokP));
                        i += 2;
                        break;
                    case "s":
                        double bokS = Double.parseDouble(args[i + 1]);
                        var s = FiguryEnum.Jednoparametrowe.SZESCIOKAT;
                        wypisz(s.podajNazwe(), s.obliczPole(bokS), s.obliczObwod(bokS));
                        i += 2;
                        break;
                    default:
                        throw new IllegalArgumentException("Nieznany typ figury: " + typ);
                }
            }
        } catch (Exception e)
        {
            System.out.println("Blad: " + e.getMessage());
        }
    }

    static void wypisz(String nazwa, double pole, double obwod)
    {
        System.out.printf("%-18s pole = %.2f, obwod = %.2f%n", nazwa, pole, obwod);
    }
}
