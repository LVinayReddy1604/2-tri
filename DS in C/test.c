#include "test.h"
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
#define MAX 50
struct patient patient[MAX];
struct patient a[MAX];
int disprio=0,end=0;
void readdetails(struct patient * p){
	int id,age,sever,prio;
	printf("Enter the patient-ID:");
	scanf("%d",&id);
	printf("Enter the Age of the Patient:");
	scanf("%d",&age);
	printf("Enter the severity Level of patient:");
	scanf("%d",&sever);
	printf("Enter the priority level of the patient:");
	scanf("%d",&prio);
	if(sever<1 || sever>5){
		printf("\n Invalid Severity Level");
	}else if(age<0 || age>150){
		printf("\n Invalid Age ");
	}else{
	p[end].ID=id;
	p[end].age=age;
	p[end].severity=sever;
	p[end].priority=prio;
	end++;
	}
}

void display(struct patient * patient){
	int i=0,count=0;
	for(i=0;i<end;i++){
		printf("\n \n Patient priority Level: %d",patient[i].priority);
		printf("\n Patient ID: %d",patient[i].ID);
		printf("\n Patient Age:%d",patient[i].age);
		printf("\n Patient Severity level: %d",patient[i].severity);
		count++;
	}
	printf("\n\n Total %d patients",count);
}
void prioritydisplay(struct patient * patient){
 	int i,j,prio=1;
 	for(i=0;i<end;i++){
 		for(j=0;j<end;j++){
 			if( patient[j].priority==prio){
 				printf("\n \n Patient priority Level: %d",patient[j].priority);
				printf("\n Patient ID: %d",patient[j].ID);
				printf("\n Patient Age:%d",patient[j].age);
				printf("\n Patient Severity level: %d",patient[j].severity);
			 }
		 }
		 prio++;
	 }
 }

void prioritycount(struct patient * patient){
	int p,i,count=0;
	printf("\n Enter the priority value:");
	scanf("%d",&p);
	for(i=0;i<end;i++){
		if(patient[i].priority==p){
			printf("\n ID:%d",patient[i].ID);
			printf("\n Age:%d",patient[i].age);
			printf("\n Severity:%d",patient[i].severity);
			count++;
		}
	}
	printf("\n Total number of Patients = %d",count);
}
int main(){
	int cont=1;
	int choice;
	do{
		system("cls");
		printf("\n 1.Add Patient Details");
		printf("\n 2. Display Details");
		printf("\n 3. Priority Display");
		printf("\n 4.Count of patient with priority");
		printf("\n 5.Exit");
		printf("\n\n Enter your choice:");
		scanf("%d",&choice);
		switch(choice){
			case 1:{
				readdetails(patient);
				break;
			}
			case 2:{
				display(patient);
				break;
			}
			case 3:{
				prioritydisplay(patient);
				break;
			}
			case 4:{
				prioritycount(patient);
				break;
			}
			case 5:{
				exit(0);
				break;
			}
			default:{
				printf("\n Invalid Input");
				break;
			}
		}
		printf("\n\n Do you want to continue (y/n)?");
		char ch;
		ch=getch();
		if(ch=='n' || ch=='N'){
			cont=0;
		}
	}while(cont);
	return 0;
}
