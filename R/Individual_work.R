setwd("C:/Users/ASUS/Desktop/2nd-trimester/R")
std_data=read.csv("13-Influence of AI TOOLS on Student's Learning Process.csv",header=T)

#Dropping unwanted columns and cleaning the dataset
drop=c("Timestamp","Username","Any.Comments..Review")
std_data= std_data[,!(names(std_data) %in% drop)]

#change column_names
colnames(std_data)=c("ar","g","e","freq","access","sat_per","impt","recall","mot_ler","sat_info","sat","anx","prcy","saw","p_att","flex","under","i_feed","m_obj","p_alter","add_s","l_exp")
str(std_data)
summary(std_data)

ar=factor(std_data$ar)
g=factor(std_data$g)
e=factor(std_data$e)

#Graph-1
library(ggplot2)
library(dplyr)
std_data$prcy <- factor(std_data$prcy, ordered = TRUE,
                        levels = c("Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree"))
ggplot(std_data, aes(x = prcy, fill = prcy)) +
  geom_bar(position = "stack") +
  facet_wrap(~ e, scales = "free_x") +
  labs(title = "Histogram of No Privacy Concerns by Education Level",
       x = "Privacy Concerns",
       y = "Frequency") +
  theme_minimal()

#UNDERSTANDING THE GRAPH - 1
# The maximum number of responses are from respondents who are Undergraduates or Postgraduates.
# Most of the respondants who frequently use AI Tools have less privacy concerns(Agree), whereas few have no Privacy concerns(Strongly Agree)





#Graph-2
std_data$freq <- factor(std_data$freq, ordered = TRUE, levels = c("Strongly agree", "Agree", "Neutral", "Disagree", "Strongly Disagree"))
std_data$sat <- factor(std_data$sat, ordered = TRUE, levels = c("Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree"))
count_data <- as.data.frame(table(std_data$freq, std_data$sat))
colnames(count_data) <- c("Frequency", "Overall_Satisfaction", "Count")
ggplot(count_data, aes(x = Frequency, y = Count, fill = Overall_Satisfaction)) +
  geom_bar(stat = "identity", position = "stack") +
  labs(title = "Stacked Bar Plot of Frequency and Overall Satisfaction",
       x = "Frequency of AI Tool Usage",
       y = "Count",
       fill = "Overall Satisfaction") +
  theme_minimal()
#UNDERSTANDING THE GRAPH - 2
#Most users who use Ai Tools Frequently are overall satisfied with the services provided
#Anyhow very few who use the AI tools are not satisfied  



#Graph-3
std_data$impt <- factor(std_data$impt, ordered = TRUE, levels =c("Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree"))
std_data$m_obj <- factor(std_data$m_obj, ordered = TRUE, levels =  c("Strongly Agree", "Agree", "Netural", "Disagree", "Strongly Disagree"))
ggplot(std_data, aes(x = impt, y = m_obj, color = impt)) +
  geom_jitter(position = position_jitter(width = 0.2, height = 0.2), size = 1) +
  labs(title = "Jitter Dot Plot of Impact on Learning vs Meets Objectives",
       x = "Impact on Learning",
       y = "Meets Objectives",
       color = "Impact on Learning") +
  theme_minimal()
#UNDERSTANDING THE GRAPH - 3
#Meeting the objectives of the query plays a important role in impacting the user learning experience
#Better the Response of the AI Tools leads to Better Learning experience of the User






#Graph-4
barplot(t(table(std_data$g, std_data$impt)), beside = TRUE,
        col = c("lightblue", "lightgreen", "lightyellow", "lightcoral", "lightpink"),
        main = "Comparison of Gender and Impact on Learning",
        xlab = "Impact on Learning",
        ylab = "Frequency",
        names.arg = levels(std_data$g),
        legend.text = levels(std_data$impt),
        args.legend = list(x = "topright", bty = "n", title = "Impact on Learning")) +
  theme(legend.position = "bottom")  # Adjust legend position
#UNDERSTANDING THE GRAPH - 4
#The respondents have a positive impact on their learning by using AI tool
#Very few respondents disagree that the AI tools impact their learning 





#Graph-5
std_data$ar <- factor(std_data$ar)
std_data$m_obj <- factor(std_data$m_obj, ordered = TRUE, levels = c("Strongly Agree", "Agree", "Netural", "Disagree", "Strongly Disagree"))
ggplot(std_data, aes(x = ar, y = m_obj, fill = m_obj)) +
  geom_violin(trim = FALSE) +
  labs(title = "Violin Plot of Age and Meets Objectives",
       x = "Age Range",
       y = "Meets Objectives",
       fill = "Meets Objectives") +
  theme_minimal()
#UNDERSTANDING THE GRAPH - 5
#Teenagers(Under-18) and above-24 aged people who use AI tools gets their responses which meets the objectives of their query
#For the people who are aged between 18-24 AI have met most of the objectives but still few people are not satisfied with the response



#converting the columns into relevant datatype
std_data$g<-factor(std_data$g)
std_data$ar<-factor(std_data$ar)
std_data$e<-factor(std_data$e)

library(dplyr)

map_scale_values <- function(value) {
  case_when(
    as.character(value) %in% c("Strongly Agree", "Strongly agree") ~ 5,
    as.character(value) %in% c("Agree") ~ 4,
    as.character(value) %in% c("Neutral","Netural") ~ 3,
    as.character(value) %in% c("Disagree") ~ 2,
    as.character(value) %in% c("Strongly Disagree") ~ 1,
    TRUE ~ NA_real_  # for any other cases
  )
}
convert_columns=c("freq","access","sat_per","impt","recall","mot_ler","sat_info","sat","anx","prcy","saw","p_att","flex","under","i_feed","m_obj","p_alter","add_s","l_exp")

