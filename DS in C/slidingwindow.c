#include <stdio.h>
#include<stdlib.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

typedef struct Queue {
    int *arr;
    int capacity;
    int size;
    int front;
    int rear;
} Queue;

Queue *createQueue(int capacity) {
    Queue *queue = (Queue *)malloc(sizeof(Queue));
    queue->arr = (int *)malloc(capacity * sizeof(int));
    queue->capacity = capacity;
    queue->size = 0;
    queue->front = 0;
    queue->rear = -1;
    return queue;
}

int isFull(Queue *queue) {
    return queue->size == queue->capacity;
}

int isEmpty(Queue *queue) {
    return queue->size == 0;
}

void enqueue(Queue *queue, int data) {
    if (isFull(queue)) {
        return;
    }
    queue->rear = (queue->rear + 1) % queue->capacity;
    queue->arr[queue->rear] = data;
    queue->size++;
}

int dequeue(Queue *queue) {
    if (isEmpty(queue)) {
        return -1;
    }
    int data = queue->arr[queue->front];
    queue->front = (queue->front + 1) % queue->capacity;
    queue->size--;
    return data;
}

int maxValue(Queue *queue) {
    int max = queue->arr[queue->front];
    for (int i = queue->front + 1; i <= queue->rear; i++) {
        max = MAX(max, queue->arr[i]);
    }
    return max;
}

void slideWindowMax(int A[], int n, int B) {
    Queue *queue = createQueue(B);
    int C[n - B + 1];
    for (int i = 0; i < B; i++) {
        enqueue(queue, A[i]);
    }
    C[0] = maxValue(queue);
    for (int i = B; i < n; i++) {
        dequeue(queue);
        enqueue(queue, A[i]);
        C[i - B + 1] = maxValue(queue);
    }
    for (int i = 0; i < n - B + 1; i++) {
        printf("%d ", C[i]);
    }
    printf("\n");
}

int main() {
    int A[] = {1, 3, -1, -3, 5, 3, 6, 7};
    int B = 3;
    slideWindowMax(A, sizeof(A) / sizeof(A[0]), B);
    return 0;
}