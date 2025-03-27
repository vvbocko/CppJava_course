#pragma once
#include<iostream>
#include<stdexcept>
#include<vector>

class ArabRzymException : public std::runtime_error
{
    public:
        explicit ArabRzymException(const std::string& message) 
        : std::runtime_error(message) {}
};

class ArabRzym
{
    public:
        static int rzym2arab(const std::string& rzym);
        static std::string arab2rzym(int arab);

    private:
        static const std::vector<std::string> liczby;
        static const std::vector<int> wartosci;
};