setwd("C:/Users/91939/Desktop/1st-MCA/R")
data=read.csv("13-Influence of AI TOOLS on Student's Learning Process.csv",header=T)

#Dropping unwanted columns and cleaning the dataset
drop=c("Timestamp","Username","Any.Comments..Review")
data=df = data[,!(names(data) %in% drop)]

#change column_names
colnames(data)=c("ar","g","e","freq","access","sat_per","impt","recall","mot_ler","sat_info","sat","anx","prcy","saw","p_att","flex","under","i_feed","m_obj","p_alter","add_s","l_exp")

#converting the columns into relevant datatype
data$g<-factor(data$g)
data$ar<-factor(data$ar)
data$e<-factor(data$e)

#Pie-chart for Age
table(data$ar)
df <- data.frame(AgeGroup = c("18-24", "Above 24", "Under 18"),
  Count = c(134, 19, 5))

library(plotly)
plot_ly(labels = df$AgeGroup,values = df$Count,type = "pie",textinfo = "label+percent",
  textposition = "inside",hoverinfo = "text+percent") %>%
layout(title = "3D Pie Chart - Age Distribution",scene = list(aspectmode = "cube",
      camera = list(eye = list(x = 1.2, y = 1.2, z = 1.2))))


#Piechart for Gender
df <- data.frame(
  Gender = c("Female", "Male"),
  Count = c(64, 94)
)
# install.packages("plotly")
library(plotly)

plot_ly(labels = df$Gender,values = df$Count,type = "pie",textposition = "inside",
        textinfo = "label+percent",hole = 0.6) %>%
layout(title = "Gender Distribution",scene = list(
  aspectmode = "manual",aspectratio = list(x = 1, y = 1, z = 1))
  )




#Pie chart for education levels
exp_data=as.data.frame(table(data$e))

# Assuming your data is stored in a data frame named 'df'
df <- data.frame(  Category = c("Animations", "B.Com", "BBM", "Data science", "Graduate", "HighSchool", "Ph.D", "Postgraduate", "PU", "Undergraduate", "Working"),
  Count = c(1, 1, 1, 1, 1, 2, 1, 69, 2, 78, 1))
df <- df[order(-df$Count),]
library(ggplot2)
df$Category <- factor(df$Category, levels = df$Category)
ggplot(df, aes(x = "", y = Count, fill = Category, label = "")) +
  geom_bar(stat = "identity", width = 1, color = "black", size = 0.1) +
  coord_polar("y") +
  theme_void() +
  labs(title = "Distribution of Categories") +
  scale_fill_discrete(name = "Category",breaks = df$Category,
    labels = paste(df$Category, " (", df$Count, ")", sep = "")) +
  theme(legend.position = "bottom")




