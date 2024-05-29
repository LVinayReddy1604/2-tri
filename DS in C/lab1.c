#include <stdio.h>
#include <string.h>
#include"functions.h"
#define MAX_EMPLOYEES 100

struct Employee {
    int empID;
    char empName[50];
    float empSalary;
};

struct Employee employees[MAX_EMPLOYEES];
int numEmployees = 0;

int main() {
	int i,j;
    int choice;
    int empID;
    int searchResult;
    float matrix1[2][2] = {{1.5, 2.3}, {3.2, 4.9}};
    float matrix2[2][2] = {{2.2, 1.5}, {4.5, 3.5}};
    float resultMatrix[2][2];

    do {
        printf("\nEmployee Salary Management System Menu:\n");
        printf("1. Insert Employee\n");
        printf("2. Delete Employee\n");
        printf("3. Search Employee\n");
        printf("4. Display Employees\n");
        printf("5. Add Matrices\n");
        printf("6. Subtract Matrices\n");
        printf("7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                insertEmployee();
                break;
            case 2:
                printf("Enter Employee ID to delete: ");
                scanf("%d", &empID);
                deleteEmployee(empID);
                break;
            case 3:
                printf("Enter Employee ID to search: ");
                scanf("%d", &empID);
                searchResult = linearSearchEmployee(empID);
                if (searchResult != -1) {
                    printf("Employee found at index %d\n", searchResult);
                } else {
                    printf("Employee not found.\n");
                }
                break;
            case 4:
                displayEmployees();
                break;
            case 5:
                addMatrix(matrix1, matrix2, resultMatrix);
                printf("Result of Matrix Addition:\n");
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        printf("%.2f\t", resultMatrix[i][j]);
                    }
                    printf("\n");
                }
                break;
            case 6:
                subtractMatrix(matrix1, matrix2, resultMatrix);
                printf("Result of Matrix Subtraction:\n");
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        printf("%.2f\t", resultMatrix[i][j]);
                    }
                    printf("\n");
                }
                break;
            case 7:
                printf("Exiting program. Goodbye!\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 7);

    return 0;
}
void insertEmployee() {
    if (numEmployees < MAX_EMPLOYEES) {
        struct Employee newEmployee;
        printf("Enter Employee ID: ");
        scanf("%d", &newEmployee.empID);
        printf("Enter Employee Name: ");
        scanf("%s", newEmployee.empName);
        printf("Enter Employee Salary: ");
        scanf("%f", &newEmployee.empSalary);

        employees[numEmployees] = newEmployee;
        numEmployees++;
        printf("Employee inserted successfully!\n");
    } else {
        printf("Maximum number of employees reached.\n");
    }
}

void deleteEmployee(int empID) {
	int i,j;
    for (i = 0; i < numEmployees; i++) {
        if (employees[i].empID == empID) {
            for (j = i; j < numEmployees - 1; j++) {
                employees[j] = employees[j + 1];
            }
            numEmployees--;
            printf("Employee with ID %d deleted successfully!\n", empID);
            return;
        }
    }
    printf("Employee with ID %d not found.\n", empID);
}

int linearSearchEmployee(int empID) {
	int i;
    for (i = 0; i < numEmployees; i++) {
        if (employees[i].empID == empID) {
            return i;
        }
    }
    return -1; // Employee not found
}

void displayEmployees() {
	int i;
    printf("Employee List:\n");
    printf("ID\tName\tSalary\n");
    for (i = 0; i < numEmployees; i++) {
        printf("%d\t%s\t%.2f\n", employees[i].empID, employees[i].empName, employees[i].empSalary);
    }
}

void addMatrix(float matrix1[][2], float matrix2[][2], float result[][2]) {
	int i,j;
    for (i = 0; i < 2; i++) {
        for (j = 0; j < 2; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
        }
    }
}

void subtractMatrix(float matrix1[][2], float matrix2[][2], float result[][2]) {
	int i,j;
    for (i = 0; i < 2; i++) {
        for (j = 0; j < 2; j++) {
            result[i][j] = matrix1[i][j] - matrix2[i][j];
        }
    }
}

