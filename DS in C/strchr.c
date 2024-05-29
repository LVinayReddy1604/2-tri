#include <stdio.h>
#include <string.h>
//first occurence
main ()
{
  char string[55] ="This is a string for testing";
  char *p;
  p = strchr (string,'i');
 
  printf ("Character i is found at position %d\n",p-string);///returns the memoru
   
}
