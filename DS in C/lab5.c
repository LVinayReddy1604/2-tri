#include <stdio.h>
#include<conio.h>
#include "lab5.h"


int main() {
    int n, key,i;
	char targetName[50];
    printf("Enter the number of employees: ");
    scanf("%d", &n);

    Employee employees[n];

    printf("Enter employee details:\n");
    for (i = 0; i < n; i++) {
        printf("\n Enter details for employee %d:\n", i + 1);
        printf("Employee ID: ");
        scanf("%d", &employees[i].id);
        printf("Name: ");
        scanf("%s", employees[i].name);
        printf("Basic Salary:");
        scanf("%lf",&employees[i].basicsal);
    }
	while(1){
	
    printf("\n1. Bubble Sort\n2. Insertion Sort\n3. Name Search\n4. Linear Search\n5. Sentinel Search\n6. Binary Search\n7. Exit\n");
    printf("Enter your choice: ");

    int choice;
    scanf("%d", &choice);

    switch (choice) {
        case 1: {
            int bubbleComparisons = 0, bubbleSwaps = 0;
            bubbleSort(employees, n, &bubbleComparisons, &bubbleSwaps);
            printf("Bubble Sort:\n");
            printf("Comparisons: %d\n", bubbleComparisons);
            printf("Swaps: %d\n", bubbleSwaps);
            break;
        }
        case 2: {
            int insertionComparisons = 0, insertionSwaps = 0;
            insertionSort(employees, n, &insertionComparisons, &insertionSwaps);
            printf("\nInsertion Sort:\n");
            printf("Comparisons: %d\n", insertionComparisons);
            printf("Swaps: %d\n", insertionSwaps);
            break;
        }
        case 3:{
        	int nameElementComparisons = 0, nameIndexComparisons = 0;
            printf("Enter the employee name to search: ");
            scanf("%s", targetName);
            int nameResult = nameSearch(employees, n, targetName, &nameElementComparisons, &nameIndexComparisons);
            printf("\nName Search:\n");
            printf("Element Comparisons: %d\n", nameElementComparisons);
            printf("Index Comparisons: %d\n", nameIndexComparisons);
            if (nameResult != -1) {
                printf("Employee found:\n");
                printEmployee(employees[nameResult]);
            } else {
                printf("Employee not found\n");
            }
            break;
		}
		case 4:{
            int linearElementComparisons = 0, linearIndexComparisons = 0;
            printf("Enter the employee ID to search: ");
            scanf("%d", &key);
            int linearResult = linearSearch(employees, n, key, &linearElementComparisons, &linearIndexComparisons);
            printf("\nLinear Search:\n");
            printf("Element Comparisons: %d\n", linearElementComparisons);
            printf("Index Comparisons: %d\n", linearIndexComparisons);
            if (linearResult != -1) {
                printf("Employee found:\n");
                printEmployee(employees[linearResult]);
            } else {
                printf("Employee not found\n");
            }
            break;
        }
        case 5: {
            int sentinelElementComparisons = 0, sentinelIndexComparisons = 0;
            printf("Enter the employee ID to search: ");
            scanf("%d", &key);
            int sentinelResult = sentinelSearch(employees, n, key, &sentinelElementComparisons, &sentinelIndexComparisons);
            printf("\nSentinel Search:\n");
            printf("Element Comparisons: %d\n", sentinelElementComparisons);
            printf("Index Comparisons: %d\n", sentinelIndexComparisons);
            if (sentinelResult != -1) {
                printf("Employee found:\n");
                printEmployee(employees[sentinelResult]);
            } else {
                printf("Employee not found\n");
            }
            break;
        }
        case 6: {
            int binaryElementComparisons = 0, binaryIndexComparisons = 0;
            printf("Enter the employee ID to search: ");
            scanf("%d", &key);
            int binaryResult = binarySearch(employees, 0, n - 1, key, &binaryElementComparisons, &binaryIndexComparisons);
            printf("\nBinary Search:\n");
            printf("Element Comparisons: %d\n", binaryElementComparisons);
            printf("Index Comparisons: %d\n", binaryIndexComparisons);
            if (binaryResult != -1) {
                printf("Employee found:\n");
                printEmployee(employees[binaryResult]);
            } else {
                printf("Employee not found\n");
            }
            break;
        }
        case 7:{
			return 0;
		}
        default:
            printf("Invalid choice\n");
    }
}

    return 0;
}

void bubbleSort(Employee arr[], int n, int *comparisons, int *swaps) {
    int i,j;
	for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            (*comparisons)++;
            if (arr[j].id > arr[j + 1].id) {
                (*swaps)++;
                Employee temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void insertionSort(Employee arr[], int n, int *comparisons, int *swaps) {
    int i;
	for (i = 1; i < n; i++) {
        Employee key = arr[i];
        int j = i - 1;
        (*comparisons)++;
        while (j >= 0 && arr[j].id > key.id) {
            (*comparisons)++;
            (*swaps)++;
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

int linearSearch(Employee arr[], int n, int key, int *elementComparisons, int *indexComparisons) {
    int i;
	for (i = 0; i < n; i++) {
        (*elementComparisons)++;
        if (arr[i].id == key) {
            (*indexComparisons)++;
            return i;
        }
        (*indexComparisons)++;
    }
    return -1;
}

int sentinelSearch(Employee arr[], int n, int key, int *elementComparisons, int *indexComparisons) {
    int last = arr[n - 1].id;
    arr[n - 1].id = key;
    int i = 0;
    while (arr[i].id != key) {
        (*elementComparisons)++;
        i++;
        (*indexComparisons)++;
    }
    arr[n - 1].id = last;
    if (i < n - 1 || arr[n - 1].id == key) {
        (*indexComparisons)++;
        return i;
    }
    return -1;
}

int binarySearch(Employee arr[], int low, int high, int key, int *elementComparisons, int *indexComparisons) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        (*elementComparisons)++;
        if (arr[mid].id == key) {
            (*indexComparisons)++;
            return mid;
        }
        (*indexComparisons)++;
        if (arr[mid].id < key) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}

int nameSearch(Employee arr[], int n, char targetName[], int *elementComparisons, int *indexComparisons) {
    int i;
	for (i = 0; i < n; i++) {
        (*elementComparisons)++;
        if (strcmp(arr[i].name, targetName) == 0) {
            (*indexComparisons)++;
            return i;
        }
        (*indexComparisons)++;
    }
    return -1;
}
void printEmployee(Employee emp) {
    printf("Employee ID: %d\n", emp.id);
    printf("Name: %s\n", emp.name);
    printf("Basic Salary:%lf",emp.basicsal);
}

