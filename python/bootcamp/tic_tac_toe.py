def print_grid(values):
    print("   |   |   ")
    print(f" {values[7]} | {values[8]} | {values[9]} ")
    print("___|___|___")
    print("   |   |   ")
    print(f" {values[4]} | {values[5]} | {values[6]} ")
    print("___|___|___")
    print("   |   |   ")
    print(f" {values[1]} | {values[2]} | {values[3]} ")
    print("   |   |   ")

def game_status(values, first_player):
    pass

def game(first, second):
    values = {1: " ", 2: " ", 3: " ", 4: " ", 5: " ", 6: " ", 7: " ", 8: " ", 9: " "}
    print(f"Game started with first player: {first} and second player: {second}")

    count = 0
    is_first_player_active = True
    while count < 9:
        response = int(input("Enter choice: "))
        if response < 1 or response > 9:
            print("Invalid input, input must be in range 1 - 9")
            continue
        elif values[response] != " ":
            print(f"Invalid input, cell: {response} is already taken, try again.")
            continue
        else:
            values[response] = first if is_first_player_active else second
            status = game_status(values, first)
            if status == 1:
                print("First player won.")
                break
            elif status == 2:
                print("Second player won.")
                break
            else:
                print_grid(values)
                count += 1
                is_first_player_active = not is_first_player_active

def start_game():
    first = input("Enter your choice X or O: ")
    if first == "X":
        second = "O"
    else:
        second = "X"
    game(first, second)

start_game()



