# install.packages("https://cran.r-project.org/src/contrib/Archive/prob/prob_0.9-1.tar.gz")
library(prob)

tosscoin(1)
tosscoin(3)
tosscoin(3, makespace = T) # returns the possibilities of each occurance

rolldie(1,makespace = T)
rolldie(3)
rolldie(2,makespace = T)

subset(rolldie(3,makespace=T),X1+X2+X3>16)

s=(subset(rolldie(2,makespace=T), X1-X2<1))
nrow(s)

cards(jokers=F,makespace = T)


s=cards()
subset(s,suit=="Heart")
s1=subset(s,rank %in% 7:9)
nrow(s1)


roulette()

s=tosscoin(4,makespace = T)
s
s[1:3, ]
s[c(1,16),5]

s=cards(jokers = T,makespace=T)
subset(s,rank=="K")
s1=subset(s,rank=="K")
nrow(s1)


subset(cards(jokers=T,makespace=T),suit=="Heart")
subset(s,rank %in% 7:9)

s=rolldie(3,makespace = T)
str(s)

# Union, Intersection, Difference
S=cards()
A=subset(S,suit=="Heart")
B=subset(S,rank %in% 7:9)
u=union(A,B)
u
nrow(u)

i=intersect(A,B)
i
nrow(i)

d=setdiff(A,B)
d
nrow(d)

