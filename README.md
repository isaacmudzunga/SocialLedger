# SocialLedger

SocialLedger is a web application that tracks expenses shared amongst friends. It is built using Java, Thymeleaf, HTML, and CSS.

## Features

- **User Authentication**: Each user logs in with a valid email address. To avoid the complexity of password or token-based authentication, only an email address is needed for login.

- **Expense Tracking**: An expense is anything that you spent money on. The application records what you spent your hard-earned money on, when you spent it, and how much you spent.

- **Payment Requests**: Sometimes, you might pay on behalf of someone else. In this app, you record the amount you paid as an expense, and you make a payment request for the share of that expense from the friend that you helped.

- **Payments**: A payment request is paid by the person who received the payment request to the person that sent the payment request. When a payment request is paid, the payment becomes an expense for the person that made the payment. Then, the expense of the person that sent the payment request is reduced by the amount paid back.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them.

### Installing

- Click on this link to download the repo of this project https://github.com/isaacmudzunga/SocialLedger
- You must have java installed in your machine
- Go to this path to start up the server src/main/java/socialledger/server/Server.java
- Follow instructions on the terminal to open the web application.

## Running the tests

Navigate to https://github.com/isaacmudzunga/TestsForSocialLedger for tests

## Built With

* Java - The programming language used.
* Thymeleaf - Server-side Java template engine for web applications.
* HTML/CSS - Used to structure and style the web application.

## Authors

* **Isaac Mudzunga**
  
## License

This project is licensed under the MIT License - see the LICENSE.md file for details
