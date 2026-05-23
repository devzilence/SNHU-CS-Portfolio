# CS-210-Corner-Grocer-Project
Project Three - Item tracking program

## Project Summary

For Project Three, I built an item‑tracking program for the Corner Grocer that reads a text file of purchased items and reports how often each item appears. The program processes the file `CS210_Project_Three_Input_File.txt`, counts occurrences for each grocery item such as apples or bananas, and then lets the user look up individual frequencies, see a full list of item counts, and view a text‑based histogram.

## What I Did Well

I focused first on understanding the main job of the program: reading the input file and counting how many times each item shows up. I used a `map<string, int>` called `itemFrequencies` to store each item name as the key and the count as the value so that I could look up items quickly. I also designed a `GroceryTracker` class to keep the logic organized in an object‑oriented way, with private members for the map and file names and public member functions to load data, create the backup file, and drive the menu.

## Possible Enhancements

Right now the program does what the rubric asks for: it reads the file, counts items, creates the backup file, and supports all four menu options. If I expanded it, I would improve error handling and data presentation. For example, I could sort the items alphabetically or by frequency before printing them to make the output easier to read, and I could add more detailed messages when files fail to open or when a user searches for an item that does not exist. These changes would make the program more user‑friendly and would help prevent confusing situations if the input file or user input is not what the program expects.

## Challenges and How I Overcame Them

Some of the most challenging parts were setting up the file input and making sure the menu behaved correctly for every option. I had to think carefully about how to use `ifstream` in a loop so that every word in the file was read and counted without skipping or duplicating data. I also had to make sure the menu loop kept running until the user chose to exit and that each option called the correct function. To handle this, I tested each function one at a time in Visual Studio, then combined them into the full program. I used examples from class, zyBooks readings, and online references on maps and file I/O as part of my support network.

## Transferable Skills

This project helped me practice several skills that transfer to other coursework and projects. Working with maps reinforced how to pair keys with values for fast lookups, which is useful in many real‑world applications. Designing a class with clear responsibilities improved my object‑oriented programming habits. Managing file input and output, validating user input, and building a menu‑driven console interface are all techniques that I can reuse in future C++ projects and in other languages.

## Maintainability, Readability, and Adaptability

I made the program more maintainable and readable by separating responsibilities into well‑named functions like `LoadDataFromFile`, `CreateBackupFile`, and `DisplayMenu`. The `GroceryTracker` class keeps related data and behavior together so that changes to how items are counted or stored stay in one place. I used comments and descriptive variable names to make the logic easier to follow. The menu loop is straightforward, and the histogram and frequency output are simple to understand, so another developer could adapt the program to use different input files, output formats, or additional menu options in the future. 
