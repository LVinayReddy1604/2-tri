#include <stdio.h>
#include <string.h>

#define MAX_STUDENTS 100

struct Student {
    int studentID;
    char studentName[50];
    float scores[3];
};

struct Student students[MAX_STUDENTS];
int numStudents = 0;

int i, j;  // Define i and j with scope for the whole function

void insertStudent() {
    if (numStudents < MAX_STUDENTS) {
        struct Student newStudent;
        printf("Enter Student ID: ");
        scanf("%d", &newStudent.studentID);
        printf("Enter Student Name: ");
        scanf("%s", newStudent.studentName);
        printf("Enter scores for three subjects: ");
        for (i = 0; i < 3; i++) {
            scanf("%f", &newStudent.scores[i]);
        }

        students[numStudents] = newStudent;
        numStudents++;
        printf("Student inserted successfully!\n");
    } else {
        printf("Maximum number of students reached.\n");
    }
}

void deleteStudent(int studentID) {
    for (i = 0; i < numStudents; i++) {
        if (students[i].studentID == studentID) {
            for (j = i; j < numStudents - 1; j++) {
                students[j] = students[j + 1];
            }
            numStudents--;
            printf("Student with ID %d deleted successfully!\n", studentID);
            return;
        }
    }
    printf("Student with ID %d not found.\n", studentID);
}

int linearSearchStudent(int studentID) {
    for (i = 0; i < numStudents; i++) {
        if (students[i].studentID == studentID) {
            return i;
        }
    }
    return -1; // Student not found
}

void displayStudents() {
    printf("Student List:\n");
    printf("ID\tName\tSubject1\tSubject2\tSubject3\n");
    for (i = 0; i < numStudents; i++) {
        printf("%d\t%s\t%.2f\t%.2f\t%.2f\n", students[i].studentID, students[i].studentName,
               students[i].scores[0], students[i].scores[1], students[i].scores[2]);
    }
}

// ... Rest of the code remains the same

int main() {
    int choice;
    int studentID;
    int searchResult;
    float matrix1[3][3] = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
    float matrix2[3][3] = {{9.0, 8.0, 7.0}, {6.0, 5.0, 4.0}, {3.0, 2.0, 1.0}};
    float resultMatrix[3][3];

    do {
        printf("\nStudent Management System Menu:\n");
        printf("1. Insert Student\n");
        printf("2. Delete Student\n");
        printf("3. Search Student\n");
        printf("4. Display Students\n");
        printf("5. Add Matrices\n");
        printf("6. Subtract Matrices\n");
        printf("7. Multiply Matrices\n");
        printf("8. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                insertStudent();
                break;
            case 2:
                printf("Enter Student ID to delete: ");
                scanf("%d", &studentID);
                deleteStudent(studentID);
                break;
            case 3:
                printf("Enter Student ID to search: ");
                scanf("%d", &studentID);
                searchResult = linearSearchStudent(studentID);
                if (searchResult != -1) {
                    printf("Student found at index %d\n", searchResult);
                } else {
                    printf("Student not found.\n");
                }
                break;
            case 4:
                displayStudents();
                break;
            case 5:
                addMatrices(matrix1, matrix2, resultMatrix);
                printf("Result of Matrix Addition:\n");
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        printf("%.2f\t", resultMatrix[i][j]);
                    }
                    printf("\n");
                }
                break;
            case 6:
                subtractMatrices(matrix1, matrix2, resultMatrix);
                printf("Result of Matrix Subtraction:\n");
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        printf("%.2f\t", resultMatrix[i][j]);
                    }
                    printf("\n");
                }
                break;
            case 7:
                multiplyMatrices(matrix1, matrix2, resultMatrix);
                printf("Result of Matrix Multiplication:\n");
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        printf("%.2f\t", resultMatrix[i][j]);
                    }
                    printf("\n");
                }
                break;
            case 8:
                printf("Exiting program. Goodbye!\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 8);

    return 0;
}
