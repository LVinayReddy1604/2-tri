#include <stdio.h>
#include <stdlib.h>

// Structure to represent a vehicle node
struct Vehicle {
    char name[20];
    char regNo[20];
    int priority;
    struct Vehicle* next;
};

// Structure to represent a linear queue
struct Queue {
    struct Vehicle* front;
    struct Vehicle* rear;
};

// Function to initialize an empty queue
void initializeQueue(struct Queue* q) {
    q->front = q->rear = NULL;
}

// Function to enqueue a vehicle node into the queue
void enqueue(struct Queue* q, struct Vehicle* newVehicle) {
    if (q->rear == NULL) {
        q->front = q->rear = newVehicle;
    } else {
        q->rear->next = newVehicle;
        q->rear = newVehicle;
    }
    newVehicle->next = NULL;
}

// Function to read details for a vehicle node and create a linear queue
void createQueue(struct Queue* q) {
    int n,i;
    printf("Enter the number of vehicles: ");
    scanf("%d", &n);

    for (i = 0; i < n; ++i) {
        struct Vehicle* newVehicle = (struct Vehicle*)malloc(sizeof(struct Vehicle));
        
        printf("\nEnter details for Vehicle %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", newVehicle->name);

        printf("Registration No: ");
        scanf("%s", newVehicle->regNo);

        // Validate priority value
        do {
            printf("Priority (1 to 20): ");
            scanf("%d", &newVehicle->priority);
        } while (newVehicle->priority < 1 || newVehicle->priority > 20);

        enqueue(q, newVehicle);
    }
}

// Function to display details of all vehicle nodes
void displayAll(struct Queue* q) {
    struct Vehicle* current = q->front;

    printf("\nDetails of all vehicle nodes:\n");
    while (current != NULL) {
        printf("Name: %s, Registration No: %s, Priority: %d\n", current->name, current->regNo, current->priority);
        current = current->next;
    }
}

// Function to display vehicle nodes with the highest priority
void displayHighestPriority(struct Queue* q) {
    struct Vehicle* current = q->front;
    int maxPriority = 0;

    // Find the maximum priority
    while (current != NULL) {
        if (current->priority > maxPriority) {
            maxPriority = current->priority;
        }
        current = current->next;
    }

    // Display vehicle nodes with the highest priority
    printf("\nVehicle nodes with the highest priority (%d):\n", maxPriority);
    current = q->front;
    while (current != NULL) {
        if (current->priority == maxPriority) {
            printf("Name: %s, Registration No: %s, Priority: %d\n", current->name, current->regNo, current->priority);
        }
        current = current->next;
    }
}

// Function to split the queue into highQ and lowQ
void splitQueue(struct Queue* q, struct Queue* highQ, struct Queue* lowQ) {
    struct Vehicle* current = q->front;

    while (current != NULL) {
        if (current->priority <= 10) {
            enqueue(highQ, current);
        } else {
            enqueue(lowQ, current);
        }
        current = current->next;
    }
}

// Function to display both highQ and lowQ
void displaySplitQueues(struct Queue* highQ, struct Queue* lowQ) {
    printf("\nHigh Priority Queue:\n");
    displayAll(highQ);

    printf("\nLow Priority Queue:\n");
    displayAll(lowQ);
}

int main() {
    struct Queue vehicleQueue;
    struct Queue highPriorityQueue;
    struct Queue lowPriorityQueue;

    initializeQueue(&vehicleQueue);
    initializeQueue(&highPriorityQueue);
    initializeQueue(&lowPriorityQueue);

    createQueue(&vehicleQueue);
    displayAll(&vehicleQueue);
    displayHighestPriority(&vehicleQueue);

    splitQueue(&vehicleQueue, &highPriorityQueue, &lowPriorityQueue);
    displaySplitQueues(&highPriorityQueue, &lowPriorityQueue);

    return 0;
}

