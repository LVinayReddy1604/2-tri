5+5
5-5
5*5
5/5
5%%2
5%/%2
5<2
5>2
5==2
5<=2
5>=3
5!=2
myvar<-3
myvar

assign("x",c(10.4,5.6,3.1,6.4,21.7))
c(10.4,5.6,3.1,6.4,21.7)->x
x=c(10.4,5.6,3.1,6.4,21.7)
X=c(10.4,5.6,3.1,6.4,21.7)
y=c(x,0,X)
sum((x-mean(x)^2))/(length(x)-1)



z=c(10.2,"B","c",1)
u=c("a","b","c","d")
b=c(T,F,T,T)
b2=c(0,1,0,0)
b3=c(TRUE,FALSE,TRUE,TRUE)


x[1]
x[]
x[length(x)]
x[c(2,3)]
x[-c(2,3)]
x[1]<-5
x[c(2,3)]<-c(10,2)

i=c(3+2i,3i,4i)
r=c(22/7,22/3,10/0)

length
rev
sort
order
head
max
min
which.max
which.min
mean
median
var
sd
cumsum
diff
unique
round

len=length(b2)
rev(z)
sort(x) #sort the elements
order(b2) #returns the index of elements after sorting
head(b2,2)
tail(b2,2)
max(x)
min(x)
which.max(x)#returns the position of the max value in the vector
which.min(x)#returns the position of the min value in the vector
mean(x)
median(x)
var(x)
cumsum(x)
sd(x)
diff(x)# returns the difference between two consecutive element in the vector
unique(x)
round(x)



milage=c(65311,65624,65908,66219,66499,66821,67821,67145,67447)
diff(milage)

bill=c(460,330,390,370,460,300,480,320,490,350,300,480)
sum(bill)
min(bill)
max(bill)
months=0
for (i in bill) {
  if (i>400) {
    months=months+1
  }
}
months

perc=(months/length(bill))*100
perc


#Datatypes:
#numeric - c(1,12,10/2,12.23)
#character - c("E.saligma", " a b c ") 
#factor - factor(c("Control","fertilizerss"))
#logical - 10==100/10 - Either TRUE or FALSE
#date - as.Date("2010-6-21") - Specail Date Class
#OSIXct - Special Date-time class - Sys.
factor(c("Control","fertilizerss"))


#arithematic operators - +,-,*,/ ,%% ,%/%
# logical - !,&,&&,|,||


#data sequence
#seq(3,5)
#seq(from=3,to=5)
#seq(from=3,length=5)
#seq(from=3,length=3,by=0.5)
#seq(from=3,by=0.5,length=3)


#PASTE FUNCTION - CHARACTERS
#paste("xyz",1:10)
#paste("XYZ",c(2,5,7,"test",4,5))
#paste("xyz",1:10,sep="")
#paste("xyz",1:10,sep="/")

seq(3,5) 
help(seq)
seq(5,3)
var=seq(3,5,0.5)
print(var)
seq(3,length=5)
seq(3,length=5,by=0.5)


paste("xyz",1:10)
paste("xyz",c(2,5,7,"test",4.5))
paste("xyz",1:10,sep="")
paste("xyz",1:10,sep="/")


#repeat sequences
rep(c(3,4,5),3)
rep(1:10,times=3)
x=c(1,2,3)
rep(x,each=3)
rep(x,each=3,times=3)

#position and values
x=c(4:20)
which(x==10) #position of 10 in x
x[3] #value in the third position of x


#Q&A
#1
myobj=paste("",1:10,sep="")
print(myobj)
myobj=1:10
print(myobj)
myobj=seq(1,10)
print(myobj)

#2
sum(myobj)

#3
paste("R is great",c(4,7,45),"and I will love it")

#4
x=c(1,2,3)
X=rep(x,times=11,length.out=31)
print(X)
X[7]

help(rep)

5/3
5%/%3

#data-structures in R
#vector 1D - All elements are same datatype 
#matrix MD  - All elements are same datatype 
#array MD  - All elements are same datatype
#dataframes MD  - one object contains multiple data-types - structed and all number of rows are same for the column
#list 1D - Elements can be different datatypes - different number of rows for columns

#LIST
Studentlist=list("MCA","BCA",c(44,55,67,11),c(T,F,F,T),51.23,119.1)
Studentlist[[3]][2]
Studentlist

