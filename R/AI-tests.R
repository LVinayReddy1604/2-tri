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



# Correlation between two variables (e.g., 'section_2_score' and 'section_3_score')
cor(std_data$section_2_score, std_data$section_3_score)

# One-way ANOVA for 'section_2_score' across different levels of a factor variable (e.g., 'g')
anova(lm(section_2_score ~ g, data = std_data))

lm_model <- lm(section_2_score ~ section_3_score, data = std_data)
summary(lm_model)


# Correlation Matrix for Selected Columns
selected_columns <- c("freq", "access", "sat_per", "impt", "recall", "mot_ler", "sat_info", "sat", "anx", "prcy", "saw", "p_att", "flex", "under", "i_feed", "m_obj", "p_alter", "add_s", "l_exp")

cor_matrix <- cor(std_data[, selected_columns])

# Display the Correlation Matrix
print(cor_matrix)

# Visualize the Correlation Matrix (Optional)
library(corrplot)
corrplot(cor_matrix, method = "circle")




# Example: Paired t-test between 'freq' and 'access'
paired_t_test_result <- t.test(std_data$freq, std_data$access, paired = TRUE)
print(paired_t_test_result)





# Example: One-way ANOVA between 'g' (gender) and 'sat' (satisfaction)
anova_result <- aov(sat ~ g, data = std_data)
print(anova_result)


t_test_result_2_vs_3 <- t.test(std_data$section_2_score, std_data$section_3_score)
print(t_test_result_2_vs_3)


cor_2_and_3 <- cor(std_data$section_2_score, std_data$section_3_score)
print(cor_2_and_3)


lm_model_4_vs_5 <- lm(section_4_score ~ section_5_score, data = std_data)
summary(lm_model_4_vs_5)


help("geom_bar")
