def add_num(arg1, arg2):
    return arg1 + arg2

#result = add_num(10, 20)
#print(result)


def pig_latin(word):
    first_letter = word[0]
    if first_letter in 'aeiou':
        return word + 'ay'
    else:
        return word[1:] + first_letter + 'ay'


print(pig_latin('apple'))
print(pig_latin('word'))
