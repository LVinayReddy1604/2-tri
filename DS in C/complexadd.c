#include <stdio.h>

typedef struct {
    float real;
    float imag;
} Complex;

Complex addComplex(Complex num1, Complex num2) {
    Complex result;
    result.real = num1.real + num2.real;
    result.imag = num1.imag + num2.imag;
    return result;
}

int main() {
    Complex num1, num2, sum;

    // Input first complex number
    printf("Enter real and imaginary parts of first complex number:\n");
    scanf("%f %f", &num1.real, &num1.imag);

    // Input second complex number
    printf("Enter real and imaginary parts of second complex number:\n");
    scanf("%f %f", &num2.real, &num2.imag);

    // Perform addition
    sum = addComplex(num1, num2);

    // Display the result
    printf("Sum = %.2f + %.2fi\n", sum.real, sum.imag);

    return 0;
}

