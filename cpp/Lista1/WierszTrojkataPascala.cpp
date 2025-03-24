#include "WierszTrojkataPascala.hpp"

WierszTrojkataPascala::WierszTrojkataPascala(int n) : n(n)
{
    if (n < 0)
    {
        throw NieprawidlowyNumerWierszaException(std::to_string(n) + " - Nieprawidłowy numer wiersza");
    }
    liczWiersz();
}

WierszTrojkataPascala::~WierszTrojkataPascala()
{

}

void WierszTrojkataPascala::liczWiersz() 
{ 
    wiersz.resize(n+1);
    wiersz[0] = 1;

    for (int i = 1; i <= n; i++)
    {
        wiersz[i] = wiersz[i-1] * (n-i+1) / i;
    }
}

int WierszTrojkataPascala::zwrocElement(int m) const
{
    if (m < 0 || m > n)
    {
        throw NieprawidlowyIndeksException("liczba spoza zakresu");
    }
    return wiersz[m];
}

