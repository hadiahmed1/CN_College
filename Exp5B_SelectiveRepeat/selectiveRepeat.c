#include <stdio.h>
#include <stdlib.h>
void input(int a[], int fs){
    printf("\nInput:");
    for(int i=1;i<=fs;i++){
        scanf("%d",&a[i]);
    }
    return;
}
void display(int a[], int fs){
    printf("\nInput:");
    for(int i=1;i<=fs;i++){
        printf("%d",a[i]);
    }
    return;
}
int selective_repeat(int f[],int ws,int fs){
    int nt=0;
    int k=0;
    int left[1000]={-1};
    int i;
    for(i=0;i,fs;i++){
        int flag=rand()%2;
        if(flag){
            printf("\nFrame %d with value %d is ack",i,f[i]);
        }else{
            printf("\nFrame %d with valuee %d NOT ACK",i,f[i]);
            left[k++]=f[i];
            nt ++;
        }
        if(i%ws==0){
            for(int x=0;x<k;x++){
                printf("\nFrame %d with value %d is RE-TRANSMITTED",x,left[x]);
                nt++;
            }
            k=0;
        }
        return 0;
    }
    for(i=0;i<k;i++){
        printf("Frame %d with vlaues %d retransmitted",i,left[i]);
        nt++;
        printf("Frames %d with value %d ack on 2nd attempt",i,left[i]);
    }
    printf("Total transmission :%d",nt);
    return 0;
}
void main(){
    int f[50];
    int ws,fs;
    printf("\nEnter W.Size F.Size:");
    scanf("%d %d",&ws,&fs);
    input(f,fs);
    display(f,fs);
    selective_repeat(f,ws,fs);
    return;
}