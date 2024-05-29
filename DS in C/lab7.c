#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

// Depth Order Construction
Node* createDepthOrder() {
    Node* newNode;
    int value;
    
    printf("Enter data (-1 for no data): ");
    scanf("%d", &value);

    if (value == -1)
        return NULL;

    newNode = (Node*)malloc(sizeof(Node));
    newNode->data = value;

    printf("Enter left child of %d:\n", value);
    newNode->left = createDepthOrder();

    printf("Enter right child of %d:\n", value);
    newNode->right = createDepthOrder();

    return newNode;
}

// Level Order Construction
Node* createLevelOrder(int arr[], int i, int n) {
    if (i >= n)
        return NULL;

    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = arr[i];
    newNode->left = createLevelOrder(arr, 2 * i + 1, n);
    newNode->right = createLevelOrder(arr, 2 * i + 2, n);

    return newNode;
}

// Preorder traversal
void preorder(Node* root) {
    if (root != NULL) {
        printf("%d\t", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

// Inorder traversal
void inorder(Node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d\t", root->data);
        inorder(root->right);
    }
}

void postorder(Node* root) {
    if (root != NULL) {
        inorder(root->left);
        inorder(root->right);
        printf("%d\t", root->data);
    }
}

int main() {
    // Depth Order Construction
    Node* depthOrderRoot = createDepthOrder();
    
    printf("\nThe preorder traversal of tree (depth order construction) is:\n");
    preorder(depthOrderRoot);

    printf("\nThe inorder traversal of tree (depth order construction) is:\n");
    inorder(depthOrderRoot);

    printf("\n\nThe preorder traversal of tree (depth order construction) is:\n");
    preorder(depthOrderRoot);

    printf("\nThe inorder traversal of tree (depth order construction) is:\n");
    inorder(depthOrderRoot);
    
    printf("\nThe postorder traversal of tree (depth order construction) is:\n");
    postorder(depthOrderRoot);
    
    // Level Order Construction
    int levelOrderArr[] = {27, 14, 35, 10, 19, 31, 42};
    int n = sizeof(levelOrderArr) / sizeof(levelOrderArr[0]);
    Node* levelOrderRoot = createLevelOrder(levelOrderArr, 0, n);

    printf("\n\nThe preorder traversal of tree (level order construction) is:\n");
    preorder(levelOrderRoot);

    printf("\nThe inorder traversal of tree (level order construction) is:\n");
    inorder(levelOrderRoot);
    
    printf("\nThe postorder traversal of tree (level order construction) is:\n");
    postorder(levelOrderRoot);
    

    return 0;
}
