interface InterfaceFigura
{
    double obliczPole();
    double obliczObwod();
    String podajNazwe();
}

abstract class Figura implements InterfaceFigura {}

abstract class Czworokat extends Figura
{
    protected double bok1, bok2, bok3, bok4, kat;

    public Czworokat(double bok1, double bok2, double bok3, double bok4, double kat)
    {
        this.bok1 = bok1;
        this.bok2 = bok2;
        this.bok3 = bok3;
        this.bok4 = bok4;
        this.kat = Math.toRadians(kat);
    }
}

class Kwadrat extends Czworokat
{
    public Kwadrat(double bok, double kat)
    {
        super(bok, bok, bok, bok, kat);
    }

    public double obliczPole()
    {
        return bok1 * bok1;
    }

    public double obliczObwod()
    {
        return 4 * bok1;
    }

    public String podajNazwe()
    {
        return "Kwadrat:   ";
    }
}

class Prostokat extends Czworokat
{
    public Prostokat(double bok1, double bok2, double bok3, double bok4, double kat)
    {
        super(bok1, bok2, bok3, bok4, kat);
    }

    public double obliczPole()
    {
        return bok1 * bok2;
    }

    public double obliczObwod()
    {
        return 2 * (bok1 + bok2);
    }

    public String podajNazwe()
    {
        return "Prostokat: ";
    }
}

class Romb extends Czworokat
{
    public Romb(double bok, double kat)
    {
        super(bok, bok, bok, bok, kat);

        if (kat <= 0 || kat >= 180)
        {
            throw new IllegalArgumentException("Kat w rombie musi byc w zakresie (0°; 180°)");
        }
    }

    public double obliczPole()
    {
        return bok1 * bok1 * Math.sin(kat);
    }

    public double obliczObwod()
    {
        return 4 * bok1;
    }

    public String podajNazwe()
    {
        return "Romb:      ";
    }
}

class Kolo extends Figura
{
    private double promien;

    public Kolo(double promien)
    {
        this.promien = promien;
    }

    public double obliczPole()
    {
        return Math.PI * promien * promien;
    }

    public double obliczObwod()
    {
        return 2 * Math.PI * promien;
    }

    public String podajNazwe()
    {
        return "Kolo:      ";
    }
}

class Pieciokat extends Figura
{
    private double bok;

    public Pieciokat(double bok)
    {
        this.bok = bok;
    }

    public double obliczPole()
    {
        return (5 * bok * bok) / (4 * Math.tan(Math.PI / 5));
    }

    public double obliczObwod()
    {
        return 5 * bok;
    }

    public String podajNazwe()
    {
        return "Pieciokat: ";
    }
}

class Szesciokat extends Figura
{
    private double bok;

    public Szesciokat(double bok)
    {
        this.bok = bok;
    }

    public double obliczPole()
    {
        return ((3 * Math.sqrt(3)) / 2) * bok * bok;
    }

    public double obliczObwod()
    {
        return 6 * bok;
    }

    public String podajNazwe()
    {
        return "Szesciokat:";
    }
}
