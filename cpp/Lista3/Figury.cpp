#include "Figury.hpp"
#include <cmath>

const double PI = 3.14159265358979323846;

Czworokat::Czworokat(double a, double b, double c, double d, double k)
    : b1(a), b2(b), b3(c), b4(d), kat(k) {}

Kwadrat::Kwadrat(double bok, double k) : Czworokat(bok, bok, bok, bok, k) {}

double Kwadrat::pole() const
{
    return b1 * b1;
}

double Kwadrat::obwod() const
{
    return 4 * b1;
}

std::string Kwadrat::nazwa() const
{
    return "Kwadrat:   ";
}

Prostokat::Prostokat(double a, double b, double c, double d, double k)
    : Czworokat(a, b, c, d, k) {}

double Prostokat::pole() const
{
    return b1 * b2;
}

double Prostokat::obwod() const
{
    return 2 * (b1 + b2);
}

std::string Prostokat::nazwa() const
{
    return "Prostokat: ";
}

Romb::Romb(double a, double b, double c, double d, double k)
    : Czworokat(a, b, c, d, k) {}

double Romb::pole() const
{
    double rad = kat * PI / 180.0;
    return b1 * b1 * sin(rad);
}

double Romb::obwod() const
{
    return 4 * b1;
}

std::string Romb::nazwa() const
{
    return "Romb:      ";
}

Kolo::Kolo(double promien) : r(promien) {}

double Kolo::pole() const
{
    return PI * r * r;
}

double Kolo::obwod() const
{
    return 2 * PI * r;
}

std::string Kolo::nazwa() const
{
    return "Kolo:      ";
}

Pieciokat::Pieciokat(double b) : bok(b) {}

double Pieciokat::pole() const {
    return (5 * bok * bok) / (4 * tan(PI / 5));
}

double Pieciokat::obwod() const
{
    return 5 * bok;
}

std::string Pieciokat::nazwa() const
{
    return "Pieciokat: ";
}

Szesciokat::Szesciokat(double b) : bok(b) {}

double Szesciokat::pole() const
{
    return ((3 * sqrt(3)) / 2) * bok * bok;
}

double Szesciokat::obwod() const
{
    return 6 * bok;
}

std::string Szesciokat::nazwa() const
{
    return "Szesciokat:";
}
