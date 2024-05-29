#include <stdio.h>
#include <stdlib.h>

struct linked
{
    int id;
    int priority;
    int state;
    struct linked *next;
};

void displayid(struct linked *vidr)
{
    while (vidr != NULL)
    {
        printf("the values of id is %d\n", vidr->id);
        vidr = vidr->next;
    }
}

void displaypriorty(struct linked *vidr)
{
    while (vidr != NULL)
    {
        printf("the values of priority is %d\n", vidr->priority); // Changed to vidr->priority
        vidr = vidr->next;
    }
}

void displaystate(struct linked *vidr)
{
    while (vidr != NULL)
    {
        printf("the values of state is %d\n", vidr->state); // Changed to vidr->state
        vidr = vidr->next;
    }
}

int findHighestPriority(struct linked *head)
{
    int maxPriority = -1; // Initializing with a value lower than possible priorities

    while (head != NULL)
    {
        if (head->priority > maxPriority)
        {
            maxPriority = head->priority;
        }
        head = head->next;
    }

    return maxPriority;
}

int main()
{
    struct linked *heid;
    struct linked *second;
    struct linked *third;
    struct linked *heprior;
    struct linked *hestat;

    heid = malloc(sizeof(struct linked));
    heprior = malloc(sizeof(struct linked));
    hestat = malloc(sizeof(struct linked));
    second = malloc(sizeof(struct linked));
    third = malloc(sizeof(struct linked));

    heid->id = 10;
    heid->next = second;

    heprior->priority = 40;
    heprior->next = second;

    hestat->state = 70;
    hestat->next = second;

    second->id = 20;
    second->priority = 50;
    second->state = 80;
    second->next = third;

    third->id = 30;
    third->priority = 60;
    third->state = 90;
    third->next = NULL;

    printf(" %d\n", heid->id);
    printf("%p\n", heid->next);
    printf("%d\n", heprior->priority);
    printf("%p\n", heprior->next);
    printf("%d\n", hestat->state);
    printf("%p\n", hestat->next);

    displayid(heid);
    displaypriorty(heprior);
    displaystate(hestat);

    int highestPriority = findHighestPriority(heprior);
    printf("The highest priority is: %d\n", highestPriority);

    return 0;
}

