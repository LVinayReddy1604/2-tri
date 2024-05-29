//LEVEL ORDER CONSTRUCTION
#include <stdio.h>
#include <stdlib.h>  
struct Node
{
    int data;
    struct Node* left, * right;
};
  
struct Node* newNode(int data)
{
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    return (node);
}
  
struct Node* insert(int arr[], struct Node* root, int i, int n)
{
    // Base case for recursion
    if (i < n)
    {
        struct Node* temp = newNode(arr[i]);
        root = temp;
  
        // insert left child
        root->left = insert(arr, root->left, 2 * i + 1, n);
  
        // insert right child
        root->right = insert(arr, root->right, 2 * i + 2, n);
    }
    return root;
}
  
// Function to print tree nodes in InOrder fashion
void inOrder(struct Node* root)
{
    if (root != NULL)
    {
        inOrder(root->left);
        printf("%d\t", root->data );
        inOrder(root->right);
    }
}
  
int main()
{
    int arr[] = { 27, 14, 35, 10, 19, 31, 42 };
    int n = sizeof(arr)/sizeof(arr[0]);
    struct Node* root = insert(arr, root, 0, n);
    inOrder(root);
}
  
