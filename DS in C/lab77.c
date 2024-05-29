#include <stdio.h>
#include <stdlib.h>

// Node structure for the binary tree
struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

// Function to create a new node
struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    return node;
}

// Function to perform in-order traversal
void inOrder(struct Node* root) {
    if (root != NULL) {
        inOrder(root->left);
        printf("%d\t", root->data);
        inOrder(root->right);
    }
}

// Function to perform pre-order traversal
void preOrder(struct Node* root) {
    if (root != NULL) {
        printf("%d\t", root->data);
        preOrder(root->left);
        preOrder(root->right);
    }
}

// Function to perform post-order traversal
void postOrder(struct Node* root) {
    if (root != NULL) {
        preOrder(root->left);
        preOrder(root->right);
        printf("%d\t", root->data);
    }
}
// Function to create a binary tree using level order traversal
struct Node* createLevelOrderTree(int arr[], int i, int n) {
    struct Node* root = NULL;

    // Base case for recursion
    if (i < n) {
        root = newNode(arr[i]);

        // Insert left child
        root->left = createLevelOrderTree(arr, 2 * i + 1, n);

        // Insert right child
        root->right = createLevelOrderTree(arr, 2 * i + 2, n);
    }

    return root;
}

// Function to create a binary tree using pre-order and in-order traversals
struct Node* createTreeFromTraversals(int preOrder[], int inOrder[], int preStart, int preEnd, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd)
        return NULL;

    // The first element in preOrder is the root
    struct Node* root = newNode(preOrder[preStart]);

    // Find the index of root in inOrder
    int rootIndex;
    for (rootIndex = inStart; rootIndex <= inEnd; rootIndex++) {
        if (inOrder[rootIndex] == root->data)
            break;
    }

    // Recursively construct the left and right subtrees
    root->left = createTreeFromTraversals(preOrder, inOrder, preStart + 1, preStart + (rootIndex - inStart), inStart, rootIndex - 1);
    root->right = createTreeFromTraversals(preOrder, inOrder, preStart + (rootIndex - inStart) + 1, preEnd, rootIndex + 1, inEnd);

    return root;
}

int main() {
    // Example 1: Create a binary tree using level order traversal
    int levelOrderArr[] = { 27, 14, 35, 10, 19, 31, 42 };
    int levelOrderSize = sizeof(levelOrderArr) / sizeof(levelOrderArr[0]);
    struct Node* levelOrderRoot = createLevelOrderTree(levelOrderArr, 0, levelOrderSize);
    printf("\n Binary Tree created using Level Order Traversal:\n");
    printf("\ninorder: ");
    inOrder(levelOrderRoot);
    printf("\npreorder: ");
    preOrder(levelOrderRoot);
    printf("\npostorder: ");
    postOrder(levelOrderRoot);
    

    // Example 2: Create a binary tree using pre-order and in-order traversals
    int preOrderArr[] = { 27, 14, 10, 19, 35, 31, 42 };
    int inOrderArr[] = { 10, 14, 19, 27, 31, 35, 42 };
    int treeSize = sizeof(preOrderArr) / sizeof(preOrderArr[0]);
    struct Node* preInOrderRoot = createTreeFromTraversals(preOrderArr, inOrderArr, 0, treeSize - 1, 0, treeSize - 1);

    printf("\n\n Binary Tree created using Pre-Order and In-Order Traversals:\n");
    inOrder(preInOrderRoot);
    printf("\n");

    return 0;
}
