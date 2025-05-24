#pragma once
#include <string>
#include <cmath>

class Figury
{
public:
    virtual double pole() const = 0;
    virtual double obwod() const = 0;
    virtual std::string nazwa() const = 0;
    virtual ~Figury() {}
};

class Czworokat : public Figury
{
protected:
    double b1, b2, b3, b4, kat;
public:
    Czworokat(double a, double b, double c, double d, double k);
};

class Kwadrat : public Czworokat
{
public:
    Kwadrat(double bok, double k);
    double pole() const override;
    double obwod() const override;
    std::string nazwa() const override;
};

class Prostokat : public Czworokat
{
public:
    Prostokat(double a, double b, double c, double d, double k);
    double pole() const override;
    double obwod() const override;
    std::string nazwa() const override;
};

class Romb : public Czworokat
{
public:
    Romb(double a, double b, double c, double d, double k);
    double pole() const override;
    double obwod() const override;
    std::string nazwa() const override;
};

class Kolo : public Figury
{
    double r;
public:
    Kolo(double promien);
    double pole() const override;
    double obwod() const override;
    std::string nazwa() const override;
};

class Pieciokat : public Figury
{
    double bok;
public:
    Pieciokat(double b);
    double pole() const override;
    double obwod() const override;
    std::string nazwa() const override;
};

class Szesciokat : public Figury
{
    double bok;
public:
    Szesciokat(double b);
    double pole() const override;
    double obwod() const override;
    std::string nazwa() const override;
};
