#pragma once
#include<iostream>
#include<stdexcept>
#include<vector>

class NieprawidlowyNumerWierszaException : public std::runtime_error //extends Exeption
{
    public:
        explicit NieprawidlowyNumerWierszaException(const std::string& message) 
        : std::runtime_error(message) {}
};
    
class NieprawidlowyIndeksException : public std::runtime_error
{
    public:
        explicit NieprawidlowyIndeksException(const std::string& message) 
        : std::runtime_error(message) {}
};

class WierszTrojkataPascala
{
    //Atrybuty
    private:
        int n;
        std::vector<int> wiersz;
        void liczWiersz();

    //Metody
    public:
        WierszTrojkataPascala(int n); //Konstruktor
        ~WierszTrojkataPascala(); //Destruktor
        
        int zwrocElement(int m) const;
};

//const po zwrocElement, licz wiersz w private,