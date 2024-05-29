#R1: Understanding of selected Dataset:

setwd("C:/Users/ASUS/Desktop/2nd-trimester/R/AppliedStatUsinR")
cereal=read.csv("UScereal1.csv",header=T)
cereal2=cereal
cal_mean=mean(cereal$calories,na.rm=T)
str(cereal)
summary(cereal)

cereal$mfr=factor(cereal$mfr)
cereal$shelf=factor(cereal$shelf,ordered = T)
cereal$vitamins=factor(cereal$vitamins)

names=c(unique(cereal$mfr))
for(name in names){
  print(name)
  print(mean(cereal$protein[cereal$mfr==name]))
}

max(cereal$protein[cereal$mfr=="G"])
max(cereal$protein[cereal$mfr=="K"])
max(cereal$protein[cereal$mfr=="N"])
max(cereal$protein[cereal$mfr=="P"])
max(cereal$protein[cereal$mfr=="Q"])
max(cereal$protein[cereal$mfr=="R"])



#R2 - Descriptive Analysis
#1.
is.na(cereal)
# install.packages("moments")
library(moments)
col_names = c("calories","protein","fat","sodium","fibre","carbo","sugars","shelf","potassium","vitamins")
for (col_name in col_names) {
  if (is.numeric(cereal[[col_name]])) {
    skew_value = skewness(cereal[[col_name]], na.rm = TRUE)
    if (skew_value < 0) {
      cereal[[col_name]][is.na(cereal[[col_name]])] = min(cereal[[col_name]], na.rm = TRUE)
    }else if (skew_value == 0) {
      cereal[[col_name]][is.na(cereal[[col_name]])] = mean(cereal[[col_name]], na.rm = TRUE)
    }else {
      cereal[[col_name]][is.na(cereal[[col_name]])] = max(cereal[[col_name]], na.rm = TRUE)
    }
  }
}
is.na(cereal)


#2.
summary(cereal)


#R3 - Exploratory Analysis
#1.
boxplot(fibre~mfr,data=cereal,
        main="Box plot for relation between Fiber and manufactuere",
        ylab="Fiber content",
        xlab="Manufacturer",
        col=c(1:8))

# 2.
library(ggplot2)
ggplot(cereal, aes(x = shelf, y = calories)) +
  geom_boxplot() +
  labs(
    title = "Boxplot of Calories for Each Shelf",
    x = "Shelf",
    y = "Calories"
  ) +
  theme_minimal()

#3.
library(corrplot)
str(cereal)
num_variables=c("calories","protein","fat","sodium","fibre","carbo","sugars","potassium")
num_var = cor(cereal[, num_variables])
print(num_var)
corrplot(num_var, method = "circle")


#R-4 - Model Building
#1. 
num_vars = sapply(cereal, is.numeric)
mean_values = numeric(length = sum(num_vars))

i = 1
for (col in names(cereal)[num_vars]) {
  mean_values[i] = mean(cereal[[col]], na.rm = TRUE)
  i = i + 1
}
mean_values
top_four_indices = order(mean_values, decreasing = TRUE)[1:4]
top_four_variable_names = names(cereal)[num_vars][top_four_indices]
GreaterMeanFour = cereal[, top_four_variable_names]
GreaterMeanFour

#2.
corr_matrix <- cor(GreaterMeanFour)
corrplot(corr_matrix,method="shade")


#3. 
lm_model <- lm(calories ~ carbo, data = GreaterMeanFour)
summary(lm_model)
plot(GreaterMeanFour$carbo, GreaterMeanFour$calories,
     main = "Simple Linear Regression",
     xlab = "Carbohydrates", ylab = "Calories",)
abline(lm_model, col = "red")


#4. 
lm_model <- lm(calories ~ carbo, data = cereal)
lm_model
outliers <- which(abs(residuals(lm_model)) > 2 * sd(residuals(lm_model)))
calories_original <- cereal$calories
calories_no_outliers <- cereal$calories[-outliers]
t.test(calories_original,mu=cal_mean,paired=F,conf.level=0.95)
t.test(calories_no_outliers,mu=cal_mean,paired=F,conf.level=0.95)
#R5 - Conclusion
#1. The Manufacturer N (Nabisco) has more preference to Fiber than any other manufacturer.(Boxplot-1)

#2. There might be defected products if the shelf life is very longer for a large content of calories.(Boxplot-2)

#3. There is a strong relationship between fiber and potassium, because if the content of fibre is increased, the content of potassium is also increased. (corrplot)

#4. The Content of Sodium is found to be very high in overall Cereals.(greaterMean)

#5. The manufacturer N (Nabisco) has more quantity of all the contents compared to other manufacturers.