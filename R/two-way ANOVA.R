# install.packages("palmerpenguins")
library(palmerpenguins)

dat <- penguins # rename dataset
str(dat) # structure of dataset

# Main effect of sex on body mass:
#   
#H0: mean body mass is equal between females and males
#H1: mean body mass is different between females and males
# 
# Main effect of species on body mass:
#H0: mean body mass is equal between all 3 species
#H1: mean body mass is different for at least one species
# 
# Interaction between sex and species:
#H0: there is no interaction between sex and species, meaning that the relationship between species and body mass is the same for females and males (similarly, the relationship between sex and body mass is the same for all 3 species)
#H1: there is an interaction between sex and species, meaning that the relationship between species and body mass is different for females than for males (similarly, the relationship between sex and body mass depends on the species)

table(dat$species, dat$sex)


mod <- aov(body_mass_g ~ sex * species,
           data = dat
)


plot(mod, which = 2)


# install.packages("car")
library(car)
qqPlot(mod$residuals,
       id = FALSE # remove point identification
)


hist(mod$residuals)


shapiro.test(mod$residuals)


plot(mod, which = 3)


leveneTest(mod)


library(ggplot2)
ggplot(dat) +
  aes(x = sex, y = body_mass_g) +
  geom_boxplot()

# boxplots by species
ggplot(dat) +
  aes(x = species, y = body_mass_g) +
  geom_boxplot()


# mean by group
aggregate(body_mass_g ~ species + sex,
          data = dat,
          FUN = mean
)


# mean and sd by group
library(dplyr)

group_by(dat, sex, species) %>%
  summarise(
    mean = round(mean(body_mass_g, na.rm = TRUE)),
    sd = round(sd(body_mass_g, na.rm = TRUE))
  )


# boxplot by group
library(ggplot2)

ggplot(dat) +
  aes(x = species, y = body_mass_g, fill = sex) +
  geom_boxplot()


dat %>%
  filter(!is.na(sex)) %>%
  ggplot() +
  aes(x = species, y = body_mass_g, fill = sex) +
  geom_boxplot()


dat %>%
  filter(!is.na(sex)) %>%
  ggplot() +
  aes(x = sex, y = body_mass_g, fill = species) +
  geom_boxplot() 