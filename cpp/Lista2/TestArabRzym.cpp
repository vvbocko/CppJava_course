#include <iostream>
#include <string>
#include <vector>
#include <stdexcept>
#include "ArabRzym.hpp"

int main(int argc, char* argv[])
{
    if (argc < 2)
    {
        std::cout << "Brak argumentu" << std::endl;
        return 1;
    }

    for(int i = 1; i < argc; ++i)
    {
        std::string input = argv[i];
        
        try
        {
            int arab = std::stoi(input);
            std::cout << input <<" Rzymska: " <<ArabRzym::arab2rzym(arab) << std::endl;
        } 
        catch (std::invalid_argument&)
        {
            try
            {
                std::cout << input << " Arabska: " << ArabRzym::rzym2arab(input) << std::endl;
            }
            catch (const std::exception& e)
            {
                std::cerr << "Blad: " << input << e.what() << std::endl;
            }
        }
    }
    return 0;
}