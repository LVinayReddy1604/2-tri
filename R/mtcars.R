carsdata=mtcars

summary(carsdata)

str(carsdata)

class(carsdata)

hist(carsdata$hp,prob=T)

lines(density(carsdata$hp),col=6,lwd=2)      

head(carsdata)
