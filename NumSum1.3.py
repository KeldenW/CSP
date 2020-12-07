from itertools import combinations

L = [257, 24, 788, 431, 572, 6, 602, 441, 564, 341, 482, 605, 779, 78, 275, 263, 357]

L.sort()
L.reverse()

num = 2500

dev_range = 5

numnum = 1

while num / (L[0] * numnum) > .5:
    numnum += 1

dict = {}



for i in range(numnum+1):
    dict[i] = [comb for comb in combinations(L, i)]

for deviation in range(dev_range):
    for i in range(numnum+1):
        for section in dict[i]:
            if sum(section) == num + deviation:
                print(str(section) + "" + str(sum(section)))