struct Employee {
    int id;
    char name[50];
    double salary;
};
void generateRandomData(struct Employee arr[], int size);
void printData(struct Employee arr[], int size);
void writeToFile(struct Employee arr[], int size, const char* fileName);
void merge(struct Employee arr[], int left, int middle, int right);
void mergeSort(struct Employee arr[], int left, int right);
void mergeSort(struct Employee arr[], int left, int right);
void quickSort(struct Employee arr[], int low, int high);
