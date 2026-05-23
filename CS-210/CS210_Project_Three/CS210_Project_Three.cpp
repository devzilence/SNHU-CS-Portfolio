//Name      - Adalberto Flores
//Course    - CS-210_Project Three
//Professor - Alvis Forrest
//Date      - 04-19-26

#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <limits>

using namespace std;

class GroceryTracker {
private:
    map<string, int> itemFrequencies;   // Stores each grocery item and how many times it appears
    string inputFileName;               // Name of the input file with the grocery list
    string backupFileName;              // Name of the file that saves item frequencies

public:
    // Constructor that sets the input and output file names
    GroceryTracker(const string& inputFile, const string& backupFile) {
        inputFileName = inputFile;
        backupFileName = backupFile;
    }

    // Reads the grocery items from the input file and counts each one
    void LoadDataFromFile() {
        ifstream inputFile(inputFileName);
        string itemName;

        // Make sure the file opened correctly before trying to read from it
        if (!inputFile.is_open()) {
            cout << "Error: Could not open input file." << endl;
            return;
        }

        // Read each item from the file and increase its count in the map
        while (inputFile >> itemName) {
            itemFrequencies[itemName]++;
        }

        inputFile.close();
    }

    // Creates a backup file that stores each item with its frequency
    void CreateBackupFile() const {
        ofstream outputFile(backupFileName);

        // Make sure the output file was created successfully
        if (!outputFile.is_open()) {
            cout << "Error: Could not create backup file." << endl;
            return;
        }

        // Write each item and its count to the backup file
        for (const auto& pair : itemFrequencies) {
            outputFile << pair.first << " " << pair.second << endl;
        }

        outputFile.close();
    }

    // Lets the user search for how many times a specific item appears
    void SearchItemFrequency() const {
        string itemName;

        cout << "Enter the item you want to search for: ";
        cin >> itemName;

        auto it = itemFrequencies.find(itemName);

        // If the item exists in the map, print its frequency
        if (it != itemFrequencies.end()) {
            cout << itemName << " appears " << it->second << " time(s)." << endl;
        }
        // If the item is not found, show 0
        else {
            cout << itemName << " appears 0 time(s)." << endl;
        }
    }

    // Prints every item and its frequency
    void PrintAllFrequencies() const {
        for (const auto& pair : itemFrequencies) {
            cout << pair.first << " " << pair.second << endl;
        }
    }

    // Prints a histogram using asterisks to represent the item count
    void PrintHistogram() const {
        for (const auto& pair : itemFrequencies) {
            cout << pair.first << " ";

            // Print one star for each time the item appears
            for (int i = 0; i < pair.second; i++) {
                cout << "*";
            }

            cout << endl;
        }
    }

    // Displays the menu options for the user
    void DisplayMenu() const {
        cout << endl;
        cout << "Corner Grocer Menu" << endl;
        cout << "------------------" << endl;
        cout << "1. Search for an item frequency" << endl;
        cout << "2. Print all item frequencies" << endl;
        cout << "3. Print histogram" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
    }
};

int main() {
    // Create the GroceryTracker object and connect it to both files
    GroceryTracker tracker("CS210_Project_Three_Input_File.txt", "frequency.dat");
    int userChoice = 0;

    // Load the grocery data first, then save a backup frequency file
    tracker.LoadDataFromFile();
    tracker.CreateBackupFile();

    do {
        tracker.DisplayMenu();
        cin >> userChoice;

        // Handle invalid input so the program does not crash
        while (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a number from 1 to 4: ";
            cin >> userChoice;
        }

        cout << endl;

        // Run the option the user selected from the menu
        switch (userChoice) {
        case 1:
            tracker.SearchItemFrequency();
            break;

        case 2:
            tracker.PrintAllFrequencies();
            break;

        case 3:
            tracker.PrintHistogram();
            break;

        case 4:
            cout << "Exiting program." << endl;
            break;

        default:
            cout << "Invalid option. Please choose 1, 2, 3, or 4." << endl;
            break;
        }

    } while (userChoice != 4);

    return 0;
}