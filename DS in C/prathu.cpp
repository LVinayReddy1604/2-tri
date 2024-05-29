#include<stdio.h>
#include<conio.h>
int a[50][4],n=0;
void insert(int a[][4],int n){
	int i=0,j=0;
	printf("\nInsert New student details\n");
	if(n==0){
		for(i=0;i<1;i++){
			printf("Std-ID:");
			scanf("%d",&a[i][j]);
			printf("\nSub1 Marks:");
			scanf("%d",&a[i][j+1]);
			printf("\nSub2 Marks:");
			scanf("%d",&a[i][j+2]);
			printf("\nSub3 Marks:");
			scanf("%d",&a[i][j+3]);
		}
		n++;
	}else{
		for(i=n;i<n+1;i++){
				printf("Std-ID:");
				scanf("%d",&a[i][j]);
				printf("\nSub1 Marks:");
				scanf("%d",&a[i][j+1]);
				printf("\nSub2 Marks:");
				scanf("%d",&a[i][j+2]);
				printf("\nSub3 Marks:");
				scanf("%d",&a[i][j+3]);
		}
		n++;
	}
}
void view(int a[][4],int n){
	int i,j;
	printf("ID \t M1 \t M2 \t M3 \n");
	if(n>0){
		
		for(i=0;i<n;i++){
			for(j=0;j<4;j++){
				printf("%d \t",a[i][j]);
			}
			printf("\n");
		}
	}
	else{
		printf("No data available");
	}
}
void result(int a[][4],int n){
	int i,j;
	printf("\nResults");
	printf("ID \t Total \t Avg \t Perc");
	for(i=0;i<n;i++){
		printf("%d \t",a[i][0]);
		int sum=0;
		float avg,perc;
		for(j=1;j<4;j++){
			sum=sum+a[i][j];
		}
		avg=sum/3;
		perc=(sum/300)*100;
		printf("%d \t %.2f \t %.2f",sum,avg,perc);
	}
}
int main(){
	int choice;
	char c='y';
	while(c=='y'){
		printf("==========STUDENT MANAGEMENT SYSTEM=============");
		printf("\nEnter Choice");
		printf("\n1.Insert");
		printf("\n2.View");
		printf("\n3.Result \n\n");
		scanf("%d",&choice);
		switch(choice){
			case 1:{
				insert(a,n);
				break;
			}
			case 2:{
				
				view(a,n);
				break;
			}
			case 3:{
				result(a,n);
				break;
			}
		}
		printf("\nDo you want to continue?(y/n):");
		fflush(stdin);
		scanf("%c",&c);
	}
	return 0;
}
