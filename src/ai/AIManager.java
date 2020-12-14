package ai;

import ai.state.AIState;
import ai.state.Stand;
import ai.state.Wander;
import entity.NPC;
import state.State;

public class AIManager {

    private AIState currentAIState;

    public AIManager() {
        transitionTo("quieto");
    }

    public void update(State state, NPC currentCharacter) {
        currentAIState.update(state, currentCharacter);

        if(currentAIState.shouldTransition(state, currentCharacter)) {
            transitionTo(currentAIState.getNextState());
        }
    }

    private void transitionTo(String nextState) {
        switch(nextState) {
            case "wander":
                currentAIState = new Wander();
                return;
            case "quieto":
            default:
                currentAIState = new Stand();
        }
    }
}
