#include<stdio.h>
#include<conio.h>
#include <stdlib.h>
struct Node
{
   char data;
   struct Node *next;
}*top = NULL;

void push(char);
void pop();
void display();

void main()
{
   int choice, value;
    printf("\n:: Stack using Linked List ::\n");
   while(1){
      printf("\n****** MENU ******\n");
      printf("1. Push\n2. Pop\n3. Display\n4. Exit\n");
      printf("Enter your choice: ");
      fflush(stdin);
      scanf("%d",&choice);
      switch(choice){
	 case 1: printf("Enter the value to be insert: ");
	 	fflush(stdin);
		 scanf("%c", &value);
		 push(value);
		 break;
	 case 2: pop(); break;
	 case 3: display(); break;
	 case 4: exit(0);
	 default: printf("\nWrong selection!!! Please try again!!!\n");
      }
   }
}
void push(char value)
{
   struct Node *newNode;
   newNode = (struct Node*)malloc(sizeof(struct Node));
   newNode->data = value;
   if(top == NULL)
      newNode->next = NULL;
   else
      newNode->next = top;
   top = newNode;
   printf("\nInsertion is Success!!!\n");
}
void pop()
{
   if(top == NULL)
      printf("\nStack is Empty!!!\n");
   else{
      struct Node *temp = top;
      printf("\nDeleted element: %c", temp->data);
      top = temp->next;
      free(temp);
   }
}
void display()
{
   if(top == NULL)
      printf("\nStack is Empty!!!\n");
   else{
      struct Node *temp = top;
      while(temp->next != NULL){
	 printf("%c--->",temp->data);
	 temp = temp -> next;
      }
      printf("%c--->NULL",temp->data);
   }
}

