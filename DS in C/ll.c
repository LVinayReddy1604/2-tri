#include <stdio.h>
#include <stdlib.h>

// Define a Node structure for the linked list
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Function to insert a new node at the end of the linked list
void insertNode(Node** head, int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;

    if (*head == NULL) {
        *head = newNode;
    } else {
        Node* temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

// Function to merge two sorted linked lists
Node* mergeSortedLists(Node* list1, Node* list2) {
    Node dummy;
    Node* current = &dummy;

    while (list1 != NULL && list2 != NULL) {
        if (list1->data < list2->data) {
            current->next = list1;
            list1 = list1->next;
        } else {
            current->next = list2;
            list2 = list2->next;
        }
        current = current->next;
    }

    // If one of the lists is not empty, append the remaining nodes
    if (list1 != NULL) {
        current->next = list1;
    } else {
        current->next = list2;
    }

    return dummy.next;
}

// Function to remove duplicate elements from a sorted linked list
void removeDuplicates(Node* head) {
    Node* current = head;

    while (current != NULL && current->next != NULL) {
        if (current->data == current->next->data) {
            Node* temp = current->next;
            current->next = current->next->next;
            free(temp);
        } else {
            current = current->next;
        }
    }
}

// Function to partition a linked list around a given value x
Node* partitionList(Node* head, int x) {
    Node* lessList = NULL;
    Node* greaterList = NULL;
    Node* current = head;

    while (current != NULL) {
        Node* next = current->next;
        if (current->data < x) {
            current->next = lessList;
            lessList = current;
        } else {
            current->next = greaterList;
            greaterList = current;
        }
        current = next;
    }

    // Connect the lessList and greaterList
    if (lessList == NULL) {
        return greaterList;
    }

    Node* temp = lessList;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = greaterList;

    return lessList;
}

// Function to print the elements of a linked list
void printList(Node* head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}

// Function to free the memory allocated for a linked list
void freeList(Node* head) {
    while (head != NULL) {
        Node* temp = head;
        head = head->next;
        free(temp);
    }
}

int main() {
    // Merge two sorted linked lists
    Node* list1 = NULL;
    insertNode(&list1, 1);
    insertNode(&list1, 3);
    insertNode(&list1, 5);

    Node* list2 = NULL;
    insertNode(&list2, 2);
    insertNode(&list2, 4);
    insertNode(&list2, 6);

    Node* mergedList = mergeSortedLists(list1, list2);
    printf("Merged Sorted List: ");
    printList(mergedList);

    // Remove duplicates from a sorted linked list
    Node* sortedListWithDuplicates = NULL;
    insertNode(&sortedListWithDuplicates, 1);
    insertNode(&sortedListWithDuplicates, 1);
    insertNode(&sortedListWithDuplicates, 2);
    insertNode(&sortedListWithDuplicates, 3);
    insertNode(&sortedListWithDuplicates, 3);
    insertNode(&sortedListWithDuplicates, 4);
    printf("Original Sorted List with Duplicates: ");
    printList(sortedListWithDuplicates);

    removeDuplicates(sortedListWithDuplicates);
    printf("List after removing duplicates: ");
    printList(sortedListWithDuplicates);

    // Partition a linked list around a given value
    Node* originalList = NULL;
    insertNode(&originalList, 3);
    insertNode(&originalList, 5);
    insertNode(&originalList, 8);
    insertNode(&originalList, 5);
    insertNode(&originalList, 10);
    insertNode(&originalList, 2);
    insertNode(&originalList, 1);

    int partitionValue = 5;
    printf("Original List: ");
    printList(originalList);

    Node* partitionedList = partitionList(originalList, partitionValue);
    printf("List after partitioning around %d: ", partitionValue);
    printList(partitionedList);

    // Free the memory allocated for the linked lists
    freeList(mergedList);
    freeList(sortedListWithDuplicates);
    freeList(partitionedList);

    return 0;
}

