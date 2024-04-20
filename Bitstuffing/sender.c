#include <stdio.h>
int main(){
    printf("Enter Bit sequence, Enter -1 to terminate bit sequence/n/n");
    int bits[50];
    int i=0;
    int bit;
    scanf("%d",&bit);
    int check=0;
    while(bit==0 || bit==1){
        bits[i++]=bit;
        if(bit==1){
            check++;
        }else{
            check=0;
        }
        if(check==5){
            bits[i++]=0;
            check=0;
        }
        scanf("%d",&bit);
    }   
    printf("The Bit sequence is:");
    for(int j=0;j<i;j++){
        printf("%d",bits[j]);
    }
    return 0;

}