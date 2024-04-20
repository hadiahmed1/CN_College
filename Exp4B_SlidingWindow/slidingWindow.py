def main():
    w = int(input("Enter window size: "))
    f = int(input("\nEnter number of frames to transmit: "))

    frames = []
    print("\nEnter {} frames: ".format(f))
    for i in range(1, f + 1):
        frames.append(int(input()))

    print("\nWith sliding window protocol the frames will be sent in the following manner (assuming no corruption of frames)\n")
    print("After sending {} frames at each stage sender waits for acknowledgement sent by the receiver\n".format(w))

    for i in range(0, f + 1):
        if i % w == 0:
            print(frames[i])
            print("Acknowledgement of above frames sent is received by sender\n")
        else:
            print(frames[i], end=" ")

    if f % w != 0:
        print("\nAcknowledgement of above frames sent is received by sender")

if __name__ == "__main__":
    main()
