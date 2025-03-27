#include <iostream>
#include <string>
#include <vector>
#include <stdexcept>
#include "ArabRzym.hpp"

int main(int argc, char* argv[]) {
    try
    {
        if (argc != 2)
        {
            std::cout << "Użycie: ./program <liczba_arabska_lub_rzymska>" << std::endl;
            return 1;
        }

        std::string input = argv[1];

        try
        {
            int arab = std::stoi(input);
            std::cout << "Rzymska: " << ArabRzym::arab2rzym(arab) << std::endl;
        } 
        catch (std::invalid_argument&)
        {
            std::cout << "Arabska: " << ArabRzym::rzym2arab(input) << std::endl;
        }
    }
    catch (const std::exception& e)
    {
        std::cerr << "Błąd: " << e.what() << std::endl;
        return 1;
    }
    return 0;
}