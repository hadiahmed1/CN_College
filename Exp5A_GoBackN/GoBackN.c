#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void transmission(int N, int tf) {
    int i = 1;
    int tt = 0;
    srand(time(NULL));
    while (i <= tf) {
        int z = 0;
        for (int k = i; k < i + N && k <= tf; k++) {
            printf("Sending Frame %d...\n", k);
            tt++;
        }
        for (int k = i; k < i + N && k <= tf; k++) {
            int f = rand() % 2;
            if (!f) {
                printf("Acknowledgment for Frame %d...\n", k);
                z++;
            } else {
                printf("Timeout!! Frame Number: %d Not Received\n", k);
                printf("Retransmitting Window...\n");
                break;
            }
        }
        printf("\n");
        i += z;
    }
    printf("Total number of frames which were sent and resent are: %d\n", tt);
}

int main() {
    int tf, N;
    printf("Enter the Total number of frames: ");
    scanf("%d", &tf);
    printf("Enter the Window Size: ");
    scanf("%d", &N);
    transmission(N, tf);
    return 0;
}
