# Java Console Application for Lottery

## Functional requirements:
- Allow to add/edit/delete/view a list of customer. Info of a customer includes name, birthdate, address, phone, email
- Allow to add/edit/delete/view a list of Vietlott shops. Information of a shop includes code, address, owner, phone, email, account balance (money deposit - money issuing lottery).
- Once a week, Vietlott will conduct a draw. The draw will generate 6 numbers between 0 and 45 (use Math random to do this)
- Trigger the buying process where the system must generate 6 random numbers (0-45) until they match the Vietlott number (jackpot). Print the number of times the buying process needs before the matching happens. Show number in a line and stop when the jackpot happens.
- Run the trigger 5 times and calculate the average number of times one needs to buy to become a winner.
- Can undo change.
- No second instance created.

## Non-functional requirements:
- Friendly and easy to use
- Reliable with proper try/catch

