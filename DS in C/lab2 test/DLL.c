#include<stdio.h>
#include<stdlib.h>
struct linkedlist
{
	struct linkedlist * prev;
	int data ;
	struct linkedlist * next;
};
struct linkedlist * head, *last;
void create ();
void fdisplay();
void bdisplay();
void insbegin();
void insbet();
void insend();

main()
{
	int ch;
	char c;
	do 
	{
	
	printf("program to demonstarate Doubly Linkedlist creation , fdisplay, Bdisplay\n 1. CREATION \n 2. FDisplay \n 3. BDISPLAY\n \n 4. Insert begin \n 5. Insend \n 6. Insbetween \n enter your choice\n");
	scanf("%d",&ch);
	switch(ch)
	{
		case 1: 
		if (head==NULL)
		{
			create ();
	    }
		else
		printf("List is already created\n");
		break;
		case 2:
		if (head==NULL)
		printf("list is empty\n");
		else
		fdisplay (head);	
		break;
	case 3:
		if (last==NULL)
		printf("list is empty\n");
		else
		bdisplay (last);
		break;
	case 4:
		if (head==NULL)
		printf("list is empty\n");
		else
		insbegin ();	
		break;
	case 5:
		if (head==NULL)
		printf("list is empty\n");
		else
		insend ();	
		break;
	case 6:
		if (head==NULL)
		printf("list is empty\n");
		else
		insbet();	
		break;
		
	}
	printf(" do you want to continue\n");
	c=getch();
}while(c=='y');
}
void create()
{
	char c;
	struct linkedlist * newnode;
	newnode =(struct linkedlist *)malloc (sizeof(struct linkedlist));
	printf("enter data \n");
	scanf("%d", &newnode->data);
	if (head==NULL)
	{
		newnode->prev=NULL;
		newnode->next=NULL;
		head=newnode;
		last=newnode;
	}
	else
	{
		last->next=newnode;
		newnode->prev=last;
		newnode->next=NULL;
		last=newnode;
	}
	
	printf("do you want to add more nodes\n");
	c=getch();
	if (c=='y')
	{
		create();
	}

}


void fdisplay(struct linkedlist*ptr)
{
	while (ptr!=NULL)
	{
		printf("%d ---->", ptr->data);
		ptr=ptr->next;
	}
	printf("NULL\n");
}

void bdisplay(struct linkedlist*ptr)
{
	while (ptr!=NULL)
	{
		printf("%d ---->", ptr->data);
		ptr=ptr->prev;
	}
	printf("NULL\n");
}

void insbegin()
{
	struct linkedlist * newnode;
	newnode =(struct linkedlist *)malloc (sizeof(struct linkedlist));
	printf("enter data \n");
	scanf("%d", &newnode->data);
	newnode->prev=NULL;
	newnode->next=head;
	head->prev=newnode;
	head=newnode;
}

void insend()
{
	struct linkedlist * newnode;
	newnode =(struct linkedlist *)malloc (sizeof(struct linkedlist));
	printf("enter data \n");
	scanf("%d", &newnode->data);
	newnode->prev=last;
	last->next=newnode;
	newnode->next=NULL;
	last=newnode;
}


void insbet()
{
	struct linkedlist * newnode, *p;
		int pos,i=0;
		p=head;
	newnode =(struct linkedlist *)malloc (sizeof(struct linkedlist));
	printf("enter data \n");
	scanf("%d", &newnode->data);
	printf("enter position \n");
	scanf("%d", &pos);
	
	while(i<(pos-1))
	{	i++;
		p=p->next;
	}
	
newnode->next=p->next;
p->next->prev=newnode;
p->next=newnode;
newnode->prev=p;
}
