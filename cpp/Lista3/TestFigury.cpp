#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include "Figury.hpp"

int main(int argc, char* argv[])
{
    std::vector<Figury*> figury;

    try {
        int i = 1;
        while (i < argc)
        {
            std::string typ = argv[i++];

            if (typ == "o")
            {
                if (i >= argc) throw std::runtime_error("Brak promienia kola");
                double r = std::stod(argv[i++]); // konwersja ze string na double
                figury.push_back(new Kolo(r));
            }
            else if (typ == "p")
            {
                if (i >= argc) throw std::runtime_error("Brak boku pieciokata");
                double b = std::stod(argv[i++]);
                figury.push_back(new Pieciokat(b));
            }
            else if (typ == "s")
            {
                if (i >= argc) throw std::runtime_error("Brak boku szesciokata");
                double b = std::stod(argv[i++]);
                figury.push_back(new Szesciokat(b));
            }
            else if (typ == "c")
            {
                if (i + 4 >= argc) throw std::runtime_error("Brak parametrow czworokata");
                
                double a = std::stod(argv[i++]);
                double b = std::stod(argv[i++]);
                double c = std::stod(argv[i++]);
                double d = std::stod(argv[i++]);
                double kat = std::stod(argv[i++]);

                if (a == b && b == c && c == d && kat == 90)
                    figury.push_back(new Kwadrat(a, kat));
                else if (a == c && b == d && kat == 90)
                    figury.push_back(new Prostokat(a, b, c, d, kat));
                else if (a == b && b == c && c == d)
                    figury.push_back(new Romb(a, b, c, d, kat));
                else
                    throw std::runtime_error("Zly typ czworokata");
            }
            else {
                throw std::runtime_error("Zly typ figury");
            }
        }

        for (Figury* f : figury) {
            std::cout << f->nazwa() << " pole = " << f->pole()
                      << ", obwod = " << f->obwod() << std::endl;
        }

        for (Figury* f : figury) {
            delete f;
        }
    }
    catch (const std::exception& e) {
        std::cerr << "Blad: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}
