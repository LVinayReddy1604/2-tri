#one Sample T-test
# Suppose a grocery Store sells "16 Ounces" boxes of captain crisp ceral.
# A random sample of 9 boxes was taken and weighted. The weight in ounces is 
# 15.5,16.2,16.1,15.8,15.6,16.0,15.8,15.9,16.2
data=c(15.5,16.2,16.1,15.8,15.6,16.0,15.8,15.9,16.2)
xbar=mean(data)
M=16
s=sd(data)
n=9
t=(xbar-M)/(s/sqrt(n))
t
pt(t,df=n-1)
# ?t.test()
# conf.level=1-level of significance
t.test(data,alternative = "less", mu=16,paired=FALSE,var.equal=FALSE,conf.level = 1-0.05)
t.test(data)

capt_test_results=t.test(data,mu=16,alternative="two.sided",conf.level = 0.95)
capt_test_results

capt_test_results=t.test(data,mu=16,alternative="greater",conf.level = 0.95)
capt_test_results

x=c(70,82,78,74,94,82)
n1=length(x)
y=c(64,72,60,76,72,80,84,68)
n2=length(y)
mx=mean(x)
my=mean(y)
s1=sd(x)
s2=sd(y)
sdelta=sqrt((s1^2/n1)+ (s2^2/n2))
sdelta
t=(mx-my)/sdelta
t

t.test(x,y,alternative = c("two.sided"),conf.level = 0.95)

