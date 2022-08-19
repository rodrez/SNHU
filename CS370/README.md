# CS370 Machine Learning - Deep Q Learning

In this project we learned how to implement a Deep Q Learning algorithm to find the shortest path to the treasure.

## Provided

Majority of the code provided except for the cell where the Q Learning algorithm core logic was implemented.

## Code Created

```python
# For each epoch:

    for epoch in range(n_epoch):
        loss = 0

        #    Agent_cell = randomly select a free cell
        agent_cell = random.choice(qmaze.free_cells)

        #    Reset the maze with agent set to above position
        #    Hint: Review the reset method in the TreasureMaze.py class.
        #    envstate = Environment.current_state
        qmaze.reset(agent_cell)
        is_game_over = False

        #    Hint: Review the observe method in the TreasureMaze.py class.
        # Set the initial state
        env_state = qmaze.observe()

        # Variable to count the episodes
        n_episodes = 0

        #    While state is not game over:
        #        previous_envstate = envstate
        #        Action = randomly choose action (left, right, up, down) either by exploration or by exploitation
        #        envstate, reward, game_status = qmaze.act(action)
        while not is_game_over:
            valid_actions = qmaze.valid_actions()

            # Breaks the loop if there are no more valid actions
            if not valid_actions:
                break

            # Saves the state into previous_state
            previous_env_state = env_state

            # Sets the next action
            if np.random.rand() < epsilon:
                action = random.choice(valid_actions)
            else:
                action = np.argmax(experience.predict(previous_env_state))

            #    Hint: Review the act method in the TreasureMaze.py class.
            #        episode = [previous_envstate, action, reward, envstate, game_status]
            #        Store episode in Experience replay object
            # Unpacks the state, the reward and the status of the game
            env_state, reward, game_status = qmaze.act(action)
            if game_status == 'win':
                win_history.append(1)
                is_game_over = True
            elif game_status == 'lose':
                win_history.append(0)
                is_game_over = True
            else:
                is_game_over = False

            # Save the experience
            episode = [previous_env_state, action, reward, env_state, is_game_over]

            #    Hint: Review the remember method in the GameExperience.py class.
            #        Train neural network model and evaluate loss
            experience.remember(episode)

            # We now increase the episode once
            n_episodes += 1

            #    Hint: Call GameExperience.get_data to retrieve training data (input and target) and pass to model.fit method
            #          to train the model. You can call model.evaluate to determine loss.
            #    If the win rate is above the threshold and your model passes the completion check, that would be your epoch.
            # Training the network
            inputs, targets = experience.get_data(data_size=data_size)
            model.fit(
                inputs,
                targets,
                epochs=8,
                batch_size=16,
                verbose=0,
            )
            loss = model.evaluate(inputs, targets, verbose=0)

        if len(win_history) > hsize:
            win_rate = sum(win_history[-hsize:]) / hsize
```


## What do computer scientists do and why does it matter?

Computer scientists are the people who develop new technologies and software. They design and create the apps, websites, and programs that we use every day. Computer scientists have a big responsibility to make sure that their creations are safe for their users. They also have to make sure that they are not violating privacy rights or copyright laws. In addition to creating new technologies, computer scientists also work on improving existing ones. They conduct research in order to find ways for computers to do more tasks or become faster.

## How do I approach a problem as a computer scientist?

When approaching a problem as a computer scientist, it is important to understand the problem. This means that one should have an idea of what is being done and why it needs to be done. One should also know what the desired outcome is for this problem.

There are some steps that one can take when solving a problem as a computer scientist. First, identify the goal or objective of the problem. Second, make sure that you understand your resources and constraints. Third, think about possible solutions or approaches to solving the problem by using your resources in an efficient way. Fourth, implement your solution and test it to see if it solves your problem or not. Fifth, reflect on why you made certain decisions and how they affected the outcome of your solution

## What are my ethical responsibilities to the end user and the organization?

Ethical responsibility is an important topic in computer science. Computer scientists should not just focus on creating a new technology or solving a technical problem, but also consider how their work may affect society as a whole. If a computer scientist is working for an organization, they should make sure that they are not harming people in any way and also respect their privacy to avoid any potential conflicts of interest.