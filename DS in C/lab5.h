typedef struct {
    int id;
    char name[50];
    double basicsal;
} Employee;

void printEmployee(Employee emp);
int linearSearch(Employee arr[], int n, int key, int *elementComparisons, int *indexComparisons);
int sentinelSearch(Employee arr[], int n, int key, int *elementComparisons, int *indexComparisons);
int binarySearch(Employee arr[], int low, int high, int key, int *elementComparisons, int *indexComparisons);
void bubbleSort(Employee arr[], int n, int *comparisons, int *swaps);
void insertionSort(Employee arr[], int n, int *comparisons, int *swaps);
int nameSearch(Employee arr[], int n, char targetName[], int *elementComparisons, int *indexComparisons);
