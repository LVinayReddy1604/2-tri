struct Employee {
    char name[50];
    float salary;
    struct Employee* next;
};

struct EmployeeSalaryQueue {
    struct Employee* front;
    struct Employee* rear;
};

void initializeQueue(struct EmployeeSalaryQueue* queue);
int isEmpty(struct EmployeeSalaryQueue* queue);
void enqueue(struct EmployeeSalaryQueue* queue, const char* name, float salary);
struct Employee* dequeue(struct EmployeeSalaryQueue* queue);
struct Employee* peek(struct EmployeeSalaryQueue* queue);
void display(struct EmployeeSalaryQueue* queue);
void freeQueue(struct EmployeeSalaryQueue* queue);
void getEmployeeDetails(char* name, float* salary);
