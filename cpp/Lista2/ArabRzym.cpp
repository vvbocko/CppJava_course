#include "ArabRzym.hpp"
#include <string>

const std::vector<std::string> ArabRzym::liczby = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
const std::vector<int> ArabRzym::wartosci = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

int ArabRzym::rzym2arab(const std::string& rzym)
{
    int wynik = 0;
    size_t i = liczby.size() - 1;
    size_t index = 0;

    while (index < rzym.length() && i < liczby.size())
    {
        if (rzym.substr(index, liczby[i].length()) == liczby[i])
        {
            wynik += wartosci[i];
            index += liczby[i].length();
        } 
        else
        {
            i--;
        }
    }

    if (arab2rzym(wynik) == rzym)
    {
        return wynik;
    }
    else
    {
        throw std::invalid_argument(" ma niepoprawny format liczby rzymskiej");
    }
}

std::string ArabRzym::arab2rzym(int arab)
{
    if (arab < 1 || arab > 3999)
    {
        throw std::out_of_range(" poza zakresem (1-3999)");
    }

    std::string wynik;
    size_t i = liczby.size() - 1;

    while (arab > 0)
    {
        if (arab >= wartosci[i])
        {
            wynik += liczby[i];
            arab -= wartosci[i];
        }
        else
        {
            i--;
        }
    }

    return wynik;
}