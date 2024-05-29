#include<stdio.h>
#include <stdlib.h>

struct node 
{ 
	int data; 
	struct node *left; 
	struct node *right; 
};



struct node* newNode(int data) 
{ 
	int left,right;
	struct node* node = (struct node*)malloc(sizeof(struct node)); 
	node->data = data;
	printf("Enter the Left node value(-1 if empty)");
	scanf("%d",&left);
	if(left==-1){
		node->left==NULL;
	}else{
	node->left = newNode(left);
	}
	printf("Enter the Right node value(-1 if empty)\n");
	scanf("%d",&right);
	if(right==-1){
		node->right=NULL;
	}else{
	node->right = newNode(right); 
	}
	return(node); 
	
}

void display(struct node *root)
{
   if(root != NULL){
      display(root->left);
      printf("%d\t",root->data);
      display(root->right);
   }
}
int main() 
{ 
	int data;
	struct node *root = newNode(1); 
	root->left	 = newNode(2); 
	root->right	 = newNode(3); 
	root->left->left = newNode(4); 

	printf("Enter the data for the root node");
	scanf("%d",&data);
	newNode(data);
	display(root);
	getch(); 
}
