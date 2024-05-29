mtcars
cdata=mtcars
library(ggplot2)

g1=ggplot(cdata,aes(mpg,disp))#aes=aesthtics(x axis , yaxis)
g1

g2=g1+geom_point()#geometric points
g2

g1+geom_point(aes(color=factor(cyl)))

ggplot(cdata,aes(x=mpg,y=hp,col=factor(cyl),size=factor(gear)))+
  geom_point()+labs(size="gear",col="cyl")


ggplot(cdata,mapping=aes(x=mpg,fill=factor(cyl)))+
  geom_density(alpha=1)

