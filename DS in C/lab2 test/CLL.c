// Insertion & deletion in between is same as singly linkedlist
// this program demonstrates insertion & deletion in CLL in beginning & end

#include<stdio.h>  
#include<stdlib.h>  
struct cll  
{  
    int data;
	struct cll *link;  
      
} *head=NULL;
void create();
void display (struct cll *);
void insbeg (struct cll *);
void insend (struct cll *);
void delbeg (struct cll *);
void delend (struct cll *);

main()
{
	  int value, choice;
      while(1){
      printf("\n\n***** MENU *****\n");
      printf("1. Creation of CLL\n 2. Display\n 3. insertion beginning \n 4.insertion end \n 5.deletion beginning \n 6. deletion end \n 7.Exit");
      printf("\nEnter your choice: ");
      scanf("%d",&choice);
      switch(choice){
	 case 1: if (head!=NULL)
	 		printf("CLL ALREADY CREATED\n");
		 else
		 	create();
		 		 break;
	 case 2: if (head==NULL)
	 printf("CLL not created\n");
	 else
	 	display(head);
		 break;
	 case 3: if (head==NULL)
	 printf("CLL not created\n");
	 else
	 	insbeg(head);
		 break;
	 case 4: if (head==NULL)
	 printf("CLL not created\n");
	 else
	 	insend(head);
		 break;
		 case 5 :if (head==NULL)
	 printf("CLL not created\n");
	 else
	 	delbeg(head);
		 break;
		 case 6: if (head==NULL)
	 printf("CLL not created\n");
	 else
	 	delend(head);
		 break;
		 case 7: 
		 exit(0);
	 default: printf("\nWrong selection!!! Try again!!!");
      }
   }
}
void  create()
{
	struct cll * newnode, *temp ;
	char ch;
	do
	{
		newnode=(struct cll *)malloc(sizeof(struct cll));
		printf("enter data ");
		scanf("%d",& newnode->data);
		if (head==NULL)
		{
			head=newnode;
			newnode->link=head;
		}// cll with one node
		else // cll with more than one node
		{
			temp=head;
			while(temp->link!=head)
				temp=temp->link;
			temp->link=newnode;
			newnode->link=head;
	 	}
		 printf("do you want to create more nodes");
		 fflush(stdin);
		 scanf("%c",&ch);		
	}while(ch=='y');
}

void display (struct cll *t1)
{
	while(t1->link!=head)
	{
		printf("%d --->", t1->data);
		t1=t1->link;
	}
	printf("%d --->", t1->data);
	printf("HEAD\n");
}
void insbeg(struct cll *t1)
{
	struct cll*newnode;
	while(t1->link!=head)
	{
		t1=t1->link;
	}
		newnode=(struct cll *)malloc(sizeof(struct cll));
		printf("enter data ");
		scanf("%d",& newnode->data);
t1->link=newnode;
newnode->link=head;
head=newnode;
}

void insend(struct cll *t1)
{
	struct cll*newnode;
	while(t1->link!=head)
	{
		t1=t1->link;
	}
		newnode=(struct cll *)malloc(sizeof(struct cll));
		printf("enter data ");
		scanf("%d",& newnode->data);
newnode->link=t1->link;
t1->link=newnode;
}

void delbeg(struct cll *t1)
{
	struct cll* t2;
	t2=head;
	if (head ->link==head)
	{
	printf("deleted data %d ", t1->data);

			free(t2);
			head=NULL;
	}
	else
	{
	printf("deleted data %d ", t1->data);
	head=t1->link;
	while(t2->link!=t1)
	{
		t2=t2->link;
	}
	t2->link=head;
	free(t1);
	}
}
void delend(struct cll *t1)
{
	struct cll* t2;
	t2=head;
	if (head ->link==head)
	{
	printf("deleted data %d ", t1->data);
			free(t2);
			head=NULL;
	}	
else
{
	while(t2->link!=head)
	{
		t1=t2;
		t2=t2->link;
	}
	printf("deleted data %d ", t2->data);
	t1->link=head;
	free(t2);
	}
}
