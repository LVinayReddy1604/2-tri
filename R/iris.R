
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
