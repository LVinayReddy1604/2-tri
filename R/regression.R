ad=c(25,50,70,80,100,130,170)
sold=c(100,220,200,340,370,410,450)
plot(ad,sold)

cor(ad,sold)

# install.packages("corrplot")

library("corrplot")

x=data.frame(mtcars)
cor(x$wt,x$hp)

M=cor(mtcars)
corrplot(M,method="number")


x=c(8,11,7,10,12,5,4,6)
y=c(11,30,25,44,38,25,20,27)
ans="10.98 + 2.098x"

lrmodel=lm(y~x)
plot(y~x,
     xlab="Experiment(X)",
     ylab="Rating(Y)",
     main="Regression Analysis",
     sub=ans,
     pch=20,
     cex=2,
     col="red")
abline(lrmodel,lwd=3,lty=1,col="Black")

names(lrmodel)

coef(lrmodel)

summary(lrmodel)

predict(lrmodel,newdata=data.frame(x=15))
predict(lrmodel,newdata=data.frame(x=c(12,13,14,15)))
