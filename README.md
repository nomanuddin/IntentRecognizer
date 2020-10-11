# IntentRecognizer
Intent recognition command-line application

#### Requirements for running app:
- Clone application from Github in any IDE
- Setup JDK 11 in your environment
- Configure Gradle for building the application (Preferred: Gradle 6.6 or later)
- Create run configuration from IntentApp Class and run the application

#### Predefined use cases:
- What is the weather like today? (Intent: Get Weather)
- What is the weather like in Paris today? (Intent: Get Weather City)
- What is the weather like in New York today? (Intent: Get Weather City)
- Am I free at 13:00 PM tomorrow? (Intent: Check Calendar)
- Tell me an interesting fact. (Intent: Get Fact)

#### Code logic explanation:
- Step 1: Keywords are checked in the string
- Step 2: Respective class is instantiated, and the relative method is called
- Step 3: Required intent and info is displayed
- Step 4: EXIT/exit keyword entered as question breaks the loop and application is closed

#### API's used:
- Open weather api is used for getting weather info
(if city is not requested them Karlsruhe weather is displayed)
- Chuck Norris api is printing facts

#### Future work:
- Regex/ Question parser implementation
- Adding calendar api
- Adding more unit tests
- Using timeout in the main method loop logic