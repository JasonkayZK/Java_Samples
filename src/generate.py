with open('fileIODemo.txt', 'w') as f:
    for i in range(250000):
        f.write("Hello world " + str(i) + "\n")