# Apply the mapping function to specified columns
std_data <- std_data %>%
  mutate_at(vars(convert_columns), ~map_scale_values(.))
std_data


section_2_columns=c("freq", "sat", "sat_per")
section_3_columns=c("impt", "recall", "mot_ler")
section_4_columns=c("sat", "anx", "prcy", "saw", "p_att", "flex")
section_5_columns=c("under", "i_feed", "m_obj", "p_alter", "add_s", "l_exp")
# Summative score calculation
std_data$section_2_score <- rowSums(select(std_data,section_2_columns), na.rm = TRUE)
std_data$section_3_score <- rowSums(select(std_data,section_3_columns), na.rm = TRUE)
std_data$section_4_score <- rowSums(select(std_data,section_4_columns), na.rm = TRUE)
std_data$section_5_score <- rowSums(select(std_data,section_5_columns), na.rm = TRUE)

# Display the updated data frame with the summative score
head(std_data)




#1.One Sample T-Test
df=data.frame(std_data)
prcymean=mean(std_data$prcy)
# Null Hypothesis (H0):
# The mean of the variable 'prcy' in section-4 is equal to the hypothesized population mean.
# Mathematically: ?_prcy = 3.386076 (where ? represents the population mean)

# Alternative Hypothesis (Ha or H1):
# The mean of the variable 'prcy' in section-4 is not equal to the hypothesized population mean.
# Mathematically: ?_prcy ??? 3.386076 (where ? represents the population mean)

t.test(std_data$prcy, mu = prcymean)

# The p-value of 1 is greater than any common significance level (e.g., 0.05), indicating that there is no significant difference between the mean of the 'prcy' variable in the dataset and the hypothesized population mean of 3.386076. Therefore, we do not have enough evidence to reject the null hypothesis.
# there is no statistically significant difference between the mean of 'prcy' in the dataset and the hypothesized population mean of 3.386076.



#2. Two sample T-test
# Null Hypothesis (H0):
#   There is no significant difference in the mean satisfaction scores (sat_per) between undergraduate and postgraduate students.
# Mathematically: ?(undergrad)=?(postgrad) (where ?? represents the population mean).
# 
# Alternative Hypothesis (Ha or H1):
#   There is a significant difference in the mean satisfaction scores (sat_per) between undergraduate and postgraduate students.
# Mathematically: ?(undergrad)????(postgrad) (where ?? represents the population mean).
mean(df$e=="Undergraduate")
mean(df$e=="Postgraduate")
undergrad_data <- std_data$sat_per[std_data$e == "Undergraduate"]
postgrad_data <- std_data$sat_per[std_data$e == "Postgraduate"]
t_test_result <- t.test(undergrad_data, postgrad_data)
print(t_test_result)

# The p-value of 0.8828 is greater than common significance levels (e.g., 0.05), indicating that there is insufficient evidence to reject the null hypothesis. Therefore, based on this test, we do not have enough evidence to conclude that there is a significant difference in the mean satisfaction scores between undergraduate and postgraduate students.



#3. Performing one-way ANOVA
# Null Hypothesis (H0):
#   
#   There is no significant difference in the mean satisfaction scores (sat_per) among different education levels.
# Mathematically: ?1=?2=...=?k (where ?? represents the population mean for each education level, and kk is the number of education levels).
# 
# Alternative Hypothesis (Ha or H1):
#   
#   There is a significant difference in the mean satisfaction scores (sat_per) among at least two education levels.
# Mathematically: At least one ?i is different (where ii represents each education level).
anova_result <- aov(sat_per ~ e, data = std_data)
print(anova_result)

#The p-value associated with the F-statistic from the ANOVA test is not provided in the output.
#Without the exact p-value, it's not possible to determine the statistical significance of the ANOVA test. If we have the p-value, we can compare it to the chosen significance level to make a conclusive decision.

#4. Two-way ANOVA test
mod <- aov(section_4_score ~ e * g,
           data = std_data)

plot(mod, which = 2)
summary(mod)
#The p-value for 'e' is 0.262, which is greater than the significance level of 0.05. Therefore, we fail to reject the null hypothesis. There is no significant evidence to conclude that education level has a significant effect on 'section_4_score'.
#The p-value for 'g' is 0.123, which is greater than 0.05. We fail to reject the null hypothesis, indicating no significant evidence that gender has an effect on 'section_4_score'.
#The p-value for the interaction term 'e:g' is 0.480, which is greater than 0.05. We fail to reject the null hypothesis, suggesting no significant evidence of an interaction effect between education level and gender on 'section_4_score'.
#Based on the analysis, there is no significant evidence to suggest that education level, gender, or their interaction has a significant effect on 'section_4_score' at a 0.05 significance level. Therefore, we do not have enough evidence to reject the null hypotheses for any of the factors or their interaction.


#5. Corelation plot
library("corrplot")
d = subset(std_data, select = -c(ar,e,g) )
M=cor(d)
corrplot(M,method="circle")

#The above corelation plot displays the connection between each column in the dataset.
#There seems to be no negative co-relations in the dataset.
#There is very weak co-relation between many columns in the dataset.
#Each Section summative score seems to have normal positive corelation with each other column 

# One-Sample T-Test
t_test_result <- t.test(std_data$sat_per, mu = 4)
print(t_test_result)

# Two-Sample T-Test
undergrad_data <- std_data$sat_per[std_data$e == "Undergraduate"]
postgrad_data <- std_data$sat_per[std_data$e == "Postgraduate"]
t_test_result <- t.test(undergrad_data, postgrad_data)
print(t_test_result)

# One-Way ANOVA
anova_result <- aov(sat_per ~ ar, data = std_data)

# Print summary to get the p-value
summary(anova_result)

