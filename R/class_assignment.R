# ?ToothGrowth
# View(ToothGrowth)
data=ToothGrowth
str(data)
summary(data)

#1
library(ggplot2)
ggplot(data, aes(x = len, fill = factor(dose))) +
  geom_density(alpha = 1) +
  labs(title = "Density of Tooth Growth at Different Dose Levels",
       x = "Tooth Length", y = "Density")

#2
ggplot(data, aes(x = supp, y = len, fill = factor(dose))) +
  geom_violin(trim = FALSE, scale = "width", width = 1) +
  facet_wrap(~ supp, scales = "free")+
  labs(title = "Tooth Growth by Supplement and Dose",
       x = "Supplement", y = "Tooth Length", fill = "Dose")

#3
supp.labs <- c("Orange Juice", "Vitamin C")
names(supp.labs) <- c("OJ", "VC")
ggplot(data, aes(x = supp, y = len, fill = factor(dose)))+
  geom_boxplot()+
  facet_wrap(~ supp, scales = "free",labeller = labeller(supp = supp.labs))+ 
  theme(
    strip.text.x = element_text(
    size = 12, color = "blue", face = "bold.italic"))+
  labs(title = "Tooth Length vs Dose Levels: \n Comparison by supplement type",
       x = "Dose in Millileter", y = "Tooth length")

#4
ggplot(data, aes(x = len,  fill = factor(dose)))+
  geom_dotplot()


#5
# install.packages("corrplot")
library(corrplot)
help(corrplot)
cor_matrix <- cor(data[, c("len", "dose")])
corrplot(cor_matrix, method = "color", type = "upper", tl.col = "black", tl.srt = 45)

