import random

def output(heaps):
    out = ''
    for n in heaps:
        out = out+str(n)+' '
    return out

def gameover(heaps):
    for n in heaps:
        if n !=0:
            return False
    return True

def computerAction(heaps):
    if gameover(heaps):
        return print("Player human has won",flush=True)
    X = random.randint(1,len(heaps))
    while(heaps[X-1]==0):
        X = random.randint(1,len(heaps))
    Y = random.randint(1,heaps[X-1])
    heaps[X-1] = heaps[X-1] - Y
    print("Player computer took", Y ,"objects from heap",X, flush = True)
    out = output(heaps)
    print(out,flush = True)
    return humanAction(heaps)
    
    
def humanAction(heaps):
    if gameover(heaps):
        return print("Player computer has won",flush=True)
    print("Player human enter the number of objects (Y) to take from what heap (X)- in order: Y X",flush=True)
    enter = input().split()
    if len(enter)!=2 :
        print("Player human that is an invalid move, try again",flush=True)
        return humanAction(heaps)
    if not(enter[0].isdigit() and enter[1].isdigit()):
        print("Player human that is an invalid move, try again",flush=True)
        return humanAction(heaps)
    else:
        Y = int(enter[0])
        X = int(enter[1])
    if X > len(heaps) or X < 1:
        print("Player human that is an invalid move, try again",flush=True)
        return humanAction(heaps)
    if Y > heaps[X-1] or Y < 1:
        print("Player human that is an invalid move, try again",flush=True)
        return humanAction(heaps)
    else: 
        heaps[X-1] = heaps[X-1] - Y
        out = output(heaps)
        print(out,flush = True)
        return computerAction(heaps)
    
def nim(heaps,turn):    
    if turn == 'human':
        humanAction(heaps)
    else: 
        computerAction(heaps)

X = random.choice((3,5,7))
heaps = []
for i in range (X):
    heaps.append(random.choice((9,11,13)))
out = output(heaps)
starter = random.choice(("human","computer"))
print("Created", X, "heaps of sizes",out,flush=True)
print("Player", starter, "goes first",flush=True)  
        
nim(heaps,starter)
