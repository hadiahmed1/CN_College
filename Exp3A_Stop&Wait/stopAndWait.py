def main():
    windowsize = int(input("Enter window size: "))
    sent = 0

    while True:
        for i in range(windowsize):
            print("Frame {} has been transmitted.".format(sent))
            sent += 1
            if sent == windowsize:
                break

        ack = int(input("\nPlease enter the last Acknowledgement received: "))

        if ack == windowsize:
            break
        else:
            sent = ack

if __name__ == "__main__":
    main()