Student_data=
  list(c("Ass=part1","MCQ","Theory Test","Practical Test","Ass-part2"),
       matrix(c(55,67,96,90,83,56),nrow=2),
       list(c("Stud1","Stud2","Stud3"),c(2347101,2347102,2347103)))
names(Student_data)=c("Assessments","Marks_Matrix","student Details")

Student_data$Assessments
#$assessment - this is used to access an attribute in R using $
Student_data$`student Details`
Student_data$`student Details`[[1]][1]
Student_data$`Marks_Matrix`[1,c(2,3)] #[row,colum]
Student_data$`student Details`[[2]][1]

Student_data[5]="Result"
Student_data

Student_data[3]="Student Details"
Student_data

#convert list to vector
stu_vector=unlist(Student_data)
stu_vector

studentvector=unlist(Student_data)
studentvector

#merging List
StudentName=list("stud1","stud1","stud1")
StudentName
StudentNumber=list(2347101,2347102,2347103)
StudentNumber
StuDetails=c(StudentName,StudentNumber)
StuDetails[5]


##################Matix in R#########################
set.seed(1000) # used to keep the random number constant
x=c(1,5,4)
sample(x,2)
#sample is used to generate random numbers in R
sample(x,10,replace=T)
sample(x,10,replace=F)
sample(x,2,replace=F)

sample(x,10,replace=T,prob=c(.3,.5,.2))


sample(1:50,size=10,replace=F)


#actual Matrix
x=c(sample(1:100,16,replace=F))
A=matrix(x,nrow=4,ncol=4,byrow=T)

B=matrix(x,nrow=2,ncol=8,byrow=T)

C=matrix(x,nrow=8,ncol=2,byrow=T)
A
B
C

x1=c(sample(1:4,4,replace=F))
x3=c(sample(10:13,4,replace=F))
x2=c(sample(5:9,4,replace=F))
mat1=cbind(x1,x2,x3)
mat2=rbind(x1,x2,x3)
mat1
mat2


x2=c(sample(1:100,8,replace=F))
D=matrix(x2,nrow=4,ncol=2)
rbind(C,D)

class(mat2)#type of the structure
typeof(mat2)#datatype of elements

vect1=c(1,2,3,4,5,6,7,8)
dim(vect1)

dim(vect1)=c(4,2)
vect1


vect2=c(12,23,34,45,56,67,78,90,68)
rnames<-c("row1","row2","row3")
cnames<-c("col1","col2","col3")
named_matrix<-matrix(vect2,nrow=3,byrow=T,dimnames = list(rnames,cnames))
named_matrix

rownames(named_matrix)=c("year1","year2","year3")
colnames(named_matrix)=c("Month1","Month2","Month3")
named_matrix

named_matrix[3,2]

#Adding 2 matrix
set.seed(1000)
mat1=matrix(c(sample(1:50,9,replace=F)),nrow=3)
mat2=matrix(c(sample(51:100,9,replace=F)),nrow=3)
sum=(mat1+mat2)
mat1
mat2
sum
#element addition
sum(mat1)
#row addition
rowSums(mat1)
#col addition
colSums(mat1)
#subtraction
sum=(mat2-mat1)
sum
#Matrix Multiplication
mul=B%*%C
mul
mul=C%*%B
mul

mat1[c(T,F,T),c(F,T,T)]
mat1[c(3,1),c(F,T,T)]

mat1[c(1,2),-3]#except 3rd column, negative number defines except 

mat1[c("r1","r3"),c(1,2)]#access through named rows or columns

mat1[c(3,4,5,6,7,8,9)] #column wise accessing by default

#DETERMENENT
mat3=matrix(c(1,-2,3,2,0,3,1,5,4),nrow=3,byrow=T)
mat3
det(mat3)

#INVERSE of matrix
solve(mat3)

#?qr
qr(mat3)
?qr

qr(mat3)$rank
#DIAGONAL ELEMENTS
diag(mat3)
#Diagonal in reverse
diag(apply(mat3))
mat3
#Create diagonal Matrix     
diag(3)
diag(mat2)=c(10,20,30)
diag(mat2)=c(100,200,300)

#EIGEN Values and matrix
eigen(mat2)
mat2
eigen(mat2)$values

eigen(mat2)$vectors

