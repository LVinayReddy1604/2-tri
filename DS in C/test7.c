#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    return node;
}

struct Node* insert(int arr[], struct Node* root, int i, int n) {
    if (i < n) {
        struct Node* temp = newNode(arr[i]);
        root = temp;
        root->left = insert(arr, root->left, 2 * i + 1, n);
        root->right = insert(arr, root->right, 2 * i + 2, n);
    }
    return root;
}

void inOrder(struct Node* root) {
    if (root != NULL) {
        inOrder(root->left);
        printf("%d\t", root->data);
        inOrder(root->right);
    }
}

void preOrder(struct Node* root) {
    if (root != NULL) {
        printf("%d\t", root->data);
        preOrder(root->left);
        preOrder(root->right);
    }
}

void postOrder(struct Node* root) {
    if (root != NULL) {
        postOrder(root->left);
        postOrder(root->right);
        printf("%d\t", root->data);
    }
}

int main() {
    int levelOrderArr[] = {27, 14, 35, 10, 19, 31, 42};
    int n = sizeof(levelOrderArr) / sizeof(levelOrderArr[0]);
    struct Node* levelOrderRoot = insert(levelOrderArr, levelOrderRoot, 0, n);

    printf("\nInorder traversal (created using level order): ");
    inOrder(levelOrderRoot);
    printf("\nPreorder traversal (created using level order): ");
    preOrder(levelOrderRoot);
    printf("\nPostorder traversal (created using level order): ");
    postOrder(levelOrderRoot);

    int depthOrderArr[] = {27, 14, 10, 19, 35, 31, 42};
    n = sizeof(depthOrderArr) / sizeof(depthOrderArr[0]);
    struct Node* depthOrderRoot = insert(depthOrderArr, depthOrderRoot, 0, n);

    printf("\n\nInorder traversal (created using depth order): ");
    inOrder(depthOrderRoot);
    printf("\nPreorder traversal (created using depth order): ");
    preOrder(depthOrderRoot);
    printf("\nPostorder traversal (created using depth order): ");
    postOrder(depthOrderRoot);

    getch();
    return 0;
}
