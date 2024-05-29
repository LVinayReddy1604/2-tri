#include <stdio.h>

#define MAX_DEGREE 100

void addPolynomials(int poly1[], int degree1, int poly2[], int degree2, int result[]) {
    int maxDegree = (degree1 > degree2) ? degree1 : degree2;

    for (int i = 0; i <= maxDegree; i++) {
        int term1 = (i <= degree1) ? poly1[i] : 0;
        int term2 = (i <= degree2) ? poly2[i] : 0;
        result[i] = term1 + term2;
    }
}

void displayPolynomial(int poly[], int degree) {
    for (int i = degree; i >= 0; i--) {
        if (poly[i] != 0) {
            printf("%dx^%d ", poly[i], i);
            if (i > 0) {
                printf("+ ");
            }
        }
    }
    printf("\n");
}

int main() {
    int poly1[MAX_DEGREE + 1], poly2[MAX_DEGREE + 1], result[MAX_DEGREE + 1];
    int degree1, degree2;

    // Input the degrees and coefficients of the first polynomial
    printf("Enter the degree of the first polynomial: ");
    scanf("%d", &degree1);
    printf("Enter the coefficients of the first polynomial (from highest degree to constant term):\n");
    for (int i = degree1; i >= 0; i--) {
        scanf("%d", &poly1[i]);
    }

    // Input the degrees and coefficients of the second polynomial
    printf("Enter the degree of the second polynomial: ");
    scanf("%d", &degree2);
    printf("Enter the coefficients of the second polynomial (from highest degree to constant term):\n");
    for (int i = degree2; i >= 0; i--) {
        scanf("%d", &poly2[i]);
    }

    // Perform addition
    addPolynomials(poly1, degree1, poly2, degree2, result);

    // Display the result
    printf("Sum of polynomials: ");
    displayPolynomial(result, (degree1 > degree2) ? degree1 : degree2);

    return 0;
}

