# CS-255: System Analysis and Design

This repository contains the system design documentation for **DriverPass**, a project completed for my CS-255 System Analysis and Design course. Below is a reflection on the design process, the creation of UML diagrams, and my growth in software architecture.

## 📝 Project Reflection

### The Client and System Requirements
The client for this project was **DriverPass**, a driving school that needed a modern scheduling solution. They wanted a cloud based, cross platform web application to allow customers to schedule driving lessons without downloading special software. The system required role based access control (separating customers from IT officers), a relational database to track instructors, vehicles, and lessons, and built in logic to prevent double booking.

### Documentation Strengths
I believe I did particularly well at translating the client's raw requirements into clear, visual UML diagrams. By creating comprehensive Use Case, Activity, Sequence, and Class diagrams, I was able to visually map out exactly how the user interacts with the system and how the backend database connects entities like Customers, Lessons, and Vehicles before any code was written.

### Areas for Improvement and Revision
If I could revise one part of my work, I would expand on the technical requirements section regarding the cloud infrastructure. Instead of just stating the system needs to "run in the cloud," I would improve the document by proposing specific cloud services (like AWS EC2 for hosting or Amazon RDS for the relational database) to give the client a more concrete architectural roadmap.

### Interpreting and Implementing User Needs
I interpreted the user's need for simplicity by designing a system that requires no downloads and relies heavily on role based dashboards. This means a customer only sees their specific scheduling options, reducing clutter and confusion. It is incredibly important to consider the user's needs during the design phase because a technically flawless system is useless if it frustrates the people trying to use it. Fast load times and automatic conflict popups were prioritized specifically to address user frustration.

### Future Strategies for Software Design
My approach to designing software is heavily visual; I prefer to map out the entire user flow and database architecture using UML diagrams before outlining the technical specifications. In the future, I plan to incorporate Agile feedback loops earlier in the design process. By validating my UML diagrams against specific user stories and personas, I can ensure the architecture aligns perfectly with the end user's expectations before development begins.
