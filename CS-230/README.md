# CS-230: Operating Platforms - Software Design Document

This repository contains the software design document for **The Gaming Room**, a project completed as part of my CS-230 Operating Platforms course. Below is a reflection on the design process, the architectural decisions made, and my growth as a developer during this project.

## 📝 Project Reflection

### The Client and Software Requirements
**The Gaming Room** is a client looking to expand their existing Android-only game, *Draw It or Lose It*, into a cross-platform web-based system accessible on Mac, Windows, Linux, and Mobile devices. They required a system that could handle multiple teams and players, enforce unique naming constraints, and centrally manage game state using a single service instance.

### Documentation Strengths
I believe I excelled in evaluating the characteristics of different operating platforms and translating those constraints into architectural recommendations. I clearly mapped out how a centralized Linux server handling a Java backend (with JVM garbage collection) and a PostgreSQL database would solve the client's need for scalability, security, and cross-platform compatibility. 

### The Value of Design Documents in Development
Working through the domain model and UML diagrams before writing a single line of code was incredibly helpful. It forced me to establish the inheritance structure early (where `Game`, `Team`, and `Player` all inherit from a base `Entity` class) and solidified my understanding of *why* the `GameService` needed to use the Singleton pattern to prevent data conflicts. It essentially served as a clear roadmap for the actual coding phase.

### Areas for Improvement and Revision
If I could revise one part of this document, I would modernize the deployment recommendations. While I discussed testing across different OS environments in my evaluation, I would improve the design by incorporating **containerization (like Docker)**. Recommending Docker would assure the client that the application will run identically regardless of the underlying host operating system, reducing the overhead of manual testing on different Linux distributions or Windows versions.

### Interpreting and Implementing User Needs
The client's primary need was accessibility: players shouldn't be restricted by their device. I implemented this by designing a distributed client-server architecture relying on standard web technologies communicating with RESTful APIs. It is critical to consider the user's needs early in the design phase; otherwise, you risk engineering a technically sound application that ultimately fails because it doesn't fit the client's actual use case or target audience.

### Future Strategies for Software Design
My approach to this project was holistic, starting from abstract domain modeling and moving down to specific hardware/OS considerations like memory paging and storage journaling. In the future, I plan to integrate more **Agile strategies** into my design process, using specific User Stories to drive the architectural requirements. Additionally, as I analyze larger applications, I will look into cloud-native strategies or microservice architectures to better handle future scaling.
