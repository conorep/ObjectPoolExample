# Object Pool Example Code
## Conor O'Brien and Nathan Arrowsmith
## SDEV 426 Fall 2022

*This project was created for usage in teaching about the Object Pool design pattern.*

- The folder titled 'classexample' will be used for a code-along portion of the presentation.
- The folder titled 'objectpooltests' contains two driver classes used to compare runtime and memory usage between using an object pool and creating a large number of objects.
- The ObjectPoolMain class inside of the 'objectpooltests' folder also contains a console game that can be used in conjunction with an IDEs debugger to see some of the object pool functions in action (i.e. borrowing and returning pool objects).

## Console Game Info:

It's you against the world, much like Tupac. You will fight a never-ending pool of enemies until you die or quit 
(choose your destiny). Your character is instantiated with a randomly-chosen weakness and each enemy in the pool has a 
list of three randomly-chosen skills. If they have a skill that matches your weakness, be afraid! Otherwise, fight on.

The game has a menu that will show you which value to enter to attack, return an enemy to the pool, end the game, or 
display info about your character or the enemy that you are currently fighting.