mat3=matrix(c(4,78,34,78,2,3),nrow=2,byrow=T)
mat3



############DATA-FRAMES##############
#Data-Frame
name=c("A","B","C","D")
age=c(12,45,67,43)
height=c(5.6,5.3,3.6,4.6)
weight=c(67,65,80,45)
gender=(factor(c("Male","Female","Male","Male")))
#create a data Frame
data=data.frame(name,age,height,weight,gender)
data
dim(data)

class(data)#datatype

#Return Columns in dataframe format
data[1] #pass only one value in square brackets
data[c(2,3)]

#row and column access, return type is vector
data[1,2]
data[c(1,3),4]

#Three ways to access Age column
data$age
data["age"]
data[2]
summary(data)

str(data) #Structure of data #0bservations->rows variables->columns
data$weight

is.ordered(data$gender) #check if the data is ordinal type
v=c(1,2,3,4,5,1,3)

#create nominal type
v1=factor(v)
v1

#create ordinal type
v2=factor(v,order=T)
v2

v3=as.ordered(v)#same to create ordinal type
v3

is.ordered(v2)
is.ordered(v1)
is.ordered(v3)
is.ordered(v)

is.factor(v)#check if it is a factor


stuPlacement_A=data.frame(
  stu_id=c(2347101:2347108),
  stu_name=c("Abhishek","Adarsh","Anshika","Anupam","Anush","Argha","Aryan","Athul"),
  Gender=factor(c("Male","Male","Female","Male","Male","Male","Male","Male")),
  salary_k=c(25,23,67,55,78,98,76,65),
  joining_date=c("15th Nov","26th Sep","4th Oct","29th Feb","1st Jan","4th Oct","29th Feb","1st Jan"),
  stringsAsFactors = FALSE #do not consider all character sets as factors
)

stuPlacement_B=data.frame(
  stu_id=c(2347201:2347208),
  stu_name=c("Thanga","Justin","Alankritha","Vinay","Punith","Pratham","Johanan","Kushal"),
  Gender=factor(c("Male","Male","Female","Male","Male","Male","Male","Male")),
  salary_k=c(95,73,97,85,68,28,96,85),
  joining_date=c("15th Nov","26th Sep","4th Oct","4th Oct","29th Feb","1st Jan","4th Oct","29th Feb"),
  stringsAsFactors = FALSE 
)

stuPlacement_A$JobLocation=c("Kolkata","Bengaluru","Hyderabad","Mumbai","Goa","Chennai","Jaipur","Delhi")
stuPlacement_B$JobLocation=c("Kolkata","Bengaluru","Hyderabad","Mumbai","Goa","Chennai","Jaipur","Delhi")

age=c(21,23,24,22,21,23,23,21)
stuPlacement_A=cbind(stuPlacement_A,age)
stuPlacement_B=cbind(stuPlacement_B,age)

stuPlacement_A
stuPlacement_B

stuPlacement_MCA=rbind(stuPlacement_A,stuPlacement_B)
stuPlacement_MCA

subset(stuPlacement_MCA,salary_k>=70)
nrow(subset(stuPlacement_MCA,salary_k>=70))

stuPlacement_MCA[,-5] #except 5th column

#rownames
rownames(stuPlacement_MCA)=c("row1","row2","row3","row4","row5","row6","row7","row8","row9","row10","row11","row12","row13","row14","row15","row16")
#column names
colnames(stuPlacement_MCA)=c("Student_ID","Student_Name","Gender","Salary_In_K","Joining_Date","Job_Location","Age")
stuPlacement_MCA


#include comment in dataframe
comment(stuPlacement_MCA)="MCA-Student's Placement Details"
attributes(stuPlacement_MCA)

summary(stuPlacement_MCA)

stuPlacement_MCA[2:3,]
stuPlacement_MCA[c("row1","row3"),]
stuPlacement_MCA[1:4,c(1,3)]
v=c(1,3,4)
stuPlacement_MCA[v,]


mtcars
cdata=mtcars

cdata
summary(cdata)
class(cdata)
str(cdata)
as.ordered(cdata)


# v2=factor(v,order=T)
vs=c(0,1)
cdata$vs=factor(vs)
cdata
str(cdata)

am=c(0,1)
cdata$am=factor(am)
cdata
str(cdata)

gear=c(cdata$gear)
cdata$gear=factor(gear,order=T)
str(cdata)

