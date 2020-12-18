# The current gas price
gas_price = float(input("Gas Price: "))

# what the user is comparing ABOVE to.
average_gas_price = float(input("Average gas price: "))

# gas tank size
maximum_gas_capacity = float(input("Maximum capacity of gas tank: "))

# rough percentage of gas left in the tank
gas_percentage_left = float(input("Gas percentage left (Ex: 10%, 20% ): ")) * 0.01

# estimation of gas amount left
current_gas_amount = maximum_gas_capacity * gas_percentage_left
print(f"The initial gas amount in the vehicle is: {current_gas_amount}")

# distance to the gas station
distance = float(input("Distance to gas station: "))

# current gas efficiency
mpg = float(input("The current mpg of your car (depending on your current conditions): "))

# the gas that will be used on the trip to the gas station
gas_used_going = (distance * mpg ** -1)
print(f"The gas amount that will be used on the trip is: {gas_used_going}")

# the amount of gas that OP will have when they get to the station
gas_amount_at_station = (current_gas_amount - gas_used_going)
print(f"The gas amount at the station is: {gas_amount_at_station}")

# The amount of gas you will need to buy at the station
gas_needed_at_station = maximum_gas_capacity - gas_amount_at_station
print(f"The gas that you need to buy to fill your tank is: {gas_needed_at_station}")

# The amount of money that you will pay with the new gas price
current_total_price_at_station = gas_price * gas_needed_at_station
print(f"The amount you will pay to fill up your vehicle is: {current_total_price_at_station}")

# The amount of money that you would pay if on the average price
average_total_price_at_station = average_gas_price * gas_needed_at_station
print(f"The amount you would have paid is: {average_total_price_at_station}")

# The price score
score = ( average_total_price_at_station / current_total_price_at_station ).__round__(2)

# Display correct grammar
if score > 1:
    print(f"Your price is {score}x better than usual.")
elif score <= 1:
    print(f"your score is {score}x worse than usual.")
