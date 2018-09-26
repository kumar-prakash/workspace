
# examples of list
def test_list():
    mylist = [1, 2, 3, 4, 4, 5, 6, 8]
    print(mylist)
    print(mylist[4])
    print(mylist[4:])
    print(mylist[2::2])


#examples of dictionary
def test_dict():
    my_dict = {'first': 'Prakash', 'second': 'Hari', 3: 'Raj'}
    print(my_dict)
    print(my_dict[3])
    #print(my_dict['3']) # this results key error
    my_dict['forth'] = [1, 3, 5, 6]
    print(my_dict)
    print(my_dict['forth'][2:])
    
    print('--------------------------------------')
    for obj in my_dict:
        print(f'Key: {obj}, value: {my_dict[obj]}')
    
    print('--------------------------------------')
    for key,value in my_dict.items():
        print(f'Key: {key}, value: {value}')

    print('Printing tuples:-----------------------')
    for tup in my_dict.items():
        print(tup)

#test_dict()

def test_util():
    list1 = [1, 2, 3, 4]
    list2 = ['Prakash', 'Hari', 'Salman', 'Rock']
    list3 = list1 + list2
    print(list1)
    print(list2)
    print(list3)

test_util()