carb=c(cdata$carb)
cdata$carb=factor(carb,order=T)

cyl=c(cdata$cyl)
cdata$cyl=factor(cyl,order=T)

# display the details of the lightest vehicle
cdata[cdata$wt==min(cdata$wt),] 

#find number of automatic vehicles
nrow((cdata[cdata$am==0,]))

#find th name of the car which is heavest
attr(cdata[cdata$wt==max(cdata$wt),],"row.name")

#find how many 4 cylinder automatic vehicles 
nrow(cdata[cdata$cyl==4 & cdata$am==0,])

str(cdata)
#avg weight of 8 cyl vehicle
#find the heavier vehicle automatic or manual




#IMPORTING DATASET
mydata=read.table(url("http://assets.datacamp.com/blog_assets/chol.txt"),header=TRUE)
mydata

mydata1=read.table(url("http://assets.datacamp.com/blog_assets/chol.txt"))
mydata1

head(mydata)
tail(mydata)
head(mydata,10)
tail(mydata,10)


mydata2=read.table("C:/Users/91939/Desktop/1st-MCA/R/churn.csv",header=TRUE,sep=",")


setwd("C:/Users/91939/Desktop/1st-MCA/R")
getwd()
mydata4=read.csv("churn.csv")

mydata3=read.table("C:/Users/91939/Desktop/1st-MCA/R/iris.txt",header=TRUE,sep=",")
iris=mydata3
str(iris)


#how many variables and observations does the dataset have?
dim(iris)

#Create a dtaframe by extracting first three variables of dataset
iris[,c(1,2,3)]

#Display all the columns of the iris dataset except Petal Width
iris[,-4]

#Display all columns of iris dataset that starts with character string P(String not thought)

#Display the rows of iris dataset for SepalLength>=4.6 and PetalWidth>=0.5. How many such observations did you find?
irissub=iris[iris$Sepal.Length >= 4.6 & iris$Petal.Width >= 0.5, ]
iris_sub
nrow(iris_sub)

#Create a DataFrame iris1 that contains only the sepal details of Setosa Species
iris1=iris[iris$Species=="Iris-setosa",]
iris1=iris1[,c(1,2,5)]
iris1
# Create a data frame iris2 that orders the observations from largest to smallest sepal length. Show the first 6 rows of this dataset.
iris2=iris[order(iris$Sepal.Length), ]
iris2
head(iris2, 6)

#Add a new column 'sepal area' by calculating sepal area =(length * width) for each observation.

#Calculate the average sepal length, the average sepal width for (i) entire data frame (ii) for each species (iii) random sample (iv) 30% of random sample

#For each species, calculate the percentage of cases with sepal length > 5.5.



####################################################################################################################
# MODE
x=c(6,23,24,25,NA,26,28,90)
y=c(23,24,25,26,28)

mean(x,na.rm = TRUE) # rm means remove
mean(x,na.rm = TRUE,trim=0.2) # 0.2 -> it remove 1 from right and 1 from left

median(x,na.rm = T)
getmode <- function(v){
  uniqv<- unique(v)
  uniqv[which.max(tabulate(match(v,uniqv)))]
  
}
getmode(x)

carsData=mtcars #carsData ->dataset
getmode(carsData$disp)

carsData
mean(carsData$cyl)
mode

plot(lynx,main="graph title",col.main=45,cex.main=3.5,las=0, xlab="xlabel", ylab="ylabel", pch=12, col="red")
# lynx datasets it is packages

x=2:6
plot(x,pch="d")
plot(x,pch=18)





# statistical analysis
cardata=mtcars
cardata
hist(cardata$hp,prob=T)#returns only histogram
lines(density(cardata$hp),col=6,lwd=2)#plots dentisty on histogram
plot(density(cardata$hp),lwd=2,col="red",main="Density")#plots only line using density
rug(jitter(cardata$hp))#returns the density below the line
mean(cardata$hp)
median(cardata$hp)
mode(cardata$hp)

plot(density(cardata$mpg),lwd=2,col="red")
plot(density(cardata$cyl),lwd=2,col="blue")
plot(density(cardata$disp),lwd=2,col="blue")
plot(density(cardata$drat),lwd=2,col="blue")
summary(cardata)
plot(density(cardata$gear),lwd=2,col="blue")
plot(density(cardata$wt),lwd=2,col="blue")
plot(density(cardata$qsec),lwd=2,col="blue")

