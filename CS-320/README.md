# CS 320 Portfolio Submission

This repository contains selected artifacts from my work in CS 320 Software Test, Automation, and Quality Assurance. It includes the contact service files from Project One, the summary and reflections report from Project Two, and this README reflection on what I learned about software testing, requirements, and software design.

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

To make sure software is functional and secure, I need to do more than just check whether it compiles or whether a few tests pass. One of the biggest things I learned in this course is that testing has to connect directly to the requirements. If a requirement says a field cannot be null, cannot go over a certain length, or cannot be updated, then I need tests that prove those rules are actually enforced.

In this course, I used JUnit to test valid cases, invalid cases, and boundary values. That helped me confirm that the code accepted the right inputs and rejected the wrong ones. I also learned that passing tests do not automatically mean the test suite is strong. The tests have to show real evidence that the software behaves the way it is supposed to behave.

Security also connects back to validation and defensive design. Checking inputs before storing them, rejecting duplicate or invalid data, and making sure objects cannot be changed in ways that break the requirements all help make software more reliable. I also saw that code coverage can support quality, but coverage by itself is not enough. What matters more is writing meaningful tests that actually prove the important behavior.

### How do I interpret user needs and incorporate them into a program?

I interpret user needs by starting with the stated requirements and treating them as the source of truth for what the program needs to do. In this course, the user needs were expressed through rules for object fields, service behavior, and update restrictions. I learned to take those requirements and turn them into specific behaviors that the code had to support.

This course also showed me that user needs are not only about the happy path. A user need can also mean the system must reject invalid input, prevent duplicate records, and stop data from being changed in ways that should not be allowed. Looking at requirements this way helped me think less about whether the program simply runs and more about whether it behaves correctly in realistic situations.

I also learned that feedback helps improve how I interpret requirements. Earlier in the course, I missed some edge cases because I was mostly testing the inputs I expected. After reviewing feedback, I got better at intentionally trying to break the code with null values, oversized strings, duplicate IDs, and other invalid inputs. That helped me align my work more closely with real user and system needs instead of just my first assumptions.

### How do I approach designing software?

I approach software design by starting with the requirements, identifying the main objects and services, and building validation into the design from the beginning. In these projects, that meant creating backend classes with clear responsibilities. The object classes were responsible for holding valid data, while the service classes managed collections of those objects and controlled operations like add, delete, and update.

I also design software with testing in mind. This course showed me that writing the class itself is only part of the job. If the design is hard to test, then it becomes harder to prove that the software meets the requirements. Writing tests alongside the code helped me see where validation was weak, where update methods needed to be more specific, and where error handling needed to be clearer.

Overall, my design process is more disciplined now than it was at the start of the course. I pay more attention to boundaries, invalid input, update rules, and how one class affects another. I understand better now that good software design is not just about making something work once. It is about building something that matches requirements, is easier to verify, and can hold up when changes are made later.
