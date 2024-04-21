import random
import time

def transmission(N, tf):
    i = 1
    tt = 0
    while i <= tf:
        z = 0
        for k in range(i, min(i + N, tf + 1)):
            print("Sending Frame", k, "...")
            tt += 1
        for k in range(i, min(i + N, tf + 1)):
            f = random.randint(0, 1)
            if not f:
                print("Acknowledgment for Frame", k, "...")
                z += 1
            else:
                print("Timeout!! Frame Number:", k, "Not Received")
                print("Retransmitting Window...")
                break
        print()
        i += z
    return tt

def main():
    tf = int(input("Enter the Total number of frames: "))
    N = int(input("Enter the Window Size: "))
    random.seed(time.time())
    tt = transmission(N, tf)
    print("Total number of frames which were sent and resent are:", tt)

if __name__ == "__main__":
    main()
