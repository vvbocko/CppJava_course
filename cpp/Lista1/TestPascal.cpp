#include <iostream>
#include <string>
#include <cstdlib>
#include "WierszTrojkataPascala.hpp"


int main(int argc, char *argv[])
{
    if (argc < 2) // podano tylko jedną liczbe (n) + sama nazwa programu
    {
        std::cout << "Brak argumentow" << std::endl;
        return 1;
    }
    
    int numerWiersza;

    try
    {
        numerWiersza = std::stoi(argv[1]); //sprobuj zmienić pierwszy argument na int -- alternatywa Integer.parseInt(args[0]);
    } 
    catch (...) //(...) - nie zwracając uwagi na typ
    {
        std::cout << argv[1] << " - Nieprawidłowy numer wiersza" << std::endl;
        return 1;
    }

    try
    {
        WierszTrojkataPascala wiersz(numerWiersza); //korzystamy z konstruktora aby stworzyć obiekt klasy WierszTrojkataPascala
        
        for (int i = 2; i < argc; ++i) 
        {   
            try
            {
                int liczba = std::stoi(argv[i]);
                int value = wiersz.zwrocElement(liczba);
                std::cout << argv[i] << " - " << value << std::endl;
            } 
            catch (const std::invalid_argument&)
            {
                std::cout << argv[i] << " - nieprawidlowa dana" << std::endl;
            }
            catch (const NieprawidlowyIndeksException& e)
            {
                std::cout << argv[i] << " - " << e.what() << std::endl;
            } 
        }

    } 
    catch (const NieprawidlowyNumerWierszaException& e)
    {
        std::cout << e.what() << std::endl;
        return 1;
    }
    return 0;
}