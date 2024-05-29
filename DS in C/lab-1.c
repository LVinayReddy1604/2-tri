#include<stdio.h>
#include<conio.h>
int main() {
	int i,j;
    int q1[3][4]={{1,24000,25000,23000},{2,24000,23000,23000},{3,24000,25000,25000}};
    int q2[3][4]={{1,23000,23000,23000},{2,24000,24000,25000},{3,25000,25000,21000}};
    int sum[3][4],diff[3][4],q1s[3][2],q2s[3][2],d[3][2];
    int rsum=0;
    printf("1-st Quarter of the year \n");
    printf("emdID  month-1  month-2  month-3 \n");
    for(i=0;i<3;i++){
    	for(j=0;j<4;j++){
    		printf("%d \t",q1[i][j]);
		}
		printf("\n");
	}
    printf("\n \n 2nd Quarter of the year \n");
    printf("emdID  month-4  month-5  month-6 \n");
    for(i=0;i<3;i++){
    	for(j=0;j<4;j++){
    		printf("%d \t",q2[i][j]);
		}
		printf("\n");
	}
	for(i=0;i<3;i++){
		for(j=0;j<1;j++){
			sum[i][j]=q1[i][j];
			diff[i][j]=q1[i][j];
			q1s[i][j]=q1[i][j];
			q2s[i][j]=q1[i][j];
			d[i][j]=q1[i][j];
		}
	}
//	for(i=0;i<3;i++){
//		for(j=1;j<4;j++){
//			sum[i][j]=q1[i][j]+q2[i][j];
//		}
//	}
//	printf("\n \n Adding both the quarters\n ");
//	printf("emdID  month-1&4  month-2&5  month-3&6 \n");
//    for(i=0;i<3;i++){
//    	for(j=0;j<4;j++){
//    		printf("%d \t",sum[i][j]);
//		}
//		printf("\n");
//	}
//	for(i=0;i<3;i++){
//		for(j=1;j<4;j++){
//			diff[i][j]=q2[i][j]-q1[i][j];
//		}
//	}
//	printf("\n \n Difference of both the quarters\n ");
//	printf("emdID  month-1&4  month-2&5  month-3&6 \n");
//    for(i=0;i<3;i++){
//    	for(j=0;j<4;j++){
//    		printf("%d \t",diff[i][j]);
//		}
//		printf("\n");
//	}
	for(i=0;i<3;i++){
		q1s[i][1]=0;
		q2s[i][1]=0;
		for(j=1;j<4;j++){
			q1s[i][1]+=q1[i][j];
			q2s[i][1]+=q2[i][j];
		}
	}
	printf("\n \n Total Earning in Quarter-1");
	printf("\n EmdID   Salary\n");
	for(i=0;i<3;i++){
		for(j=0;j<2;j++){
			printf("%d \t",q1s[i][j]);
		}
		printf("\n");
	}
	printf("\n \n TOtal Earning in Quarter-2");
	printf("\n EmdID    Salary\n");
	for(i=0;i<3;i++){
		for(j=0;j<2;j++){
			printf("%d \t",q2s[i][j]);
		}
		printf("\n");
	}
	
	for(i=0;i<3;i++){
		d[i][1]=q2s[i][1]-q1s[i][1];
	}
	printf("\n \n Difference in Quarter-1 and Quarter-2");
	printf("\n EmdID    Salary\n");
	for(i=0;i<3;i++){
		for(j=0;j<2;j++){
			printf("%d \t",d[i][j]);
		}
		printf("\n");
	}
	
    return 0;
}
