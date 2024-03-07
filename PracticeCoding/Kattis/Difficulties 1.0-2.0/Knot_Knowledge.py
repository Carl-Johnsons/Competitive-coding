n = int(input())
input_str1 = (input()).split()
input_str2 = (input()).split()
dict1 = {}
list1 = [int(num) for num in input_str1]
list2 = [int(num) for num in input_str2]
for i in range(len(list1)):
    dict1[list1[i]] = dict1.get(list1[i], 0) + 1
for i in range(len(list2)):
    dict1[list2[i]] = dict1.get(list2[i], 0) - 1
for key in dict1:
    if dict1[key] > 0:
        print(key)
        break
