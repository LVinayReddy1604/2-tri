setwd("C:/Users/91939/Desktop/1st-MCA/R")
std_data=read.csv("13-Influence of AI TOOLS on Student's Learning Process.csv",header=T)

#Dropping unwanted columns and cleaning the dataset
drop=c("Timestamp","Username","Any.Comments..Review")
std_data= std_data[,!(names(std_data) %in% drop)]
# df=subset(std_data,-c("."))

#change column_names
colnames(std_data)=c("ar","g","e","freq","access","sat_per","impt","recall","mot_ler","sat_info","sat","anx","prcy","saw","p_att","flex","under","i_feed","m_obj","p_alter","add_s","l_exp")
str(std_data)
#checking for null values
is.na(std_data)
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
#Most users who use Ai Tools Frequently are overall satisfied with the services provided
#Anyhow very few who use the AI tools are not satisfied  





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





