#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

struct Employee {
    int id;
    char name[50];
    double salary;
};

void generateRandomData(struct Employee arr[], int size) {
    srand(time(NULL));
	int i;
    for (i = 0; i < size; ++i) {
        arr[i].id = i + 1;
        sprintf(arr[i].name, "Employee%d", i + 1);
        arr[i].salary = rand() % 100000 + 50000; // Generating salary between 50000 and 150000
    }
}

void printData(struct Employee arr[], int size) {
    printf("ID\tName\tSalary\n");
    int i;
    for (i = 0; i < size; ++i) {
        printf("%d\t%s\t%.2f\n", arr[i].id, arr[i].name, arr[i].salary);
    }
}

void writeToFile(struct Employee arr[], int size, const char* fileName) {
    FILE* outputFile = fopen(fileName, "w");
	int i;
    for (i = 0; i < size; ++i) {
        fprintf(outputFile, "%d\t%s\t%.2f\n", arr[i].id, arr[i].name, arr[i].salary);
    }

    fclose(outputFile);
}

void merge(struct Employee arr[], int left, int middle, int right, int *indexComparisons, int *elementComparisons) {
    int n1 = middle - left + 1;
    int n2 = right - middle;
	int i,j;
    struct Employee leftArray[n1], rightArray[n2];

    for ( i = 0; i < n1; i++)
        leftArray[i] = arr[left + i];
    for (j = 0; j < n2; j++)
        rightArray[j] = arr[middle + 1 + j];

    i = 0, j = 0;
	int k = left;

    while (i < n1 && j < n2) {
        (*indexComparisons)++;
        if (leftArray[i].salary <= rightArray[j].salary) {
            (*elementComparisons)++;
            arr[k] = leftArray[i];
            i++;
        } else {
            (*elementComparisons)++;
            arr[k] = rightArray[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        (*elementComparisons)++;
        arr[k] = leftArray[i];
        i++;
        k++;
    }

    while (j < n2) {
        (*elementComparisons)++;
        arr[k] = rightArray[j];
        j++;
        k++;
    }
}

void mergeSort(struct Employee arr[], int left, int right, int *indexComparisons, int *elementComparisons) {
    if (left < right) {
        int middle = left + (right - left) / 2;

        mergeSort(arr, left, middle, indexComparisons, elementComparisons);
        mergeSort(arr, middle + 1, right, indexComparisons, elementComparisons);

        merge(arr, left, middle, right, indexComparisons, elementComparisons);
    }
}

int partition(struct Employee arr[], int low, int high, int *indexComparisons, int *elementComparisons) {
    double pivot = arr[high].salary;
    int i = (low - 1);
	int j;
    for (j = low; j <= high - 1; j++) {
        (*indexComparisons)++;
        if (arr[j].salary <= pivot) {
            (*elementComparisons)++;
            i++;
            struct Employee temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    struct Employee temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return (i + 1);
}

void quickSort(struct Employee arr[], int low, int high, int *indexComparisons, int *elementComparisons) {
    if (low < high) {
        int pi = partition(arr, low, high, indexComparisons, elementComparisons);

        quickSort(arr, low, pi - 1, indexComparisons, elementComparisons);
        quickSort(arr, pi + 1, high, indexComparisons, elementComparisons);
    }
}

int main() {
    const int size = 10;
    struct Employee employees[size];

    generateRandomData(employees, size);

    printf("Unsorted Data:\n");
    printData(employees, size);
    printf("\n");

    int mergeIndexComparisons = 0, mergeElementComparisons = 0;
    mergeSort(employees, 0, size - 1, &mergeIndexComparisons, &mergeElementComparisons);

    printf("Data after Merge Sort:\n");
    printData(employees, size);
    printf("Merge Sort Index Comparisons: %d\n", mergeIndexComparisons);
    printf("Merge Sort Element Comparisons: %d\n\n", mergeElementComparisons);

    writeToFile(employees, size, "merge_sort_output.txt");

    generateRandomData(employees, size);

    printf("Unsorted Data:\n");
    printData(employees, size);
    printf("\n");

    int quickIndexComparisons = 0, quickElementComparisons = 0;
    quickSort(employees, 0, size - 1, &quickIndexComparisons, &quickElementComparisons);

    printf("Data after Quick Sort:\n");
    printData(employees, size);
    printf("Quick Sort Index Comparisons: %d\n", quickIndexComparisons);
    printf("Quick Sort Element Comparisons: %d\n\n", quickElementComparisons);

    writeToFile(employees, size, "quick_sort_output.txt");

    return 0;
}

