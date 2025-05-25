public class FiguryEnum {
    
    //kolo kwadrat pięciokat szecsiakat
    public interface Figura1Param
    {
        double obliczPole(double param);
        double obliczObwod(double param);
        String podajNazwe();
    }

    //prostokat, romb
    public interface Figura2Param
    {
        double obliczPole(double a, double b);
        double obliczObwod(double a, double b);
        String podajNazwe();
    }

    public enum Jednoparametrowe implements Figura1Param
    {
        KOLO 
        {
            public double obliczPole(double r)
            {
                return Math.PI * r * r;
            }
            public double obliczObwod(double r)
            {
                return 2 * Math.PI * r;
            }
            public String podajNazwe()
            {
                return "Kolo";
            }
        },
        KWADRAT
        {
            public double obliczPole(double a)
            {
                return a * a;
            }
            public double obliczObwod(double a)
            {
                return 4 * a;
            }
            public String podajNazwe()
            {
                return "Kwadrat";
            }
        },
        PIECIOKAT
        {
            public double obliczPole(double a)
            {
                return (5 * a * a) / (4 * Math.tan(Math.PI / 5));
            }
            public double obliczObwod(double a)
            {
                return 5 * a;
            }
            public String podajNazwe()
            {
                return "Pieciokat";
            }
        },
        SZESCIOKAT
        {
            public double obliczPole(double a)
            {
                return ((3 * Math.sqrt(3)) / 2) * a * a;
            }
            public double obliczObwod(double a)
            {
                return 6 * a;
            }
            public String podajNazwe()
            {
                return "Szesciokat";
            }
        }
    }

    public enum Dwuparametrowe implements Figura2Param
    {
        PROSTOKAT
        {
            public double obliczPole(double a, double b) {
                return a * b;
            }
            public double obliczObwod(double a, double b) {
                return 2 * (a + b);
            }
            public String podajNazwe() {
                return "Prostokat";
            }
        },
        ROMB
        {
            public double obliczPole(double a, double katStopnie) {
                return a * a * Math.sin(Math.toRadians(katStopnie));
            }
            public double obliczObwod(double a, double b) {
                return 4 * a; //b - kąt
            }
            public String podajNazwe() {
                return "Romb";
            }
        }
    }
}
