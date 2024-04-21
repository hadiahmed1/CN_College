# Function that performs XOR operation
def XOR(check_value, gen_poly):
    # If both bits are the same, the output is 0
    # If the bits are different the output is 1
    for j in range(1, len(gen_poly)):
        check_value[j] = '0' if check_value[j] == gen_poly[j] else '1'

# Function to check for errors on the receiver side
def receiver(data, gen_poly):
    # Get the received data
    print("Enter the received data: ")
    received_data = input()
    print("\n-----------------------------")
    print("Data received: ", received_data)

    # Cyclic Redundancy Check
    check_value = crc(data, gen_poly)

    # Check if the remainder is zero to find the error
    for i in range(len(gen_poly) - 1):
        if check_value[i] != '0':
            print("\nError detected\n")
            return
    print("\nNo error detected\n")

# Cyclic Redundancy Check function
def crc(data, gen_poly):
    check_value = list(data)
    i = 0
    while i <= len(data) - len(gen_poly) + 1:
        # Check if the first bit is 1 and call XOR function
        if check_value[0] == '1':
            XOR(check_value, gen_poly)
        # Move the bits by 1 position for the next computation
        check_value = check_value[1:] + [data[i + len(gen_poly) - 1]]
        i += 1
    return check_value

def main():
    # Get the data to be transmitted
    data = input("\nEnter data to be transmitted: ")
    # Get the generator polynomial
    gen_poly = input("\nEnter the Generating polynomial: ")

    # Find the length of data
    data_length = len(data)
    # Appending n-1 zeros to the data
    data += '0' * (len(gen_poly) - 1)

    print("\n----------------------------------------")
    # Print the data with padded zeros
    print("\nData padded with n-1 zeros:", data)
    print("\n----------------------------------------")

    # Cyclic Redundancy Check
    check_value = crc(data, gen_poly)

    # Print the computed check value
    print("\nCRC or Check value is:", ''.join(check_value))

    # Append data with check_value(CRC)
    data += ''.join(check_value[len(data) - data_length:])

    print("\n----------------------------------------")
    # Print the final data to be sent
    print("\nFinal data to be sent:", data)
    print("\n----------------------------------------")

    # Calling the receiver function to check errors
    receiver(data, gen_poly)

if __name__ == "__main__":
    main()
