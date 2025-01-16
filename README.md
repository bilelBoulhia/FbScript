# FbScript

 a Java-based automation script for mass  leaving groups on Facebook.

## Getting Started

To run this project locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/bilelBoulhia/FbScript.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd FbScript
   ```

3. **Build the Project**:
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   Execute the script using:
   ```bash
   java -jar target/massLeave-1.0-SNAPSHOT.jar
   ```
   Adjust any configurations or arguments as needed based on the script's functionality.

## Prerequisites

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (version 16 or higher)
- [Apache Maven](https://maven.apache.org/)
- [Google Chrome](https://www.google.com/chrome/) (latest version recommended)

## Dependencies

This project uses the following dependencies:

- **Selenium Support** (4.19.1): For Selenium utilities and framework support.
- **Selenium Chrome Driver** (4.19.1): For controlling the Chrome browser during automation tasks.

## Usage

1. Make sure you have Google Chrome installed and updated.
2. Ensure that the ChromeDriver binary matches the version of Chrome installed on your machine.
   - You can download the correct version of ChromeDriver from [here](https://sites.google.com/chromium.org/driver/).
3. Update the path to ChromeDriver in the script if necessary.

## Features

- Automates mass actions on Facebook, such as leaving multiple groups.
- Leverages Selenium for robust browser interaction.
- Configurable and extendable for additional automation tasks.

## Notes

- Use this script responsibly and adhere to the platform's terms of service.
- This project is for educational purposes only.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
