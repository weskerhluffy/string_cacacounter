'''
Created on 30/06/2018

@author: ernesto
'''


# XXX: https://www.hackerrank.com/contests/code-leader/challenges/string-counter/submissions/code/1308573233

from re import split
from collections import Counter

h=False
w=split(r"[^A-Za-z]+", input().strip())
wo={}
for i,wt in enumerate(w):
    if wt not in wo:
        wo[wt]=i
c=Counter(w)
r=sorted(filter(lambda it:(it[0].strip() and it[1]>1),c.items()),key=lambda it:(it[1],-wo[it[0]]),reverse=True)
for it in r:
    h=True
    print("{} {}".format(it[1],it[0]))
if not h:
    print("0")