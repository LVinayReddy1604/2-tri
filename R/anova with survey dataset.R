setwd("C:/Users/91939/Desktop/1st-MCA/R")
data=read.csv("13-Influence of AI TOOLS on Student's Learning Process.csv",header=T)
drop=c("Timestamp","Username","Any.Comments..Review")
data=df = data[,!(names(data) %in% drop)]

colnames(data)=c("ar","g","e","freq","access","sat_per","impt","recall","mot_ler","sat_info","sat","anx","prcy","saw","p_att","flex","under","i_feed","m_obj","p_alter","add_s","l_exp")

#converting the columns into relevant datatype
data$g<-factor(data$g)
data$ar<-factor(data$ar)
data$e<-factor(data$e)

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

# Apply the mapping function to specified columns
data <- data %>%
  mutate_at(vars(convert_columns), ~map_scale_values(.))
data


