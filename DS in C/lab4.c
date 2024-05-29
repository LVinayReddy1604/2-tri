#include <stdio.h>
#include <stdlib.h>
#include "que.h"

int main() {
    struct EmployeeSalaryQueue salaryQueue;
    initializeQueue(&salaryQueue);

    int choice;
    char name[50];
    float salary;

    do {
        printf("\nEmployee Salary Management System\n");
        printf("1. Enqueue (Add an Employee)\n");
        printf("2. Dequeue (Remove an Employee)\n");
        printf("3. Display Employees\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                getEmployeeDetails(name, &salary);
                enqueue(&salaryQueue, name, salary);
                printf("Employee added to the queue.\n");
                break;

            case 2:
                if (isEmpty(&salaryQueue)) {
                    printf("Queue is empty. No employee to dequeue.\n");
                } else {
                    struct Employee* dequeuedEmployee = dequeue(&salaryQueue);
                    printf("Dequeued: Name: %s, Salary: %.2f\n", dequeuedEmployee->name, dequeuedEmployee->salary);
                    free(dequeuedEmployee);  // Free the memory of the dequeued employee
                }
                break;

            case 3:
                if (isEmpty(&salaryQueue)) {
                    printf("Queue is empty.\n");
                } else {
                    printf("Employee Salary Queue:\n");
                    display(&salaryQueue);
                }
                break;

            case 4:
                printf("Exiting the program.\n");
                break;

            default:
                printf("Invalid choice. Please enter a valid option.\n");
        }

    } while (choice != 4);

    // Free memory allocated for the queue before exiting
    freeQueue(&salaryQueue);

    return 0;
}

void initializeQueue(struct EmployeeSalaryQueue* queue) {
    queue->front = NULL;
    queue->rear = NULL;
}

int isEmpty(struct EmployeeSalaryQueue* queue) {
    return queue->front == NULL;
}

void enqueue(struct EmployeeSalaryQueue* queue, const char* name, float salary) {
    struct Employee* newEmployee = (struct Employee*)malloc(sizeof(struct Employee));
    if (newEmployee == NULL) {
        fprintf(stderr, "Memory allocation error\n");
        exit(EXIT_FAILURE);
    }
    snprintf(newEmployee->name, sizeof(newEmployee->name), "%s", name);
    newEmployee->salary = salary;
    newEmployee->next = NULL;
	if (isEmpty(queue)) {
        queue->front = queue->rear = newEmployee;
    } else {
        queue->rear->next = newEmployee;
        queue->rear = newEmployee;
    }
}

struct Employee* dequeue(struct EmployeeSalaryQueue* queue) {
    if (isEmpty(queue)) {
        return NULL;
    }

    struct Employee* dequeuedEmployee = queue->front;
    queue->front = queue->front->next;

    if (queue->front == NULL) {
        queue->rear = NULL;
    }

    return dequeuedEmployee;
}

struct Employee* peek(struct EmployeeSalaryQueue* queue) {
    return queue->front;
}

void display(struct EmployeeSalaryQueue* queue) {
    struct Employee* current = queue->front;
    while (current != NULL) {
        printf("Name: %s, Salary: %.2f\n", current->name, current->salary);
        current = current->next;
    }
}

void freeQueue(struct EmployeeSalaryQueue* queue) {
    struct Employee* current = queue->front;
    while (current != NULL) {
        struct Employee* temp = current;
        current = current->next;
        free(temp);
    }
}

void getEmployeeDetails(char* name, float* salary) {
    printf("Enter Employee Name: ");
    scanf("%s", name);

    printf("Enter Employee Salary: ");
    scanf("%f", salary);
}


