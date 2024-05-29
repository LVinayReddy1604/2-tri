
#define MAX_SIZE 100

float operandStack[MAX_SIZE];
int operandTop = -1;
void pushOperand(float value);
float popOperand();
int isOperator(char ch);
int operatorPrecedence(char ch);
void infixToPostfixConversion(char infix[]);
float evaluatePostfixExpression(char postfix[]);
