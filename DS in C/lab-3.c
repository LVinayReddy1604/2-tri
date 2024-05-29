#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "stackESM.h"
void pushOperand(float value) {
    if (operandTop == MAX_SIZE - 1) {
        printf("Operand Stack Overflow\n");
        exit(EXIT_FAILURE);
    }
    operandStack[++operandTop] = value;
}

float popOperand() {
    if (operandTop == -1) {
        printf("Operand Stack Underflow\n");
        exit(EXIT_FAILURE);
    }
    return operandStack[operandTop--];
}

int isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}

int operatorPrecedence(char ch) {
    if (ch == '+' || ch == '-')
        return 1;
    else if (ch == '*' || ch == '/')
        return 2;
    else
        return 0; // For '('
}

void infixToPostfixConversion(char infix[]) {
    char postfix[MAX_SIZE];
    int i, j = 0;
    int openParenCount = 0;
    int closeParenCount = 0;

    for (i = 0; infix[i] != '\0'; i++) {
        if (isalnum(infix[i]) || infix[i] == '.') {
            postfix[j++] = infix[i];
        } else if (infix[i] == '(') {
            pushOperand(infix[i]);
            openParenCount++;
        } else if (infix[i] == ')') {
            while (operandTop != -1 && operandStack[operandTop] != '(') {
                postfix[j++] = popOperand();
            }
            if (operandTop != -1) {
                popOperand(); // Discard the '('
                closeParenCount++;
            } else {
                printf("Error: Unmatched closing parenthesis\n");
                exit(EXIT_FAILURE);
            }
        } else if (isOperator(infix[i])) {
            while (operandTop != -1 && operatorPrecedence(operandStack[operandTop]) >= operatorPrecedence(infix[i])) {
                postfix[j++] = popOperand();
            }
            pushOperand(infix[i]);
        }
    }

    // Pop any remaining operators from the stack
    while (operandTop != -1) {
        postfix[j++] = popOperand();
    }

    postfix[j] = '\0';

    if (openParenCount != closeParenCount) {
        printf("Warning: Unmatched number of parentheses\n");
    }

    printf("Postfix Expression: %s\n", postfix);
}

float evaluatePostfixExpression(char postfix[]) {
    int i;
    float operand, result;
    char str[10]; // To store the digits of operands

    for (i = 0; postfix[i] != '\0'; i++) {
        if (isdigit(postfix[i]) || postfix[i] == '.') {
            // If it's a digit or a decimal point, accumulate the digits to form the operand
            int k = 0;
            while (isdigit(postfix[i]) || postfix[i] == '.') {
                str[k++] = postfix[i++];
            }
            str[k] = '\0';
            operand = atof(str); // Convert the string to a float
            i--; // Move the index back one position after forming the operand
            pushOperand(operand);
        } else if (isOperator(postfix[i])) {
            float operand2 = popOperand();
            float operand1 = popOperand();

            switch (postfix[i]) {
                case '+':
                    pushOperand(operand1 + operand2);
                    break;
                case '-':
                    pushOperand(operand1 - operand2);
                    break;
                case '*':
                    pushOperand(operand1 * operand2);
                    break;
                case '/':
                    pushOperand(operand1 / operand2);
                    break;
            }
        }
    }

    result = popOperand();
    return result;
}

int main() {
    char infix[MAX_SIZE];

    printf("Enter an infix expression for Employee Salary Management: ");
    scanf("%s", infix);

    infixToPostfixConversion(infix);

    float result = evaluatePostfixExpression(infix);
    printf("Net Salary: %.2f\n", result);

    return 0;
}

