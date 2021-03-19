print("How many fibonacci numbers do you want?")
nums = int(input())
print("")
a = 0
b = 1
while (nums>0):
  print(a)
  c = a+b
  a = b
  b = c
  nums = nums-1