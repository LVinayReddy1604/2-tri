#include <stdio.h>
#include <string.h>

int main () {
   char src[50], dest[50];

   strcpy(src,  "CHRIST UNIVERSITY");
   strcpy(dest, "BCA");

   strncat(dest, src, 6);

   printf("Final destination string : %s", dest);
   
   return(0);
}