me=mean(cardata$wt)
md=median(cardata$wt)
sd=sd(cardata$wt)
skew=3*me/sd-3*md/sd
skew

# install.packages("moments")
library("moments")#used to include the package or else it will not be active
plot(density(cardata$hp),lwd=2,col="red",main="Density")

x=cardata$hp
y=cardata$disp
dx=density(x)
dy=density(y)
plot(dx,lwd=2,col="red",main="Density plot of mtcars hp&disp",xlab="",
     xlim=c(min(dx$x,dy$x),c(max(dx$x,dy$x))),#min and max X-axis value
     tlim=c(min(dx$y,dy$y),c(max(dx$y,dy$y))))

lines(dy,col="blue",lwd=2)
legend("topright",
       legend=c("hp","disp"),
       col=c("red","blue"),
       pch=c(19,19),
       bty="0",
       pt.cex=0.8,
       cex=0.8,
       text.col="black",
       horiz=T,
       inset=c(0.1,0.1))


skewness(x)
skewness(y)
skewness(cardata$qsec)
skewness(cardata$mpg)
skewness(cardata$cyl)


boxdata=c(33,38,43,30,29,40,51,27,42,23,31)
boxplot(boxdata)
boxplot(cardata$mpg)
boxplot(cardata$mpg,main="milage data Boxplot",
        horizontal=T,
        col="orange",
        ylab="Miles per Gallon")
boxplot(cardata$hp~cardata$cyl,data=cardata,
        main="Horse Power Data Boxplot",
        ylab="Horsepower(hp)",
        xlab="No.of Cylinders",
        col=c("orange","red","blue"))

range(cardata$hp)



# install.packages("vioplot")
library("vioplot")

vioplot(cardata$hp)
vioplot(cardata$hp,col=2,rectCol = "red",lineCol = "White", colMed="green",border="black",pchMed=16,plotCentre = "points")
stripchart(cardata$hp,method="jitter",col="blue",vertical=T,pch=19,add=T)

vioplot(cardata$hp ~ cardata$cyl,col=5:length(levels(cardata$cyl)),xlab="cyl",ylab="hp")
stripchart(cardata$hp~cardata$cyl,vertical=T,method="jitter",pch=19,add=T,col=10:8)

pairs(cardata)

cardata$cyl=as.ordered(cardata$cyl)
cardata$am=factor(cardata$am)
cardata$vs=factor(cardata$vs)
cardata$gear=as.ordered(cardata$gear)
cardata$carb=as.ordered(cardata$carb)
pairs(cardata)


cardata=mtcars
data=cardata$gear
barplot(data)
barplot(table(data))
boxplot(table(data),prob=T)


data.counts=table(data)
pie(data.counts)
names(data.counts)=c("Three Gears","Four Gears","Five Gears")
pie(data.counts,col=c("purple","green","cyan","white"))

table(data)

cats=cut(cardata$mpg,breaks=c(10,15,20,max(cardata$mpg)))
cats
table(cats)
levels((cats))
pie(table(cats),col=c("purple","green","cyan"),main="abcd")


compare=table(cardata$am,cardata$cyl)
old.digits=options("digits")
options(digits=3)
compare
prop.table(compare)

barplot(table(cardata$am,cardata$cyl))
barplot(table(cardata$cyl,cardata$am))

# bivarient-categorical data-Bar plot
# bivarient-categorical data bar plot
str(cardata)



mean(cardata$qsec)
median(cardata$qsec)
getmode(cardata$qsec)
      
library("moments")
skewness(cardata$qsec)
kurtosis(cardata$qsec)

x=cardata$wt
mean(x)
median(x)
getmode(x)
skewness(x)
kurtosis(x)
plot(density(x),lwd=2,col="red",main="Density")
rug(jitter(x))
summary(x)
str(x)
#There are more vehicles whose wt is in between 3 to 24

x=cardata$mpg
mean(x)
median(x)
getmode(x)
skewness(x)
kurtosis(x)
plot(density(x),lwd=2,col="red",main="Density")
rug(jitter(x))
summary(x)
str(x)
#Most vehicles MPG is inbetween 10 to 20

mtcars
mtcars[9]
mtcars[[9]]
mtcars[,9]





