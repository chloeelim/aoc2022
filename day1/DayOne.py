def helper(str):
    calories = str.split("\n")
    return sum(map(int, calories))

f = open("input.txt", "r")
elves = f.read()[:-1].split("\n\n")

elves = list(map(helper, elves))
elves.sort(reverse=True)
print("Max Calorie Count:", elves[0])
print("Sum Top 3:", sum(elves[:3]))