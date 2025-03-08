#include <iostream>
using namespace std;
// Function to convert Celsius to Fahrenheit
double celsiusToFahrenheit(double celsius) {
    return (celsius * 9.0 / 5.0) + 32;
}
// Function to convert Celsius to Kelvin
double celsiusToKelvin(double celsius) {
    return celsius + 273.15;
}
// Function to convert Fahrenheit to Celsius
double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5.0 / 9.0;
}
// Function to convert Fahrenheit to Kelvin
double fahrenheitToKelvin(double fahrenheit) {
    return (fahrenheit - 32) * 5.0 / 9.0 + 273.15;
}
// Function to convert Kelvin to Celsius
double kelvinToCelsius(double kelvin) {
    return kelvin - 273.15;
}
// Function to convert Kelvin to Fahrenheit
double kelvinToFahrenheit(double kelvin) {
    return (kelvin - 273.15) * 9.0 / 5.0 + 32;
}
int main() {
    double temp;
    char unit;
    
    cout << "Enter temperature value: ";
    cin >> temp;
    cout << "Enter unit (C for Celsius, F for Fahrenheit, K for Kelvin): ";
    cin >> unit;

    cout << "\nConverted Temperatures:\n";
    
    if (unit == 'C' || unit == 'c') {
        cout << "Fahrenheit: " << celsiusToFahrenheit(temp) << " F\n";
        cout << "Kelvin: " << celsiusToKelvin(temp) << " K\n";
    } 
    else if (unit == 'F' || unit == 'f') {
        cout << "Celsius: " << fahrenheitToCelsius(temp) << " C\n";
        cout << "Kelvin: " << fahrenheitToKelvin(temp) << " K\n";
    } 
    else if (unit == 'K' || unit == 'k') {
        cout << "Celsius: " << kelvinToCelsius(temp) << " C\n";
        cout << "Fahrenheit: " << kelvinToFahrenheit(temp) << " F\n";
    } 
    else {
        cout << "Invalid unit entered! Please enter C, F, or K.\n";
    }
    return 0;
}