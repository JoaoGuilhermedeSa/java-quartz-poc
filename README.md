# 2D RPG Game with Quartz

This project is a demo of a 2D RPG game that uses Quartz to schedule jobs.

## Getting Started

To run the project, you will need to have Java 17 and Maven installed.

1. Clone the repository:
```bash
git clone https://github.com/your-username/java-quartz.git
```
2. Navigate to the project directory:
```bash
cd java-quartz
```
3. Run the application:
```bash
mvnw spring-boot:run
```

The application will be running on `http://localhost:8080`.

## Endpoints

You can use a tool like `curl` or Postman to test the endpoints.

### Characters

*   **Create a new character:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"name": "Aragorn"}' http://localhost:8080/characters
```

*   **List all characters:**

```bash
curl http://localhost:8080/characters
```

### High Scores

*   **List all high scores:**

```bash
curl http://localhost:8080/highscores
```

### World Transfers

*   **Create a new world transfer request:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"character": {"id": 1}, "sourceWorld": "Middle-earth", "destinationWorld": "Valinor"}' http://localhost:8080/transfers
```

## Jobs

This project uses Quartz to schedule two jobs: `WorldTransferJob` and `UpdateHighScoreJob`.

### WorldTransferJob

This job is responsible for processing pending world transfer requests. It runs every 10 seconds.

When the job runs, it fetches all the pending world transfer requests from the database and processes them one by one. For each request, it updates the character's current world and sets the request's status to `COMPLETED`.

### UpdateHighScoreJob

This job is responsible for updating the high scores table. It is chained to the `WorldTransferJob`, which means that it runs after the `WorldTransferJob` is completed.

When the job runs, it clears the existing high scores, gets the top 5 characters by level, and saves them to the `HighScore` table.

### Listeners

This project also uses two listeners:

*   **GlobalJobListener:** This listener logs when a job is about to be executed, when its execution is vetoed, and when it has been executed.
*   **JobChainingListener:** This listener is responsible for chaining the `UpdateHighScoreJob` to the `WorldTransferJob`. When the `WorldTransferJob` is completed, this listener triggers the `UpdateHighScoreJob`.
