## HomeWork
Create an Information System for an insurance company with the following functionality:
```
***** Menu *****
1. Prints all stored insurances (life and health) for a given customer.
2. Prints all stored insurances (life and health) for a given customer.
3. Prints details and type of for a given insurance .
```

• Run this menu until customer inserts “0”.
• If an insurance or customer code does not exists do not exit program but inform him that the code is not valid and give him the chance to insert a new one.

---------------------------------------------------------------------------------------------------------------------------------------

#### Customer Class
- Described by : customer’s code (auto-increment) name, year of birth and sex(male / female)
- Contains methods:  
  - Getters/setters
  - toString()

Each generated Customer object should be stored in an array (length=10).

---------------------------------------------------------------------------------------------------------------------------------------

#### Insurance Class
- Described by: customer’s code, insurance code(auto-increment ) and its duration. (Theinstance variables declared as protected)
- Contains methods:  
  - Setters/getters
  - toString ()
  - method for calculating insurance_cost returning:
    - A fixed price of 100 euro
  - method for printing all stored insurances
  - method for printing a particular insurance (argument : insurance code)

Each generated Insurance object should be stored in an array (length=10).

---------------------------------------------------------------------------------------------------------------------------------------

#### Life Class
- Extending Insurance class and further described by:
  - the amount the customer decides to invest.
  - Getters/setters
  - toString()
- The cost calculation is 100 euro plus 5 for every Customer’s year

Each generated Life object should be stored in an array (length=10).

---------------------------------------------------------------------------------------------------------------------------------------

#### Health Class
- Extending Insurance class and further described by:
  - the medical expense the customer wants.
  - Getters/setters
  - toString()
- The cost calculation is 100 euro plus 7 for every Customer’s year and other 50 euros if he is a man

Each generated Health object should be stored in an array (length=10).